package com.icteam.loyalty.ui.listener;

import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;

import com.icteam.loyalty.model.interfaces.IDtoModel;
import com.icteam.loyalty.model.interfaces.OrderDirection;
import com.icteam.loyalty.model.template.AbstractTemplate;
import com.icteam.loyalty.ui.interfaces.IVirtualView;

public class VirtualSortSelectionListener<T extends AbstractTemplate< ? >, D extends IDtoModel> extends DefaultSortSelectionListener {

    private static final long serialVersionUID = -5335144747231037618L;

    private final T template;
    private final IVirtualView<T, D> virtualView;

    public VirtualSortSelectionListener(IVirtualView<T, D> virtualView, Class< ? extends Object> beanClass, String propertyName) {
        super((TableViewer) virtualView.getColumnViewer(), beanClass, propertyName);

        this.virtualView = virtualView;
        this.template = virtualView.getTemplate();
    }

    @Override
    protected void handleSort() {
        template.setDynamicOrder(propertyName, convert(getTable().getSortDirection()));

        virtualView.reload(true);
    }

    private static OrderDirection convert(int direction) {
        switch (direction) {
            case SWT.UP:
                return OrderDirection.ASC;
            case SWT.DOWN:
                return OrderDirection.DESC;
            default:
                return null;
        }
    }
}