package com.icteam.loyalty.ui.dialog;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.internal.databinding.BindingStatus;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecp.view.spi.horizontal.model.VHorizontalFactory;
import org.eclipse.emf.ecp.view.spi.horizontal.model.VHorizontalLayout;
import org.eclipse.emf.ecp.view.spi.model.VControl;
import org.eclipse.emf.ecp.view.spi.model.VView;
import org.eclipse.emf.ecp.view.spi.model.VViewFactory;
import org.eclipse.emf.ecp.view.spi.vertical.model.VVerticalFactory;
import org.eclipse.emf.ecp.view.spi.vertical.model.VVerticalLayout;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;

import com.icteam.loyalty.api.Messages;
import com.icteam.loyalty.model.EAnnotationClosure;
import com.icteam.loyalty.model.EMFModel;
import com.icteam.loyalty.model.interfaces.EAnnotation;
import com.icteam.loyalty.model.interfaces.EWhereClauseEMF;
import com.icteam.loyalty.model.template.AbstractEMFTemplate;
import com.icteam.loyalty.model.util.ModelUtil;
import com.icteam.loyalty.ui.control.SWTRenderUtil;
import com.icteam.loyalty.ui.model.VirtualViewEMFModel;
import com.icteam.loyalty.ui.util.BinderUtils;

public class AdvancedSearchEMFDialog<T extends AbstractEMFTemplate< ? >, D extends EMFModel> extends Dialog {

    private static final long serialVersionUID = -5998187813983480963L;

    private final WeakReference<VirtualViewEMFModel<T, D>> virtualViewEMFModelRef;

    private T template;

    private static int CLEAR_ALL = IDialogConstants.CLIENT_ID | 1;

    List<EStructuralFeature> wheres;

    private Composite area;

    public AdvancedSearchEMFDialog(Shell parentShell, VirtualViewEMFModel<T, D> virtualViewEMFModel) {
        super(parentShell);
        setShellStyle(SWT.CLOSE | SWT.RESIZE | SWT.APPLICATION_MODAL);

        this.virtualViewEMFModelRef = new WeakReference<>(virtualViewEMFModel);
    }

    @Override
    protected void createButtonsForButtonBar(Composite parent) {
        Button btnClear = createButton(parent, CLEAR_ALL, Messages.get().advancedSearchDialog_ClearFilter, false);
        btnClear.setImage(SWTResourceManager.getImage(AdvancedSearchEMFDialog.class, "/icons/clear.gif"));

        Button btnFoo = createButton(parent, -1, "", false);
        btnFoo.setVisible(false);

        super.createButtonsForButtonBar(parent);
    }

    @Override
    protected Control createDialogArea(Composite parent) {
        area = (Composite) super.createDialogArea(parent);
        area.setLayoutData(new GridData(GridData.FILL_BOTH));
        area.setLayout(new GridLayout(2, false));

        template = ModelUtil.copy(getVirtualViewEMFModel().getTemplate());

        fillView();

        return area;
    }

    private VirtualViewEMFModel<T, D> getVirtualViewEMFModel() {
        return virtualViewEMFModelRef.get();
    }

    private void fillView() {
        wheres = new ArrayList<>();

        ModelUtil.forAllDo(template.eClass(), new EAnnotationClosure<EWhereClauseEMF>(EAnnotation.CLAUSE) {
            @Override
            public void execute(EStructuralFeature feature, EWhereClauseEMF value) {
                if (!EWhereClauseEMF.NONE.equals(value)) {
                    wheres.add(feature);
                }
            }
        });

        ModelUtil.sort(wheres);

        SWTRenderUtil.render(null, area, template, createView());
    }

    private VView createView() {
        VView view = VViewFactory.eINSTANCE.createView();
        VHorizontalLayout horizontalLayout = VHorizontalFactory.eINSTANCE.createHorizontalLayout();
        view.getChildren().add(horizontalLayout);

        VVerticalLayout verticalLayout = VVerticalFactory.eINSTANCE.createVerticalLayout();
        horizontalLayout.getChildren().add(verticalLayout);

        for (int i = 0; i < Math.round(wheres.size() / 2.); i++) {
            VControl control = VViewFactory.eINSTANCE.createControl();

            control.setDomainModelReference(wheres.get(i));
            control.setReadonly(false);

            verticalLayout.getChildren().add(control);
        }

        verticalLayout = VVerticalFactory.eINSTANCE.createVerticalLayout();

        for (int i = (int) Math.round(wheres.size() / 2.); i < wheres.size(); i++) {
            VControl control = VViewFactory.eINSTANCE.createControl();

            control.setDomainModelReference(wheres.get(i));
            control.setReadonly(false);

            verticalLayout.getChildren().add(control);
        }

        if (!verticalLayout.getChildren().isEmpty()) {
            horizontalLayout.getChildren().add(verticalLayout);
        }

        return view;
    }

    @Override
    protected void okPressed() {
        BindingStatus bindingStatus = BinderUtils.validateControls(getDialogArea());

        if (!bindingStatus.isOK()) {
            ErrorDialog.openError(null, "", Messages.get().validation_error, bindingStatus);
        } else {
            getVirtualViewEMFModel().setAdvancedSearchTemplate(template);

            super.okPressed();
        }
    }

    @Override
    protected void buttonPressed(int buttonId) {
        if (buttonId == CLEAR_ALL) {
            getVirtualViewEMFModel().buildTemplate().copyTo(template, true);
        } else {
            super.buttonPressed(buttonId);
        }
    }

    @Override
    protected void configureShell(Shell newShell) {
        super.configureShell(newShell);

        newShell.setText(Messages.get().advancedSearchDialog_Title);
    }

}
