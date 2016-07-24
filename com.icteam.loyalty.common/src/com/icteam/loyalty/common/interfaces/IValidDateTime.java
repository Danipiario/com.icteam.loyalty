package com.icteam.loyalty.common.interfaces;

import java.util.Date;

/**
 * IValidDateTime controllo che t_start e t_end includano la data specificata.
 * Da usare per t_start e t_end comprensive di ora, minuti e secondi
 */
public interface IValidDateTime {
    /**
     * Ritorna ValidDate
     *
     * @return Date
     */
    Date getValidDateTime();

    /**
     * Setta ValidDate
     *
     * @param validDate Date
     */
    void setValidDateTime(Date validDate);

}