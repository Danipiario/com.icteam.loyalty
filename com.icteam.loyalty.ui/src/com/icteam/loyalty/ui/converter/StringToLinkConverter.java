package com.icteam.loyalty.ui.converter;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.StringUtils;
import org.eclipse.core.databinding.conversion.Converter;
import org.eclipse.core.databinding.conversion.IConverter;
import org.eclipse.rap.rwt.RWT;

import com.icteam.loyalty.model.interfaces.Link;

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

        String requestURI = RWT.getRequest().getRequestURI(); // ritorna /icteam/loyalty

        return "<a href='"
                + StringEscapeUtils.escapeHtml(requestURI + RWT.getServiceManager().getServiceHandlerUrl("download"))
                + "&amp;"
                + "filename"
                + '='
                + link.value()
                + '/'
                + fromObject
                + "'>"
                + fromObject
                + "</a>";
    }
}
