package com.icteam.loyalty.ui.dialog;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Shell;

import com.icteam.loyalty.api.Messages;
import com.icteam.loyalty.model.EMFModel;
import com.icteam.loyalty.model.provider.LoyaltyItemProviderAdapter;
import com.icteam.loyalty.model.template.AbstractEMFTemplate;
import com.icteam.loyalty.ui.model.VirtualViewEMFModel;

;

public class FilterTableEMFDialog<T extends AbstractEMFTemplate< ? >, D extends EMFModel> extends Dialog {

    private static final long serialVersionUID = -5998187813983480963L;

    private static final String FEATURE = "feature";
    private final WeakReference<VirtualViewEMFModel<T, D>> virtualViewEMFModelRef;
    private List<Button> chkFilterFeatures;

    public FilterTableEMFDialog(Shell parentShell, VirtualViewEMFModel<T, D> virtualViewEMFModel) {
        super(parentShell);
        setShellStyle(SWT.CLOSE | SWT.RESIZE | SWT.APPLICATION_MODAL);

        this.virtualViewEMFModelRef = new WeakReference<>(virtualViewEMFModel);
    }

    @Override
    protected Control createDialogArea(Composite parent) {
        Composite area = (Composite) super.createDialogArea(parent);

        Group group = new Group(area, SWT.NONE);
        group.setLayoutData(new GridData(GridData.FILL_BOTH));
        group.setLayout(new GridLayout(1, false));
        group.setText(Messages.get().filterTableDialog_Group);

        fillFilterFeatures(group);

        return area;
    }

    private void fillFilterFeatures(Composite area) {
        T template = virtualViewEMFModelRef.get().getTemplate();

        chkFilterFeatures = new ArrayList<>();

        List<EStructuralFeature> filterableFeatures = template.getDynamicFilterableFeatures();
        for (EStructuralFeature feature : filterableFeatures) {
            Button chkFilterProperty = new Button(area, SWT.CHECK);

            chkFilterProperty.setText(LoyaltyItemProviderAdapter.getDiplayName(template, feature));
            chkFilterProperty.setData(FEATURE, feature);
            chkFilterProperty.setSelection(template.getDynamicFilterFeatures().contains(feature));

            chkFilterFeatures.add(chkFilterProperty);
        }
    }

    @Override
    protected void okPressed() {
        updateFilterProperties();

        super.okPressed();
    }

    private void updateFilterProperties() {
        EList<EStructuralFeature> filterFeatures = ECollections.newBasicEList();

        for (Button chkFilterProperty : chkFilterFeatures) {
            if (chkFilterProperty.getSelection()) {
                filterFeatures.add((EStructuralFeature) chkFilterProperty.getData(FEATURE));
            }
        }

        virtualViewEMFModelRef.get().setFilterFeatures(filterFeatures, true);
    }

    @Override
    protected void configureShell(Shell newShell) {
        super.configureShell(newShell);

        newShell.setText(Messages.get().filterTableDialog_Title);
    }
}
