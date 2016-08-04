package com.icteam.loyalty.common.ui.converter;

import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
import org.eclipse.core.databinding.conversion.Converter;
import org.eclipse.core.databinding.conversion.IConverter;
import org.eclipse.rap.rwt.RWT;

import com.icteam.loyalty.common.annotations.Link;

public class StringToLinkConverter extends Converter implements IConverter {

	private final Link link;

	public StringToLinkConverter(Link link) {
		super(String.class, String.class);

		this.link = link;
	}

	@Override
	public Object convert(Object fromObject) {
		if (StringUtils.isBlank((String) fromObject)) {
			return "";
		}

		// ritorna /icteam/loyalty
		final String requestURI = RWT.getRequest().getRequestURI();

		return "<a href='"
				+ StringEscapeUtils.escapeHtml4(requestURI + RWT.getServiceManager().getServiceHandlerUrl("download"))
				+ "&amp;" + "filename" + '=' + link.value() + '/' + fromObject + "'>" + fromObject + "</a>";
	}
}
