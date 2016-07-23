package com.icteam.loyalty.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.icteam.loyalty.model.interfaces.EStatusReason;
import com.icteam.loyalty.model.interfaces.ICronExpression;
import com.icteam.loyalty.model.interfaces.IEMFTemplate;
import com.icteam.loyalty.model.interfaces.ITemplate;
import com.icteam.loyalty.model.interfaces.OrderDirection;

/**
 * This source file was created by ICTeam S.P.A.
 * <p/>
 * The software must not be used nor reproduced in any form without ICTeam and customer authorization
 * <p/>
 * Project : LoyaltyActivator Customer : ICTeam
 * <p/>
 * Author : $Author: d.pirola $ File : $HeadURL:
 * http://jolokia:1080/svn/ICTeam/Loyalty2.0/trunk/loyalty-core/src/main/java/com/icteam/loyalty/core/service/ModelService.java $ Revision :
 * $Revision: 5167 $ Last Checkin: $Date: 2013-10-25 16:55:51 +0200 (Fri, 25 Oct 2013) $
 */
public interface ModelService extends Serializable {

    /**
     * Gestisce i parametri nullo
     *
     * @param query
     *            Query
     * @param paramName
     *            nome parametro
     * @param paramValue
     *            valore parametro
     * @param paramType
     *            tipo parametro
     */
    <T> void handleNullParameter(Query query, String paramName, T paramValue, Class<T> paramType);

    // /**
    // * Crea una namedQuery
    // *
    // * @param name namedQuery
    // * @return la Query
    // */
    // Query createNamedQuery(String name);
    //

    /**
     * Aggiorna il parametro con i dati letti da database. A differenza di EntityManager.refresh(), non e' necessario
     * che l'oggetto sia in sessione
     *
     * @param em
     *            the entity manager
     * @param obj
     *            Object
     * @return the t
     */
    <T> T refresh(EntityManager em, T obj);

    /**
     * Salva un oggetto
     *
     * @param em
     *            EntityManager
     * @param obj
     *            oggetto
     * @return l 'oggetto salvato
     */
    <T> T save(EntityManager em, T obj);

    <T> void delete(EntityManager em, T obj);

    /**
     * Salva in separata transazione
     *
     * @param em
     *            EntityManager
     * @param obj
     *            oggetto da salvare
     * @return oggetto salvato
     */
    <T> T saveSeparateTransaction(EntityManager em, T obj);

    /**
     * Esegue la flush
     *
     * @param em
     *            EntityManager
     */
    void flush(EntityManager em);

    /**
     * Prende il non nullo
     *
     * @param em
     *            EntityManager
     * @param clazz
     *            classe
     * @param id
     *            K_ID dell'oggetto
     * @return Oggetto non nullo
     */
    <T> T getNotNull(EntityManager em, Class<T> clazz, Serializable id);

    /**
     * Prende il non nullo
     *
     * @param em
     *            EntityManager
     * @param clazz
     *            classe
     * @param id
     *            K_ID dell'oggetto
     * @param throwException
     *            lancia eccezione
     * @param statusReason
     *            EStatusReason
     * @return Oggetto non nullo
     */
    <T> T getNotNull(EntityManager em, Class<T> clazz, Serializable id, boolean throwException, EStatusReason statusReason);

    /**
     * Ritorna una lista di oggetti
     *
     * @param em
     *            EntityManager
     * @param clazz
     *            classe
     * @param orderFields
     *            campi su cui ordinare
     * @param orderDirections
     *            direzione dell'ordinamento
     * @return la lista
     */
    <T> List<T> getList(EntityManager em, Class<T> clazz, String[] orderFields, OrderDirection... orderDirections);

    /**
     * Ritorna una lista di oggetti
     *
     * @param em
     *            EntityManager
     * @param clazz
     *            classe
     * @return la lista
     */
    <T> List<T> getList(EntityManager em, Class<T> clazz);

    /**
     * Ritorna una lista con transazione separata
     *
     * @param em
     *            TODO
     * @param clazz
     *            classe
     * @param orderFields
     *            campi su cui ordinare
     * @param orderDirections
     *            direzione dell'ordinamento
     * @return la lista
     */
    <T> List<T> getListSeparateTransaction(EntityManager em, Class<T> clazz, String[] orderFields, OrderDirection... orderDirections);

    // void updateLanguage();

    /**
     * Ritona la sysdate
     *
     * @return la sysdate
     */
    Date getSysdate();

    /**
     * Ritorna il NEXT_VAL della sequence
     *
     * @param sequenceName
     *            la sequence
     * @return il NEXT_VAL
     */
    Number getNextSequenceValue(String sequenceName);

    /**
     * Count long.
     *
     * @param em
     *            TODO
     * @param template
     *            the template
     * @return the long
     */
    <S extends Serializable, T extends ITemplate<S>> int count(EntityManager em, T template);

    <S extends Serializable, T extends IEMFTemplate<S>> int count(EntityManager em, T template);

    /**
     * Search list.
     *
     * @param em
     *            TODO
     * @param template
     *            the template
     * @return the list
     */
    <S extends Serializable, T extends ITemplate<S>> List<S> search(EntityManager em, T template);

    <S extends Serializable, T extends IEMFTemplate<S>> List<S> search(EntityManager em, T template);

    /**
     * Search first element.
     *
     * @param em
     *            TODO
     * @param template
     *            the template
     * @return the element searched
     */
    <S extends Serializable, T extends ITemplate<S>> S searchFirst(EntityManager em, T template);

    <S extends Serializable, T extends IEMFTemplate<S>> S searchFirst(EntityManager em, T template);

    Date getNextFireDate(ICronExpression cronExpression);
}
