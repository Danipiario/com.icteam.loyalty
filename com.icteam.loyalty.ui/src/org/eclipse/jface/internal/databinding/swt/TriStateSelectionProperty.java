package org.eclipse.jface.internal.databinding.swt;

import org.eclipse.core.databinding.property.value.IValueProperty;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;

public class TriStateSelectionProperty extends WidgetDelegatingValueProperty {

    private IValueProperty button;

    @Override
    protected IValueProperty doGetDelegate(Object source) {
        if (source instanceof Button && (((Button) source).getStyle() & SWT.CHECK) != 0) {
            if (button == null) {
                button = new CheckButtonSelectionProperty();
            }
            return button;
        }

        throw notSupported(source);
    }
}
