
package com.icteam.loyalty.common.ui.editor;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

import com.icteam.loyalty.common.dto.OperatorDTO;
import com.icteam.loyalty.common.ui.control.LabelText;

public class OperatorEditor extends AbstractEditor<OperatorDTO> {

	private LabelText<OperatorDTO, String> loginTxt;
	private LabelText<OperatorDTO, String> nameTxt;
	private LabelText<OperatorDTO, String> surnameTxt;

	@Override
	protected void fillEditorArea(Composite ea) {
		loginTxt = new LabelText<>(ea, SWT.NONE);
		nameTxt = new LabelText<>(ea, SWT.NONE);
		surnameTxt = new LabelText<>(ea, SWT.NONE);
	}

	@Override
	protected void initCustomBindings() {
		super.initCustomBindings();

		loginTxt.setModelProperty(dto, "login");
		nameTxt.setModelProperty(dto, "name");
		surnameTxt.setModelProperty(dto, "surname");
	}

	@Override
	protected OperatorDTO internalSave() {
		return null;
	}

	@Override
	protected Control getFocusControl() {
		return null;
	}

}