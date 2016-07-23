package com.icteam.loyalty.model.interfaces;

import java.util.Date;

/**
 * IValidDate
 */
public interface IValidDateTemplate {
    /**
     * Ritorna ValidDate
     *
     * @return Date
     */
    Date getValidDate();

    /**
     * Setta ValidDate
     *
     * @param validDate Date
     */
    void setValidDate(Date validDate);

}