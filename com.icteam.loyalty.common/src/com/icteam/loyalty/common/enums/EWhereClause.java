package com.icteam.loyalty.common.enums;

import java.util.Optional;

public enum EWhereClause {
	EQUAL, LIKE_IGNORE_CASE, GREATER_EQUAL;

	public static EWhereClause getFromString(String clause) {
		return valueOf(Optional.of(clause).orElse(EQUAL.name()));
	}

}
