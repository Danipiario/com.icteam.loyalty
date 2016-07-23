package com.icteam.loyalty.model.interfaces;

import org.quartz.CronExpression;

/**
 * ICronExpression
 */
public interface ICronExpression {
    /**
     * Ritorna l'espressione a Cron
     *
     * @return espresisone a Cron
     */
    String getCronExpression();

    /**
     * Setta l'espressione a Corn
     *
     * @param cron CronExpression
     */
    void setCron(CronExpression cron);

    /**
     * Ritorna l'oggetto CronExpression
     *
     * @return CronExpression
     */
    CronExpression getCron();
}