package com.icteam.loyalty.model.internal;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Root;

import org.osgi.service.log.LogService;

import com.icteam.loyalty.model.Dual;
import com.icteam.loyalty.model.ModelService;
import com.icteam.loyalty.model.interfaces.EStatusReason;
import com.icteam.loyalty.model.interfaces.ICronExpression;
import com.icteam.loyalty.model.interfaces.IEMFTemplate;
import com.icteam.loyalty.model.interfaces.ITemplate;
import com.icteam.loyalty.model.interfaces.OrderDirection;
import com.icteam.loyalty.model.interfaces.PersistOperation;
import com.icteam.loyalty.model.util.ModelUtil;

/**
 * This source file was created by ICTeam S.P.A.
 * <p/>
 * The software must not be used nor reproduced in any form without ICTeam and customer authorization
 * <p/>
 * Project : LoyaltyActivator Customer : ICTeam
 * <p/>
 * Author : $Author: d.pirola $ File : $HeadURL:
 * http://jolokia:1080/svn/ICTeam/Loyalty2.0/trunk/loyalty-ejb/src/main/java/com/icteam/loyalty/manager/ModelManager.java $ Revision : $Revision: 3112
 * $ Last Checkin: $Date: 2013-10-25 17:40:56 +0200 (Fri, 25 Oct 2013) $
 */
/**
 * @author d.pirola
 *
 */
public class ModelServiceImpl implements ModelService {

    private static final long serialVersionUID = -4100826838790141086L;

    private static final int ONE_THOUSAND = 1000;
    private static final int BEGIN_INDEX_ZERO = 0;

    private static long timestamp;
    private static Date cacheDate = new Date();

    private LogService logService;

    private EntityManager entityManager;

    @SuppressWarnings("unused")
    private Object databaseMigrationCenter;

    /**
     * block until database migration is done
     */
    public void setDatabaseMigrationCenter(Object databaseMigrationCenter) {
        this.databaseMigrationCenter = databaseMigrationCenter;
    }

    public void setEntityManager(EntityManager em) {
        this.entityManager = em;
    }

    public void setLogService(LogService logService) {
        this.logService = logService;
    }

    @PostConstruct
    public void init() {
        // try {
        // Method overrideFillMethod = ModelUtil.class.getDeclaredMethod("overrideFillClass", Class.class, Class.class);
        // overrideFillMethod.setAccessible(true);
        //
        // List<Class<Serializable>> overrideFillClasses = LoyaltyFinder.findAnnotated(Serializable.class, OverrideFillAnnotation.class);
        // for (Class<Serializable> overrideFillClass : overrideFillClasses) {
        // Class<?> fillClass = overrideFillClass.getSuperclass();
        //
        // overrideFillMethod.invoke(null, fillClass, overrideFillClass);
        //
        // LOGGER.log(LogService.LOG_DEBUG,"Override fill class #" + fillClass + " with class #" + overrideFillClass);
        // }
        //
        // Method overrideEntityMethod = ModelUtil.class.getDeclaredMethod("overrideEntityClass", Class.class, Class.class);
        // overrideEntityMethod.setAccessible(true);
        //
        // List<Class<Serializable>> overrideEntityClasses = LoyaltyFinder.findAnnotated(Serializable.class, Entity.class);
        // for (Class<Serializable> overrideEntityClass : overrideEntityClasses) {
        // Class<?> entityClass = overrideEntityClass.getSuperclass();
        //
        // if (!entityClass.equals(Object.class)) {
        // overrideEntityMethod.invoke(null, entityClass, overrideEntityClass);
        // LOGGER.log(LogService.LOG_DEBUG,"Override entity class #" + entityClass + " with class #" + overrideEntityClass);
        // }
        // }
        // } catch (Exception e) {
        // LOGGER.error("init error", e);
        // throw new LoyaltyException("init error", e);
        // }
    }

    @Override
    public Date getSysdate() {
        Date date = null;

        synchronized (cacheDate) {
            long t = System.currentTimeMillis() / ONE_THOUSAND;

            if (timestamp == t) {
                date = cacheDate;
            }

            if (date == null) {
                Timestamp ts;

                CriteriaBuilder builder = entityManager.getCriteriaBuilder();
                CriteriaQuery<Timestamp> criteria = builder.createQuery(Timestamp.class);
                Root<Dual> root = criteria.from(Dual.class);
                criteria.select(builder.currentTimestamp());
                criteria.orderBy(builder.asc(root.get("dummy")));
                ts = entityManager.createQuery(criteria).setMaxResults(1).getSingleResult();

                date = new Date(ts.getTime() - ts.getTime() % ONE_THOUSAND);

                cacheDate = date;
                timestamp = System.currentTimeMillis() / ONE_THOUSAND;
            }
        }

        return date;
    }

    @Override
    public Date getNextFireDate(ICronExpression cronExpression) {
        return cronExpression.getCron().getNextValidTimeAfter(getSysdate());
    }

    @Override
    public <T extends Object> T getNotNull(EntityManager em, Class<T> clazz, Serializable id) {
        return getNotNull(em, clazz, id, true, EStatusReason.OBJECT_UNKNOWN);
    }

    @Override
    public <T extends Object> T getNotNull(EntityManager em, Class<T> clazz, Serializable id, boolean throwException, EStatusReason statusReason) {
        T result = em.find(clazz, id);

        logService.log(LogService.LOG_DEBUG, "Class: " + clazz.getSimpleName() + " id:" + id + " result:" + result);

        if (result == null && throwException) {
            throw new RuntimeException(statusReason.toString());
        }

        return result;
    }

    @Override
    public <T> List<T> getList(EntityManager em, Class<T> clazz, String[] orderFields, OrderDirection... orderDirections) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<T> criteria = builder.createQuery(clazz);
        Root<T> root = criteria.from(clazz);

        if (orderFields != null) {
            List<Order> orders = new ArrayList<>();
            for (int i = BEGIN_INDEX_ZERO; i < orderFields.length; i++) {
                if (orderDirections[i] == OrderDirection.ASC) {
                    orders.add(builder.asc(root.get(orderFields[i])));
                } else if (orderDirections[i] == OrderDirection.DESC) {
                    orders.add(builder.desc(root.get(orderFields[i])));
                }
            }

            criteria.orderBy(orders);
        }

        return em.createQuery(criteria).getResultList();
    }

    @Override
    public <T> List<T> getList(EntityManager em, Class<T> clazz) {
        return getList(em, clazz, null, (OrderDirection[]) null);
    }

    @Override
    // @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public <T> List<T> getListSeparateTransaction(EntityManager em, Class<T> clazz, String[] orderFields, OrderDirection... orderDirections) {
        return getList(em, clazz, orderFields, orderDirections);
    }

    @Override
    // @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public Number getNextSequenceValue(String sequenceName) {
        Query query;
        Number sequenceValue;

        // se si dovesse tornare su SQL SERVER occorre riabilitare questo codice
        // if (EnvironmentUtil.isSQLServerDb()) {
        // query = em.createNativeQuery("INSERT INTO " + sequenceName + " VALUES('')");
        // query.executeUpdate();
        // query = em.createNativeQuery("SELECT ID FROM " + sequenceName);
        // sequenceValue = (Number) query.getSingleResult();
        // query = em.createNativeQuery("DELETE FROM " + sequenceName);
        // query.executeUpdate();
        // } else {
        query = entityManager.createNativeQuery("SELECT " + sequenceName + ".NEXTVAL FROM DUAL");
        sequenceValue = (Number) query.getSingleResult();
        // }

        return sequenceValue;
    }

    // paolo, commentato. Stiamo provando l'appriccio che sia il frontend a settare gli id...
    // @Override
    // public <T extends PersistentObject> Set<T> setIdForNewElements(Set<T> set) {
    // // cerco gli oggetti con id nullo
    // List<T> newElements = new ArrayList<>();
    // for (T i : set) {
    // if (i.getId() == null) {
    // newElements.add(i);
    // }
    // }
    //
    // // li estraggo dall'insieme, setto l'id e poi reincapsulo nell'insieme.
    // // e' vietato cambiare il valore di un attributo che viene utilizzato dalla equals e hashocode per un
    // // oggetto in un insieme, pena l'insieme non si comporta piu' come atteso (es la remove non funziona piu')
    // // vedi https://forum.hibernate.org/viewtopic.php?t=928172
    // for (T i : newElements) {
    // set.remove(i);
    // i.setId(getNextSequenceValue(IConstants.DEFUALT_SEQUENCE_NAME).longValue());
    // set.add(i);
    // }
    //
    // return set;
    // }

    // private static Map<Class< ? extends ISelectable< ? extends Serializable>>, Loader<List< ? extends ISelectable< ? extends Serializable>>>>
    // loadersTypesList;
    // private static Map<Class< ? extends ISelectable< ? extends Serializable>>, Loader<Map<Serializable, ISelectable< ? extends Serializable>>>>
    // loadersTypesMap;

    // public class TypeList implements ILoadable<List< ? extends ISelectable< ? extends Serializable>>> {
    //
    // private final Class< ? extends ISelectable< ? extends Serializable>> selectableClass;
    //
    // public TypeList(Class< ? extends ISelectable< ? extends Serializable>> selectableClass) {
    // this.selectableClass = selectableClass;
    // }
    //
    // @Override
    // public boolean isReloadRequired() {
    // return true;
    // }
    //
    // @Override
    // public List< ? extends ISelectable< ? extends Serializable>> loadData() {
    // return ServiceLocator.getService(ModelServiceLocal.class).getListSeparateTransaction(selectableClass, null, (IConstants.OrderDirection[])
    // null);
    // }
    //
    // @Override
    // public String toString() {
    // return selectableClass.toString();
    // }
    // }
    //
    // public class TypeMap implements ILoadable<Map<Serializable, ISelectable< ? extends Serializable>>> {
    //
    // private final Class< ? extends ISelectable< ? extends Serializable>> selectableClass;
    //
    // public TypeMap(Class< ? extends ISelectable< ? extends Serializable>> selectableClass) {
    // this.selectableClass = selectableClass;
    // }
    //
    // @Override
    // public boolean isReloadRequired() {
    // return true;
    // }
    //
    // @Override
    // public Map<Serializable, ISelectable< ? extends Serializable>> loadData() {
    // Map<Serializable, ISelectable< ? extends Serializable>> types = new HashMap<Serializable, ISelectable< ? extends Serializable>>();
    // List< ? extends ISelectable< ? extends Serializable>> typeList = null;
    // typeList = ServiceLocator.getService(ModelServiceLocal.class).getListSeparateTransaction(selectableClass, null, (IConstants.OrderDirection[])
    // null);
    //
    // for (ISelectable< ? extends Serializable> selectable : typeList) {
    // types.put(selectable.getKey(), selectable);
    // }
    //
    // return types;
    // }
    //
    // @Override
    // public String toString() {
    // return selectableClass.toString();
    // }
    // }

    // @Override
    // public <S extends ISelectable< ? extends Serializable>, T extends Serializable> S getType(Class<S> selectableClass, T key) {
    // return getType(selectableClass, key, null);
    // }
    //
    // @Override
    // public <S extends ISelectable< ? extends Serializable>, T extends Serializable> S getType(Class<S> selectableClass, T key, EStatusReason
    // statusReason) {
    // Loader<Map<Serializable, ISelectable< ? extends Serializable>>> loader = null;
    //
    // synchronized (loadersTypesMap) {
    // loader = loadersTypesMap.get(selectableClass);
    //
    // if (loader == null) {
    // loader = new Loader<Map<Serializable, ISelectable< ? extends Serializable>>>(new TypeMap(selectableClass), false);
    // loadersTypesMap.put(selectableClass, loader);
    // }
    // }
    //
    // Map<Serializable, S> types = (Map<Serializable, S>) loader.getData();
    //
    // S value = types.get(key);
    //
    // if (value == null && isCacheable(selectableClass)) {
    // loader.resetData();
    // types = (Map<Serializable, S>) loader.getData();
    //
    // value = types.get(key);
    // }
    //
    // if (value == null) {
    // if (statusReason != null) {
    // throw new LoyaltyException(statusReason, null, selectableClass.getSimpleName(), key);
    // }
    // } else {
    // value = em.merge(value);
    //
    // types.put(key, value);
    // }
    //
    // return value;
    // }
    //
    // @Override
    // public <S extends ISelectable< ? extends Serializable>> List<S> getTypes(Class<S> selectableClass) {
    // Loader<List< ? extends ISelectable< ? extends Serializable>>> loader = null;
    //
    // synchronized (loadersTypesList) {
    // loader = loadersTypesList.get(selectableClass);
    //
    // if (loader == null) {
    // loader = new Loader<List< ? extends ISelectable< ? extends Serializable>>>(new TypeList(selectableClass), false);
    // loadersTypesList.put(selectableClass, loader);
    // }
    // }
    //
    // List<S> typeList = (List<S>) loader.getData();
    //
    // if (typeList == null || isCacheable(selectableClass)) {
    // loader.resetData();
    // typeList = (List<S>) loader.getData();
    // }
    //
    // return typeList;
    // }
    //
    // @Override
    // public synchronized void reloadAllTypes() {
    // for (Loader<List< ? extends ISelectable< ? extends Serializable>>> loader : loadersTypesList.values()) {
    // loader.resetData();
    // }
    //
    // for (Loader<Map<Serializable, ISelectable< ? extends Serializable>>> loader : loadersTypesMap.values()) {
    // loader.resetData();
    // }
    // }
    //
    // @Override
    // public synchronized <S extends ISelectable< ? extends Serializable>> void reloadType(Class<S> selectableClass) {
    // Loader<Map<Serializable, ISelectable< ? extends Serializable>>> loaderMap = loadersTypesMap.get(selectableClass);
    // if (loaderMap != null) {
    // loaderMap.resetData();
    // }
    //
    // Loader<List< ? extends ISelectable< ? extends Serializable>>> loaderList = loadersTypesList.get(selectableClass);
    // if (loaderList != null) {
    // loaderList.resetData();
    // }
    // }

    // private <S> boolean isCacheable(Class<S> selectableClass) {
    // return selectableClass.isAnnotationPresent(Cacheable.class);
    // }

    // @Override
    // public <P extends IPrioritized< ? extends IPriority< ? >>, PP extends IPriority< ? extends IPrioritized< ? >>> List<P> filter(List<P>
    // prioritizeds, Class<PP> priorityClass) {
    // List<P> destPrioritizeds = new ArrayList<>(prioritizeds);
    //
    // if (!prioritizeds.isEmpty()) {
    // CriteriaBuilder builder = em.getCriteriaBuilder();
    // builder.createQuery(priorityClass);
    //
    // Root<PP> root = criteria.from(priorityClass);
    // criteria.where(builder.in(root.get("id").get("kMinor")).value(prioritizeds));
    //
    // List<PP> priorities = em.createQuery(criteria).getResultList();
    //
    // for (PP priority : priorities) {
    // if (prioritizeds.contains(priority.getMaior())) {
    // destPrioritizeds.remove(priority.getMinor());
    //
    // LOGGER.log(LogService.LOG_INFO,"filtered by priority - profile policy #" +
    // em.getEntityManagerFactory().getPersistenceUnitUtil().getIdentifier(priority.getMinor()));
    // }
    // }
    // }
    //
    // return destPrioritizeds;
    // }

    @Override
    // @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public <T> T saveSeparateTransaction(EntityManager em, T obj) {
        return save(em, obj);
    }

    @Override
    public <T> T save(EntityManager em, T obj) {
        T obj1 = obj;
        obj1 = em.merge(obj1);
        // if (em.getEntityManagerFactory().getPersistenceUnitUtil().getIdentifier(obj1) != null) {
        //
        // // if (obj.getClass().isAnnotationPresent(Cacheable.class)) {
        // // em.getEntityManagerFactory().getCache().evict(obj.getClass(), obj);
        // // }

        logService.log(LogService.LOG_INFO, "updated " + obj1.getClass().getSimpleName() + " #" + obj1);
        // } else {
        // em.persist(obj1);
        //
        // LOGGER.log(LogService.LOG_INFO,"saved " + obj1.getClass().getSimpleName() + " #" + obj1);
        // }

        return obj1;
    }

    @Override
    public <T> void delete(EntityManager em, T obj) {
        try {
            obj = em.merge(obj);
            em.remove(obj);
            em.flush();
        } catch (PersistenceException eee) {
            throw ModelUtil.convert(PersistOperation.DELETE, eee);
        }
    }

    @Override
    public void flush(EntityManager em) {
        em.flush();
    }

    @Override
    public <T> T refresh(EntityManager em, T obj) {
        T merged = em.merge(obj);
        em.refresh(merged);
        return merged;
    }

    // @Override
    // public Query createNamedQuery(String name) {
    // String queryName = name + EnvironmentUtil.getDBName();
    //
    // Query query;
    // try {
    // query = em.createNamedQuery(queryName);
    // } catch (IllegalArgumentException e) {
    // // query not found for specific db
    // // try without db suffix
    // query = em.createNamedQuery(name);
    // }
    //
    // return query;
    // }
    //
    @Override
    public <T> void handleNullParameter(Query query, String paramName, T paramValue, Class<T> paramType) {
        // if (paramValue != null) {
        query.setParameter(paramName, paramValue);
        // } else {
        // query.setParameter(paramName, paramValue);
        //
        // try {
        // Class<?> hibQuery = Thread.currentThread().getContextClassLoader().loadClass("org.hibernate.ejb.HibernateQuery");
        // if (hibQuery.isAssignableFrom(query.getClass())) {
        // Method m = hibQuery.getMethod("getHibernateQuery", (Class[]) null);
        // Object o = m.invoke(query, (Object[]) null);
        // m = o.getClass().getMethod("setParameter", String.class, Object.class, Type.class);
        //
        // Type type = StandardBasicTypes.STRING;
        // if (Long.class.isAssignableFrom(paramType)) {
        // type = StandardBasicTypes.LONG;
        // } else if (Integer.class.isAssignableFrom(paramType)) {
        // type = StandardBasicTypes.INTEGER;
        // } else if (BigDecimal.class.isAssignableFrom(paramType)) {
        // type = StandardBasicTypes.BIG_DECIMAL;
        // } else if (Date.class.isAssignableFrom(paramType)) {
        // type = StandardBasicTypes.DATE;
        // } else if (String.class.isAssignableFrom(paramType)) {
        // type = StandardBasicTypes.STRING;
        // } else {
        // LOGGER.log(LogService.LOG_INFO,"parameter #"
        // + paramName
        // + " with type #"
        // + paramType
        // + " bound with standard String type. See ModelManager.handleNullParameter method to modify");
        // }
        //
        // m.invoke(o, paramName, paramValue, type);
        // }
        // } catch (Exception e) {
        // LOGGER.log(LogService.LOG_INFO,"parameter #"
        // + paramName
        // + " with type #"
        // + paramType
        // + " has null value but is bind with default JPA. See ModelManager.handleNullParameter method to modify");
        // // hibernate is not jpa provider
        // }
        // }
    }

    @Override
    public <S extends Serializable, T extends ITemplate<S>> int count(EntityManager em, T template) {
        logService.log(LogService.LOG_INFO, "count for template #" + template);

        Long count = template.getResultCount(em);

        logService.log(LogService.LOG_INFO, "count #" + count);

        return count.intValue();
    }

    @Override
    public <S extends Serializable, T extends ITemplate<S>> List<S> search(EntityManager em, T template) {
        logService.log(LogService.LOG_INFO, "search for template #" + template);

        List<S> list = template.getResultList(em);

        if (list.isEmpty()) {
            logService.log(LogService.LOG_INFO, "elements not found");
        } else {
            for (S object : list) {
                logService.log(LogService.LOG_INFO, "found #" + object);
            }
        }

        return list;
    }

    @Override
    public <S extends Serializable, T extends IEMFTemplate<S>> int count(EntityManager em, T template) {
        logService.log(LogService.LOG_INFO, "count for template #" + template);

        Long count = template.getResultCount(em);

        logService.log(LogService.LOG_INFO, "count #" + count);

        return count.intValue();
    }

    @Override
    public <S extends Serializable, T extends IEMFTemplate<S>> List<S> search(EntityManager em, T template) {
        logService.log(LogService.LOG_INFO, "search for template #" + template);

        List<S> list = template.getResultList(em);

        if (list.isEmpty()) {
            logService.log(LogService.LOG_INFO, "elements not found");
        } else {
            for (S object : list) {
                logService.log(LogService.LOG_INFO, "found #" + object);
            }
        }

        return list;
    }

    @Override
    public <S extends Serializable, T extends ITemplate<S>> S searchFirst(EntityManager em, T template) {
        logService.log(LogService.LOG_INFO, "search first element for template #" + template);

        S result = template.getFirstResult(em);

        logService.log(LogService.LOG_INFO, "found #" + result);

        return result;
    }

    @Override
    public <S extends Serializable, T extends IEMFTemplate<S>> S searchFirst(EntityManager em, T template) {
        logService.log(LogService.LOG_INFO, "search first element for template #" + template);

        S result = template.getFirstResult(em);

        logService.log(LogService.LOG_INFO, "found #" + result);

        return result;
    }

}
