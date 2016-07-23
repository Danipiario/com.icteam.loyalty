package com.icteam.loyalty.model.interfaces;

/**
 * Indica come vengono trattati i null negli attributi del template e nei record estratti per i metodi
 * che dichiarano l'utilizzo del search mode (buildWhereXXXUseSearchMode)
 */
public enum ESearchMode {
    /**
     * Se viene impostato un attributo nel template, vengono estratti i record che matchano l'attributo e i record che hanno attributo nullo.
     * Se non viene impostato un attributo, vengono estratti i record che hanno attributo nullo
     */
    POLICY,

    /**
     * Se viene impostato un attributo nel template, vengono estratti solo i record che matchano l'attributo.
     * Se non viene impostato un attributo, non viene impostato nessun filtro su tale attributo
     */
    DEFAULT
}