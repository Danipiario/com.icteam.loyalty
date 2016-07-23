package com.icteam.loyalty.model.interfaces;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.metamodel.ManagedType;

/**
 * ITemplate
 * 
 * @param <T>
 *            generico
 */
public interface ITemplate<T extends Serializable> extends Serializable {
    /**
     * Ritorna campi per l'odinamento
     * 
     * @return cmapi per l'ordinamento
     */
    String[] getOrderFields();

    /**
     * Ritorna tipo di ordinamento
     * 
     * @return tipo di rodinamento
     */
    OrderDirection[] getOrderDirections();

    /**
     * Crea
     * 
     * @param buildClass
     *            generico
     * @return ordinamento
     */
    T build(Class<T> buildClass);

    /**
     * Setta massimo numero di risulati
     * 
     * @param maxResults
     *            massimo numero di risultati
     */
    void setMaxResults(int maxResults);

    /**
     * Ritorna massimo numero di risultati
     * 
     * @return masismo numero di risultati
     */
    int getMaxResults();

    /**
     * Indica se viene utilizzata la distinct via SQL, via codice o nessuna distinct
     * 
     * @return valore distinct
     */
    Distinct getDistinct();

    Class<T> getTemplateClass();

    ManagedType<T> getMetamodelClass();

    boolean initialized();

    <R> Long getResultCount(EntityManager em);

    <R> R getFirstResult(EntityManager em);

    <R> List<R> getResultList(EntityManager em);
}
