package com.icteam.loyalty.ui.dialog;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

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
import com.icteam.loyalty.model.DtoModel;
import com.icteam.loyalty.model.template.AbstractTemplate;
import com.icteam.loyalty.ui.interfaces.IVirtualView;

public class FilterTableDialog<T extends AbstractTemplate< ? >, D extends DtoModel> extends Dialog {

    private static final String PROPERTY = "property";
    private static final long serialVersionUID = -5998187813983480963L;
    private final WeakReference<IVirtualView<T, D>> virtualViewRef;
    private List<Button> chkFilterProperties;

    public FilterTableDialog(Shell parentShell, IVirtualView<T, D> virtualView) {
        super(parentShell);
        setShellStyle(SWT.CLOSE | SWT.RESIZE | SWT.APPLICATION_MODAL);

        this.virtualViewRef = new WeakReference<>(virtualView);
    }

    @Override
    protected Control createDialogArea(Composite parent) {
        Composite area = (Composite) super.createDialogArea(parent);
        Group group = new Group(area, SWT.NONE);
        group.setLayoutData(new GridData(GridData.FILL_BOTH));
        group.setLayout(new GridLayout(1, false));
        group.setText(Messages.get().filterTableDialog_Group);

        fillFilterProperties(group);

        return area;
    }

    private void fillFilterProperties(Composite area) {
        T template = virtualViewRef.get().getTemplate();

        chkFilterProperties = new ArrayList<>();

        List<String> filterableProperties = template.getFilterableProperties();
        for (String property : filterableProperties) {
            Button chkFilterProperty = new Button(area, SWT.CHECK);

            chkFilterProperty.setText(Messages.get(template.getClass(), property));
            chkFilterProperty.setData(PROPERTY, property);

            chkFilterProperty.setSelection(template.getDynamicFilterProperties().contains(property));

            chkFilterProperties.add(chkFilterProperty);
        }
    }

    @Override
    protected void okPressed() {
        updateFilterProperties();

        super.okPressed();
    }

    private void updateFilterProperties() {
        List<String> filterProperties = new ArrayList<>();

        for (Button chkFilterProperty : chkFilterProperties) {
            if (chkFilterProperty.getSelection()) {
                filterProperties.add((String) chkFilterProperty.getData(PROPERTY));
            }
        }

        virtualViewRef.get().setFilterProperties(filterProperties, true);
    }

    @Override
    protected void configureShell(Shell newShell) {
        super.configureShell(newShell);

        newShell.setText(Messages.get().filterTableDialog_Title);
    }

}
