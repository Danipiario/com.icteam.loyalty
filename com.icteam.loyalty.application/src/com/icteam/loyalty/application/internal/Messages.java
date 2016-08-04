package com.icteam.loyalty.application.internal;

import com.icteam.loyalty.common.nls.NLS;

public class Messages {

	public String pageTitle;
	public String login;
	public String password;
	public String needLogin;
	public String loginTitle;
	public String exitNotAllowed;
	public String confirm;
	public String confirmExit;

	public static Messages get() {
		return NLS.getUTF8Encoded(Messages.class);
	}

}
