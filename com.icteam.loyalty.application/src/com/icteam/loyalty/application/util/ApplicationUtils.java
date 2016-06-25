package com.icteam.loyalty.application.util;

import org.eclipse.rap.rwt.RWT;

public class ApplicationUtils {

	public static boolean isImpersonate() {
		return RWT.getRequest().getRequestURI().contains("impersonate");
	}
}
