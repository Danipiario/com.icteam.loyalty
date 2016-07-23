package com.icteam.loyalty.api.interfaces;

public interface IStatusReason extends ISelectable<String> {

    String getPluginId();

    /**
     * @return il valore della variabile code di tipo PsiType:Integer.
     */
    Integer getCode();

}