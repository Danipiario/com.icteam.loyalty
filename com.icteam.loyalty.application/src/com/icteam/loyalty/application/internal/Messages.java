package com.icteam.loyalty.application.internal;

import com.icteam.loyalty.common.nls.NLS;

public class Messages {

	public String page_title;
	public String login;
	public String password;
	public String need_login;
	public String login_title;
	public String exit_not_allowed;
	public String confirm;
	public String confirm_exit;

	public static Messages get() {
		return NLS.getUTF8Encoded(Messages.class);
	}

}
