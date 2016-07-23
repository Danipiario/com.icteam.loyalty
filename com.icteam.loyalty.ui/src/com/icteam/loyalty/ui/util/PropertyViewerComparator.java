package com.icteam.loyalty.ui.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.apache.commons.beanutils.PropertyUtils;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Item;

import com.icteam.loyalty.api.Messages;
import com.icteam.loyalty.api.interfaces.EnhancedEnum;
import com.icteam.loyalty.ui.interfaces.IData;
import com.icteam.loyalty.ui.interfaces.IPropertyViewerComparator;

public class PropertyViewerComparator extends ViewerComparator implements IPropertyViewerComparator {

    private static final long serialVersionUID = 5722576534872120000L;

    private String propertyName;
    private int sortDirection;
    private Method readMethod = null;

    @Override
    public void setSortColumn(Item column) {
        if (column == null) {
            propertyName = null;
        } else {
            propertyName = (String) column.getData(IData.COLUMN_NAME);
        }

        readMethod = null;
    }

    @Override
    public void setSortDirection(int sortDirection) {
        this.sortDirection = sortDirection;
    }

    @Override
    public int compare(Viewer viewer, Object e1, Object e2) {
        int c = 0;
        if (propertyName != null) {
            try {
                Object o1 = null;
                Object o2 = null;

                if (e1 instanceof EnhancedEnum) {
                    o1 = Messages.get(((EnhancedEnum< ? , ? >) e1).getDescription());
                    o2 = Messages.get(((EnhancedEnum< ? , ? >) e2).getDescription());
                } else {
                    Method getter = getReadMethod(e1);

                    o1 = getter.invoke(e1, (Object[]) null);
                    o2 = getter.invoke(e2, (Object[]) null);
                }

                if (o1 instanceof Comparable) {
                    c = ((Comparable<Object>) o1).compareTo(o2);
                } else {
                    c = getComparator().compare(o1.toString(), o2.toString());
                }
            } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                e.printStackTrace();
            }
        }

        if (sortDirection == SWT.DOWN) {
            c = -c;
        }

        return c;
    }

    private Method getReadMethod(Object e1) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        if (readMethod == null) {
            readMethod = PropertyUtils.getReadMethod(PropertyUtils.getPropertyDescriptor(e1, propertyName));
        }

        return readMethod;
    }

    @Override
    public boolean isSorterProperty(Object element, String property) {
        return property.equals(propertyName);
    }

}
