package com.icteam.loyalty.ui.dialog;

import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.core.internal.databinding.BindingStatus;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;

import com.icteam.loyalty.api.Messages;
import com.icteam.loyalty.api.interfaces.EnhancedEnum;
import com.icteam.loyalty.model.AnnotationClosure;
import com.icteam.loyalty.model.DtoModel;
import com.icteam.loyalty.model.interfaces.Where;
import com.icteam.loyalty.model.template.AbstractTemplate;
import com.icteam.loyalty.model.util.ModelUtil;
import com.icteam.loyalty.ui.control.LabelCheck;
import com.icteam.loyalty.ui.control.LabelCombo;
import com.icteam.loyalty.ui.control.LabelText;
import com.icteam.loyalty.ui.interfaces.IModelControl;
import com.icteam.loyalty.ui.interfaces.IVirtualView;
import com.icteam.loyalty.ui.util.BinderUtils;
import com.icteam.loyalty.ui.util.ControlUtils;

public class AdvancedSearchDialog<T extends AbstractTemplate< ? >, D extends DtoModel> extends Dialog {

    private static final long serialVersionUID = -5998187813983480963L;

    private final WeakReference<IVirtualView<T, D>> virtualViewRef;

    private T template;

    private final Map<String, IModelControl<T, ? , ? >> modelControls = new HashMap<>();

    private static int CLEAR_ALL = IDialogConstants.CLIENT_ID | 1;

    public AdvancedSearchDialog(Shell parentShell, IVirtualView<T, D> virtualView) {
        super(parentShell);
        setShellStyle(SWT.CLOSE | SWT.RESIZE | SWT.APPLICATION_MODAL);

        this.virtualViewRef = new WeakReference<>(virtualView);
    }

    @Override
    protected void createButtonsForButtonBar(Composite parent) {
        Button btnClear = createButton(parent, CLEAR_ALL, Messages.get().advancedSearchDialog_ClearFilter, false);
        btnClear.setImage(SWTResourceManager.getImage(AdvancedSearchDialog.class, "/icons/clear.gif"));

        Button btnFoo = createButton(parent, -1, "", false);
        btnFoo.setVisible(false);

        super.createButtonsForButtonBar(parent);
    }

    @Override
    protected Control createDialogArea(Composite parent) {
        Composite area = (Composite) super.createDialogArea(parent);
        area.setLayoutData(new GridData(GridData.FILL_BOTH));
        area.setLayout(new GridLayout(2, false));

        fillSearchFields(area);

        ControlUtils.adjustLayout(parent);

        return area;
    }

    private void fillSearchFields(Composite area) {
        template = (T) virtualViewRef.get().getTemplate().clone();

        final List<Field> wheres = new ArrayList<>();

        ModelUtil.forAllDo(template.getClass(), new AnnotationClosure<Where>() {
            @Override
            public void execute(Field field, Where annotation) {
                wheres.add(field);
            }
        });

        Collections.sort(wheres, ModelUtil.propertyFieldComparator);

        for (Field field : wheres) {
            createModelControl(area, field);
        }

        initModelProperties();
    }

    private void createModelControl(Composite parent, Field field) {
        Class< ? > type = field.getType();

        IModelControl<T, ? , ? > modelControl = null;
        if (EnhancedEnum.class.isAssignableFrom(type)) {
            modelControl = new LabelCombo<>(parent, LabelCombo.NO_AUTO_SELECT);
        } else if (Boolean.class.isAssignableFrom(type)) {
            modelControl = new LabelCheck<>(parent);
        } else {
            modelControl = new LabelText<>(parent, SWT.NONE);
        }

        modelControls.put(field.getName(), modelControl);
    }

    private void initModelProperties() {
        for (Entry<String, IModelControl<T, ? , ? >> entry : modelControls.entrySet()) {
            IModelControl<T, ? , ? > modelControl = entry.getValue();

            modelControl.setModelProperty(template, entry.getKey());
        }
    }

    @Override
    protected void okPressed() {
        BindingStatus bindingStatus = BinderUtils.validateControls(getDialogArea());

        if (!bindingStatus.isOK()) {
            ErrorDialog.openError(null, "", Messages.get().validation_error, bindingStatus);
        } else {
            virtualViewRef.get().setAdvancedSearchTemplate(template);

            super.okPressed();
        }
    }

    @Override
    protected void buttonPressed(int buttonId) {
        if (buttonId == CLEAR_ALL) {
            template = virtualViewRef.get().getDefaultTemplate();

            initModelProperties();
        } else {
            super.buttonPressed(buttonId);
        }
    }

    @Override
    protected void configureShell(Shell newShell) {
        super.configureShell(newShell);

        newShell.setText(Messages.get().advancedSearchDialog_Title);
    }

}
