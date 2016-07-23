package com.icteam.loyalty.ui.util;

import java.util.Iterator;

import org.apache.commons.lang.BooleanUtils;
import org.apache.commons.lang.StringUtils;
import org.eclipse.core.databinding.property.value.IValueProperty;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecp.view.spi.context.ViewModelContext;
import org.eclipse.emf.ecp.view.spi.model.ModelReferenceHelper;
import org.eclipse.emf.ecp.view.spi.model.VControl;
import org.eclipse.emf.ecp.view.spi.model.VDomainModelReference;
import org.eclipse.emf.ecp.view.spi.model.VFeaturePathDomainModelReference;
import org.eclipse.emfforms.spi.core.services.databinding.DatabindingFailedException;
import org.eclipse.emfforms.spi.core.services.databinding.EMFFormsDatabinding;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.rap.rwt.RWT;
import org.eclipse.rap.rwt.client.service.JavaScriptExecutor;
import org.eclipse.rap.rwt.internal.RWTProperties;
import org.eclipse.rap.rwt.widgets.WidgetUtil;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.ToolTip;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

import com.icteam.loyalty.api.AppException;
import com.icteam.loyalty.api.interfaces.IStatusReason;
import com.icteam.loyalty.model.ModelProperties;
import com.icteam.loyalty.model.interfaces.EAnnotation;
import com.icteam.loyalty.model.util.ModelUtil;
import com.icteam.loyalty.ui.provider.UIEditPlugin;
import com.icteam.loyalty.ui.validator.LoyaltyDiagnostician;

public class UIUtils {

    public static void showException(Shell shell, String message, AppException e) {
        IStatusReason statusReason = e.getStatusReason();
        Status status = new Status(IStatus.ERROR, statusReason.getPluginId(), statusReason.getCode(), e.getLocalizedMessage(), e);

        ErrorDialog.openError(shell, "", message, status);

    }

    public static void showTooltip(Shell shell, AppException ae) {
        final ToolTip toolTip = new ToolTip(shell, SWT.ICON_WARNING);

        toolTip.setText(ae.getLocalizedMessage());
        toolTip.setVisible(true);

        Display.getCurrent().timerExec(ModelProperties.getInstance().tooltipShowTimeMillis(), new Runnable() {
            @Override
            public void run() {
                toolTip.setVisible(false);
                toolTip.dispose();
            }
        });
    }

    public static boolean uiTestsEnabled() {
        return BooleanUtils.toBoolean(System.getProperty(RWTProperties.ENABLE_UI_TESTS));
    }

    public static void setTestId(Widget widget, String value) {
        if (uiTestsEnabled() && !widget.isDisposed()) {
            String $el = widget instanceof Text ? "$input" : "$el";
            String id = WidgetUtil.getId(widget);

            exec("rap.getObject( '", id, "' ).", $el, ".attr( 'test-id', '", value + "' );");
        }
    }

    private static void exec(String... strings) {
        StringBuilder builder = new StringBuilder();
        builder.append("try{");
        for (String str : strings) {
            builder.append(str);
        }

        builder.append("}catch(e){}");

        JavaScriptExecutor executor = RWT.getClient().getService(JavaScriptExecutor.class);
        executor.execute(builder.toString());
    }

    public static boolean isImpersonate() {
        return RWT.getRequest().getRequestURI().contains("impersonate");
    }

    public static EList<VFeaturePathDomainModelReference> getColumnDomainModelReferences(EClass eClass) {
        EList<VFeaturePathDomainModelReference> columnDomainModelReferences = ECollections.newBasicEList();

        for (EStructuralFeature structuralFeature : eClass.getEAllStructuralFeatures()) {
            Boolean showAsColumn = (Boolean) ModelUtil.getAnnotation(structuralFeature, EAnnotation.SHOW_AS_COLUMN,
                    structuralFeature instanceof EReference ? Boolean.FALSE : EAnnotation.SHOW_AS_COLUMN.getDefaultValue());

            if (Boolean.valueOf(showAsColumn)) {
                columnDomainModelReferences
                        .add((VFeaturePathDomainModelReference) ModelReferenceHelper.createDomainModelReference(structuralFeature, ECollections.<EReference> emptyEList()));
            }
        }

        String columnsToShowRaw = (String) ModelUtil.getAnnotation(eClass, EAnnotation.COLUMNS_TO_SHOW);
        VFeaturePathDomainModelReference domainModelReference = calculateFeaturePathDomainModelReference(eClass, columnsToShowRaw);

        if (domainModelReference != null) {
            columnDomainModelReferences.add(domainModelReference);
        }

        return columnDomainModelReferences;
    }

    public static VFeaturePathDomainModelReference calculateFeaturePathDomainModelReference(EClass eClass, String featurePath) {
        VFeaturePathDomainModelReference domainModelReference = null;
        if (featurePath != null) {
            String[] columnsToShow = StringUtils.stripAll(featurePath.split(";"));

            for (String columnToShow : columnsToShow) {
                String[] features = StringUtils.stripAll(columnToShow.split("\\."));
                EList<EReference> references = ECollections.<EReference> newBasicEList();

                int index = features.length - 1;

                computeReferences(references, eClass, features, 0);

                EStructuralFeature feature = null;
                if (!references.isEmpty()) {
                    if (features.length == 1) {
                        feature = eClass.getEStructuralFeature(features[index]);
                    } else {
                        feature = references.get(index - 1).getEReferenceType().getEStructuralFeature(features[index]);
                    }
                }

                if (feature != null) {
                    domainModelReference = (VFeaturePathDomainModelReference) ModelReferenceHelper.createDomainModelReference(feature, references);
                } else {
                    UIEditPlugin.INSTANCE.log("Column to show not found for feature #" + features[index]);
                }
            }
        }
        return domainModelReference;
    }

    public static void computeReferences(EList<EReference> references, EModelElement modelElement, String[] features, int index) {
        if (features.length - 1 > index) {
            EStructuralFeature feature = ModelUtil.getEStructuralFeature(modelElement, features[index]);

            if (feature != null) {
                references.add((EReference) feature);
                computeReferences(references, feature, features, ++index);
            } else {
                UIEditPlugin.INSTANCE.log("Column to show not found for nested feature #" + features[index]);
            }
        }
    }

    public static Setting getLastFeatureSetting(VDomainModelReference domainModelReference, Object element) {
        final VDomainModelReference copy = initDomainModelReference(domainModelReference, element);

        final Iterator<Setting> iterator = copy.getIterator();

        Setting result = null;

        while (iterator.hasNext()) {
            result = iterator.next();
        }

        return result;

    }

    public static VDomainModelReference initDomainModelReference(VDomainModelReference domainModelReference, Object element) {
        final InternalEObject eObject = InternalEObject.class.cast(element);
        final VDomainModelReference copy = EcoreUtil.copy(domainModelReference);

        copy.init(eObject);

        return copy;
    }

    public static IWorkbenchPage getActivePage() {
        IWorkbenchWindow workbenchWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();

        if (workbenchWindow != null) {
            return workbenchWindow.getActivePage();
        }

        return null;
    }

    public static Diagnostic validate(EObject eObject) {
        return new LoyaltyDiagnostician(eObject).validate(eObject);
    }

    public static EStructuralFeature getEStructuralFeature(EMFFormsDatabinding databindingService, VControl vControl, ViewModelContext viewModelContext) {
        EStructuralFeature structuralFeature = null;
        try {
            IValueProperty valueProperty = databindingService.getValueProperty(vControl.getDomainModelReference(), viewModelContext.getDomainModel());
            structuralFeature = (EStructuralFeature) valueProperty.getValueType();
        } catch (DatabindingFailedException e) {
            e.printStackTrace();
        }

        return structuralFeature;

    }

}
