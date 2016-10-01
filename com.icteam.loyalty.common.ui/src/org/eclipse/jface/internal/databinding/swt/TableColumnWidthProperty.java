/*******************************************************************************
 * Copyright (c) 2008, 2009 Matthew Hall and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Matthew Hall - initial API and implementation
 *     Tom Schindl - initial API and implementation
 *     Matthew Hall - bug 195222, 263413
 ******************************************************************************/

package org.eclipse.jface.internal.databinding.swt;

import org.eclipse.jface.databinding.swt.WidgetValueProperty;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.TableColumn;

/**
 * @since 3.3
 *
 */
public class TableColumnWidthProperty extends WidgetValueProperty {
    /**
     *
     */
    public TableColumnWidthProperty() {
        super(SWT.Resize);
    }

    @Override
    public Object getValueType() {
        return int.class;
    }

    @Override
    protected Object doGetValue(Object source) {
        return ((TableColumn) source).getWidth();
    }

    @Override
    protected void doSetValue(Object source, Object value) {
        ((TableColumn) source).setWidth((int) value);
    }

    @Override
    public String toString() {
        return "TableColumn.width <int>"; //$NON-NLS-1$
    }
}
