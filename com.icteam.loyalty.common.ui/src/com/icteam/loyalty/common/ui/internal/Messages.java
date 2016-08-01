package com.icteam.loyalty.common.ui.internal;

import com.icteam.loyalty.common.nls.NLS;

public class Messages {

	public String filter_message;
	public String load_error;

	public static Messages get() {
		return NLS.getUTF8Encoded(Messages.class);
	}

}
