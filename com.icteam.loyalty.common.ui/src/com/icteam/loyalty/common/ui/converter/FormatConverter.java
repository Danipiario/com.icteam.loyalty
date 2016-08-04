package com.icteam.loyalty.common.ui.converter;

import java.text.MessageFormat;
import java.text.ParseException;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.core.databinding.conversion.Converter;
import org.eclipse.core.databinding.conversion.IConverter;

import com.icteam.loyalty.common.annotations.Format;

public class FormatConverter extends Converter implements IConverter {

	private final MessageFormat messageFormat;
	private final boolean toTarget;

	public static FormatConverter newTargetConverter(Class<?> propertyClass, Format format) {
		return new FormatConverter(propertyClass, String.class, format, true);
	}

	public static FormatConverter newModelConverter(Class<?> propertyClass, Format format) {
		return new FormatConverter(String.class, propertyClass, format, false);
	}

	FormatConverter(Class<?> fromType, Class<?> toType, Format format, boolean toTarget) {
		super(fromType, toType);

		messageFormat = new MessageFormat(format.value());
		this.toTarget = toTarget;
	}

	@Override
	public Object convert(Object fromObject) {
		if (toTarget) {
			if (fromObject == null) {
				return "";
			}

			return messageFormat.format(new Object[] { fromObject });
		}

		if (StringUtils.isEmpty((String) fromObject)) {
			return null;
		}

		try {
			return messageFormat.parseObject((String) fromObject);
		} catch (final ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
}