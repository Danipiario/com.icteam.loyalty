package com.icteam.loyalty.common.ui.converter;

import org.eclipse.core.databinding.conversion.Converter;

import com.icteam.loyalty.common.nls.NLS;

public class BooleanToLabelConverter extends Converter {

	public BooleanToLabelConverter() {
		super(Boolean.class, String.class);
	}

	@Override
	public Object convert(Object fromObject) {
		if (fromObject == null) {
			return "";
		}

		return NLS.get(Boolean.class, fromObject.toString());
	}
}