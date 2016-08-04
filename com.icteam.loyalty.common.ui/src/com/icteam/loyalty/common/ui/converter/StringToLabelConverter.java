package com.icteam.loyalty.common.ui.converter;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.core.databinding.conversion.Converter;
import org.eclipse.core.databinding.conversion.IConverter;

public class StringToLabelConverter extends Converter implements IConverter {

	public StringToLabelConverter() {
		super(String.class, String.class);
	}

	@Override
	public Object convert(Object fromObject) {
		return StringUtils.defaultString((String) fromObject) + ":";
	}
}