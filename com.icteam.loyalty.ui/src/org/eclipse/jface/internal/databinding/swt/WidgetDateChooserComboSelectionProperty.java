/*******************************************************************************
 * Copyright (c) 2009 Matthew Hall and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Matthew Hall - initial API and implementation (bug 169876)
 *     Matthew Hall - bug 271720
 ******************************************************************************/

package org.eclipse.jface.internal.databinding.swt;

import java.util.Date;

import org.eclipse.jface.databinding.swt.WidgetValueProperty;
import org.eclipse.nebula.widgets.datechooser.DateChooserCombo;
import org.eclipse.swt.SWT;

/**
 * @since 3.2
 *
 */
public class WidgetDateChooserComboSelectionProperty extends WidgetValueProperty {
    /**
     *
     */
    public WidgetDateChooserComboSelectionProperty() {
        super(SWT.Selection);
    }

    @Override
    public Object getValueType() {
        return Date.class;
    }

    @Override
    protected Object doGetValue(Object source) {
        DateChooserCombo dateTime = (DateChooserCombo) source;

        return dateTime.getValue();
    }

    @Override
    protected void doSetValue(Object source, Object value) {
        DateChooserCombo dateTime = (DateChooserCombo) source;

        dateTime.setValue((Date) value);
    }
}
