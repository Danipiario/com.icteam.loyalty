package com.icteam.loyalty.model.interfaces;

public enum EWhereClause {
    EQUAL, LIKE_IGNORE_CASE, I18N, GREATER_EQUAL;

    public boolean isI18N() {
        return equals(I18N);
    }

    public static boolean isI18N(String clause) {
        return I18N.name().equalsIgnoreCase(clause);
    }

    public static EWhereClause getFromString(String clause) {
        if (clause == null) {
            return EWhereClause.EQUAL;
        }

        return valueOf(clause);
    }

}
