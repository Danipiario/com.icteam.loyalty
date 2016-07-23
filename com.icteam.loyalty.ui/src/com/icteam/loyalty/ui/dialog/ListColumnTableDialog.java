package com.icteam.loyalty.ui.dialog;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.viewers.ColumnViewer;
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
import org.eclipse.swt.widgets.Item;
import org.eclipse.swt.widgets.Shell;

import com.icteam.loyalty.api.Messages;
import com.icteam.loyalty.model.DtoModel;
import com.icteam.loyalty.model.template.AbstractTemplate;
import com.icteam.loyalty.ui.interfaces.IData;
import com.icteam.loyalty.ui.interfaces.IVirtualView;
import com.icteam.loyalty.ui.util.TableTreeUtils;

public class ListColumnTableDialog<T extends AbstractTemplate< ? >, D extends DtoModel> extends Dialog {

    private static final long serialVersionUID = 2393326212108238190L;

    private final IVirtualView<T, D> virtualView;
    private final Map<Item, Button> mapListColumns = new HashMap<>();

    public ListColumnTableDialog(Shell parentShell, IVirtualView<T, D> virtualView) {
        super(parentShell);
        setShellStyle(SWT.CLOSE | SWT.RESIZE | SWT.APPLICATION_MODAL);

        this.virtualView = virtualView;
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
        group.setLayout(new GridLayout(1, false));
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
        ColumnViewer tableViewer = virtualView.getColumnViewer();

        Control control = tableViewer.getControl();

        for (Item column : TableTreeUtils.getColumns(control)) {
            Button chkListColumn = new Button(area, SWT.CHECK);
            String name = column.getText();

            chkListColumn.setText(name);
            chkListColumn.setSelection(TableTreeUtils.getColumnWidth(column) != 0);

            mapListColumns.put(column, chkListColumn);
        }
    }

    @Override
    protected void okPressed() {
        updateListColumns();

        super.okPressed();
    }

    private void updateListColumns() {
        virtualView.getColumnViewer().getControl().setRedraw(false);

        try {
            for (Entry<Item, Button> hideColumnEntry : mapListColumns.entrySet()) {
                Item column = hideColumnEntry.getKey();
                Button chkListColumn = hideColumnEntry.getValue();

                if (chkListColumn.getSelection()) {
                    column.setData(IData.ZERO_LENGTH, null);

                    Object data = column.getData(IData.WIDTH);

                    if (data != null) {
                        int oldWidth = (int) data;
                        TableTreeUtils.setColumnWidth(column, oldWidth);
                    }
                } else {
                    if (TableTreeUtils.getColumnWidth(column) != 0) {
                        column.setData(IData.WIDTH, TableTreeUtils.getColumnWidth(column));
                        column.setData(IData.ZERO_LENGTH, true);
                        TableTreeUtils.setColumnWidth(column, 0);
                    }
                }
            }
        } finally {
            virtualView.getColumnViewer().getControl().setRedraw(true);
        }
    }

    @Override
    protected void configureShell(Shell newShell) {
        super.configureShell(newShell);

        newShell.setText(Messages.get().listColumnTableDialog_Title);
    }

}
