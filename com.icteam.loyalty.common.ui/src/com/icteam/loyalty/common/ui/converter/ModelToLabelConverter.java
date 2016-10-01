package com.icteam.loyalty.common.ui.converter;

import java.io.Serializable;

import org.eclipse.core.databinding.conversion.Converter;
import org.eclipse.core.databinding.conversion.IConverter;

import com.icteam.loyalty.common.nls.NLS;

public class ModelToLabelConverter extends Converter implements IConverter {

	public ModelToLabelConverter() {
		super(Serializable.class, String.class);
	}

	@Override
	public Object convert(Object fromObject) {
		if (fromObject == null) {
			return "";
		}

		return NLS.get(fromObject.getClass(), fromObject.toString());
	}
}