package com.icteam.loyalty.common.interfaces;

import java.io.Serializable;
import java.util.Set;

/**
 * IPrioritized
 */
public interface IPrioritized extends Serializable {
    /**
     * Ritorna Set di priorita' maggiori
     *
     * @param <T> generico
     * @return lsita priorita' maggiori
     */
    <T extends IPrioritized> Set<T> getPrioritiesMaior();

    /**
     * Ritorna lista di priorita' minori
     *
     * @param <T> generico
     * @return lista priorita' minori
     */
    <T extends IPrioritized> Set<T> getPrioritiesMinor();
}
