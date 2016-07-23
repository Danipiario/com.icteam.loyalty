package com.icteam.loyalty.model.interfaces;

/**
 * IStatusTemplate
 */
public interface IStatusTemplate {
    /**
     * Setta los tato
     *
     * @param status EStatus
     */
    void setStatus(EStatus status);

    /**
     * Ritorna lo stato
     *
     * @return EStatus
     */
    EStatus getStatus();

}
