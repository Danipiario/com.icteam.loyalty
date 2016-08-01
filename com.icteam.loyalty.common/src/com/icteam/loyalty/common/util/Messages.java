package com.icteam.loyalty.common.util;

import com.icteam.loyalty.common.nls.NLS;

public class Messages {

	public String operator_not_found;
	public String login_status_line;
	public String language_status_line;

	public static Messages get() {
		return NLS.getUTF8Encoded(Messages.class);
	}

}
