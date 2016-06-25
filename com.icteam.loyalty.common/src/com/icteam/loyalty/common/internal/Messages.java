package com.icteam.loyalty.common.internal;

import com.icteam.loyalty.common.nls.NLS;

public class Messages {

	public String operator_not_found;

	public static Messages get() {
		return NLS.getUTF8Encoded(Messages.class);
	}

}
