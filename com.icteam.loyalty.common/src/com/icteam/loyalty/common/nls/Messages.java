package com.icteam.loyalty.common.nls;

public class Messages {

	public String operatorNotFound;
	public String loginStatusLine;
	public String languageStatusLine;
	public String filterMessage;
	public String loadError;
	public String databaseStatusLine;
	public String databaseStatusLineTooltip;
	public String valueRequired;
	public String valueFormatInvalid;
	public String listNotEmpty;
	public String valueNotNull;
	public String validationError;
	public String save;

	public static Messages get() {
		return NLS.getUTF8Encoded(Messages.class);
	}

}
