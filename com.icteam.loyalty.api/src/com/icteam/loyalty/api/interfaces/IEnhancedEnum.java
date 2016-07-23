package com.icteam.loyalty.api.interfaces;

import java.io.Serializable;

/**
 * The interface I enhanced enum.
 */
public interface IEnhancedEnum<E extends IEnhancedEnum<E, S>, S extends Serializable & Comparable<S>> extends Comparable<E>, Serializable {

    /**
     * Name string.
     *
     * @return the string
     */
    S name();

}