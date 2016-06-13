package com.icteam.loyalty.application;

import com.icteam.loyalty.common.api.nls.NLS;

public class Messages {

	public String login;
	public String password;
	public String need_login;
	public String login_title;

	public static Messages get() {
		return NLS.getUTF8Encoded(Messages.class);
	}

}
