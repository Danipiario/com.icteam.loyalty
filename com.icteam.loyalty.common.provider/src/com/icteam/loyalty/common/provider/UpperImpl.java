package com.icteam.loyalty.common.provider;

import org.osgi.service.component.annotations.Component;

import com.icteam.loyalty.common.api.Upper;

/**
 *
 */
@Component(name = "com.icteam.loyalty.common.upper")
public class UpperImpl implements Upper {

	@Override
	public String upper(String string) {
		return string.toUpperCase();
	}


}
