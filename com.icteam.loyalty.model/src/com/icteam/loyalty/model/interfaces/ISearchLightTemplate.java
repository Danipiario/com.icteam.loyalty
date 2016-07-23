package com.icteam.loyalty.model.interfaces;

import java.io.Serializable;

/**
 * ISearchLightTemplate
 *
 * @param <T> generico
 */
public interface ISearchLightTemplate<T extends Serializable> {
    /**
     * Controlla
     *
     * @param object oggetto
     * @return true o false
     */
    boolean check(T object);

}