package com.icteam.loyalty.ui.dialog;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecp.view.spi.model.VFeaturePathDomainModelReference;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Shell;

import com.icteam.loyalty.api.Messages;
import com.icteam.loyalty.model.EMFModel;
import com.icteam.loyalty.model.provider.LoyaltyItemProviderAdapter;
import com.icteam.loyalty.model.template.AbstractEMFTemplate;
import com.icteam.loyalty.model.util.ModelUtil;
import com.icteam.loyalty.ui.model.VirtualViewEMFModel;
import com.icteam.loyalty.ui.util.UIUtils;

public class ViewSelectColumnEMFDialog<V extends VirtualViewEMFModel< ? extends AbstractEMFTemplate< ? >, ? extends EMFModel>> extends Dialog {

    private static final long serialVersionUID = 2393326212108238190L;

    private final V virtualViewEMFModel;
    private final Map<Entry<EStructuralFeature, Integer>, Button> mapListColumns = new HashMap<>();

    public ViewSelectColumnEMFDialog(Shell parentShell, V virtualViewEMFModel) {
        super(parentShell);
        setShellStyle(SWT.CLOSE | SWT.RESIZE | SWT.APPLICATION_MODAL);

        this.virtualViewEMFModel = virtualViewEMFModel;
    }

    protected void toggleSelection(boolean select) {
        for (Button cmdListColumn : mapListColumns.values()) {
            cmdListColumn.setSelection(select);
        }
    }

    @Override
    protected Control createDialogArea(Composite parent) {
        Composite area = (Composite) super.createDialogArea(parent);
        Group group = new Group(area, SWT.NONE);
        group.setLayoutData(new GridData(GridData.FILL_BOTH));
        group.setText(Messages.get().listColumnTableDialog_Group);

        fillColumnsTable(group);

        Composite cmdArea = new Composite(area, SWT.NONE);
        cmdArea.setLayout(new RowLayout(SWT.HORIZONTAL));

        Button selectAll = new Button(cmdArea, SWT.PUSH);
        selectAll.setText(Messages.get().selectAll);
        selectAll.addSelectionListener(new SelectionAdapter() {
            private static final long serialVersionUID = 1L;

            @Override
            public void widgetSelected(SelectionEvent e) {
                toggleSelection(true);
            }

        });

        Button deselectAll = new Button(cmdArea, SWT.PUSH);
        deselectAll.setText(Messages.get().deselectAll);
        deselectAll.addSelectionListener(new SelectionAdapter() {
            private static final long serialVersionUID = 1L;

            @Override
            public void widgetSelected(SelectionEvent e) {
                toggleSelection(false);
            }

        });

        return area;
    }

    private void fillColumnsTable(Composite area) {
        EObject eObject = EcoreUtil.create(ModelUtil.getEClass(virtualViewEMFModel.getBaseClass()));

        Map<EStructuralFeature, VFeaturePathDomainModelReference> columnDomainModelReferences = virtualViewEMFModel.getColumnDomainModelReferences();

        if (columnDomainModelReferences.size() > 3) {
            area.setLayout(new GridLayout(2, true));
        } else {
            area.setLayout(new GridLayout(1, true));
        }

        for (Entry<EStructuralFeature, Integer> column : virtualViewEMFModel.getColumnWidths()) {
            Button chkListColumn = new Button(area, SWT.CHECK);
            chkListColumn.setLayoutData(new GridData(GridData.FILL_BOTH));

            EStructuralFeature feature = column.getKey();
            VFeaturePathDomainModelReference domainModelReference = columnDomainModelReferences.get(feature);

            Setting setting = UIUtils.getLastFeatureSetting(domainModelReference, eObject);

            String name = LoyaltyItemProviderAdapter.getDiplayName(setting.getEObject(), setting.getEStructuralFeature());

            chkListColumn.setText(name);
            chkListColumn.setSelection(column.getValue() == null || column.getValue() != 0);

            mapListColumns.put(column, chkListColumn);
        }
    }

    @Override
    protected void okPressed() {
        updateListColumns();

        super.okPressed();
    }

    private void updateListColumns() {
        for (Entry<Entry<EStructuralFeature, Integer>, Button> hideColumnEntry : mapListColumns.entrySet()) {
            Entry<EStructuralFeature, Integer> column = hideColumnEntry.getKey();
            Button chkListColumn = hideColumnEntry.getValue();

            Integer newWidth = null;

            if (!chkListColumn.getSelection()) {
                newWidth = 0;
            }

            EMap<EStructuralFeature, Integer> columnWidths = virtualViewEMFModel.getColumnWidths();
            columnWidths.put(column.getKey(), newWidth);
        }
    }

    @Override
    protected void configureShell(Shell newShell) {
        super.configureShell(newShell);

        newShell.setText(Messages.get().listColumnTableDialog_Title);
    }

}
