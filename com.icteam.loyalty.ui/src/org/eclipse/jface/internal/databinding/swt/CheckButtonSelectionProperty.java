package org.eclipse.jface.internal.databinding.swt;

import org.eclipse.swt.widgets.Button;

public class CheckButtonSelectionProperty extends ButtonSelectionProperty {

    @Override
    protected Object doGetValue(Object source) {
        Button button = (Button) source;

        return button.getGrayed() ? null : super.doGetValue(source);
    }

    @Override
    protected void doSetValue(Object source, Object value) {
        Button button = (Button) source;

        if (value == null) {
            button.setGrayed(true);
        } else {
            button.setGrayed(false);
            super.doSetValue(source, value);
        }
    }
}