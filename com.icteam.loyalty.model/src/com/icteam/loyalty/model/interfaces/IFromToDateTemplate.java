package com.icteam.loyalty.model.interfaces;

import java.util.Date;

/**
 * IFromToDate
 */
public interface IFromToDateTemplate {
    /**
     * Ritorna From
     *
     * @return Date
     */
    Date getFrom();

    /**
     * Sett From
     *
     * @param from Date
     */
    void setFrom(Date from);

    /**
     * Ritorna il To
     *
     * @return Date
     */
    Date getTo();

    /**
     * Setta il To
     *
     * @param to Date
     */
    void setTo(Date to);

}