package com.icteam.loyalty.model.util;

import java.io.Serializable;
import java.io.StringReader;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.WeakHashMap;

import javax.persistence.PersistenceException;

import org.apache.commons.beanutils.BeanToPropertyValueTransformer;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Transformer;
import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang.time.DateUtils;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.FeatureMapUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.rap.rwt.RWT;
import org.eclipse.rap.rwt.internal.service.ContextProvider;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.ServiceReference;
import org.quartz.CronExpression;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.icteam.loyalty.api.AppException;
import com.icteam.loyalty.api.interfaces.EnhancedEnum;
import com.icteam.loyalty.api.interfaces.IConstants;
import com.icteam.loyalty.api.interfaces.Property;
import com.icteam.loyalty.model.AnnotationClosure;
import com.icteam.loyalty.model.AnnotationPredicate;
import com.icteam.loyalty.model.EAnnotationClosure;
import com.icteam.loyalty.model.EMFModel;
import com.icteam.loyalty.model.ModelProperties;
import com.icteam.loyalty.model.interfaces.CustomModelFactory;
import com.icteam.loyalty.model.interfaces.EAnnotation;
import com.icteam.loyalty.model.interfaces.EStatusReason;
import com.icteam.loyalty.model.interfaces.EWhereClauseEMF;
import com.icteam.loyalty.model.interfaces.ICronExpression;
import com.icteam.loyalty.model.interfaces.IEMFEnhancedEnum;
import com.icteam.loyalty.model.interfaces.IEMFModel;
import com.icteam.loyalty.model.interfaces.ILocation;
import com.icteam.loyalty.model.interfaces.IPrioritized;
import com.icteam.loyalty.model.interfaces.ModelInterfacesPackage;
import com.icteam.loyalty.model.interfaces.PersistOperation;
import com.icteam.loyalty.model.interfaces.Where;

/**
 * ModelUtil
 */
public final class ModelUtil {

    public static class CustomCopier extends Copier {

        @Override
        protected void copyAttribute(EAttribute eAttribute, EObject eObject, EObject copyEObject) {
            if (FeatureMapUtil.isFeatureMap(eAttribute)) {
                FeatureMap featureMap = (FeatureMap) eObject.eGet(eAttribute);
                copyFeatureMap(featureMap);
            } else {
                EStructuralFeature.Setting setting = getTarget(eAttribute, eObject, copyEObject);
                if (setting != null) {
                    copyAttributeValue(eAttribute, eObject, eObject.eGet(eAttribute), setting);
                }
            }
        }

        @Override
        protected void copyReference(EReference eReference, EObject eObject, EObject copyEObject) {
            if (eObject.eIsSet(eReference)) {
                EStructuralFeature.Setting setting = getTarget(eReference, eObject, copyEObject);

                if (setting != null) {
                    Object value = eObject.eGet(eReference, resolveProxies);

                    if (eReference.isMany()) {
                        InternalEList<Object> source = (InternalEList<Object>) value; // liste di Object e non EObject, utile per gli enum
                        InternalEList<Object> target = (InternalEList<Object>) setting;

                        if (source.isEmpty()) {
                            target.clear();
                        } else {
                            boolean isBidirectional = eReference.getEOpposite() != null;
                            int index = 0;

                            for (Iterator<Object> k = resolveProxies ? source.iterator() : source.basicIterator(); k.hasNext();) {
                                Object referencedEObject = k.next();
                                Object copyReferencedEObject = get(referencedEObject);

                                if (copyReferencedEObject == null) {
                                    if (useOriginalReferences && !isBidirectional) {
                                        if (referencedEObject instanceof IEMFModel) {
                                            target.addUnique(index, ModelUtil.copy((IEMFModel) referencedEObject));
                                        } else {
                                            target.addUnique(index, referencedEObject);
                                        }

                                        ++index;
                                    }
                                } else {
                                    if (isBidirectional) {
                                        int position = target.indexOf(copyReferencedEObject);

                                        if (position == -1) {
                                            target.addUnique(index, copyReferencedEObject);
                                        } else if (index != position) {
                                            target.move(index, copyReferencedEObject);
                                        }
                                    } else {
                                        target.addUnique(index, copyReferencedEObject);
                                    }
                                    ++index;
                                }
                            }
                        }
                    } else {
                        super.copyReference(eReference, eObject, copyEObject);
                    }
                }
            }
        }
    }

    private static final Map<Class< ? extends IEMFEnhancedEnum< ? >>, Map<Object, Map<String, ? extends IEMFEnhancedEnum< ? >>>> MAP_VALUES = new HashMap<>();
    private static final Map<Class< ? extends IEMFEnhancedEnum< ? >>, List< ? extends IEMFEnhancedEnum< ? >>> LIST_VALUES = new HashMap<>();
    private static final Object DEFAULT_KEY = new Object();

    private static final int MIN_DATE = 1900;
    private static final int ONE_THOUSAND = 1000;

    private static Map<Class< ? >, Class< ? >> deafultFillClasses = new HashMap<>();

    private static EMFEnhancedEnumAdapter< ? extends IEMFEnhancedEnum< ? >> enhancedEnumAdapter = new EMFEnhancedEnumAdapter<>();

    public static Comparator<Field> propertyFieldComparator = new Comparator<Field>() {

        @Override
        public int compare(Field f1, Field f2) {
            Property property1 = f1.getAnnotation(Property.class);
            Property property2 = f2.getAnnotation(Property.class);

            int o1 = Integer.MAX_VALUE;
            int o2 = Integer.MAX_VALUE;

            if (property1 != null) {
                o1 = property1.order();
            }

            if (property2 != null) {
                o2 = property2.order();
            }

            int c = o1 - o2;

            if (c == 0) {
                c = f1.getName().compareTo(f2.getName());
            }

            return c;
        }
    };

    /**
     * chiamato da ModelManager
     */
    @SuppressWarnings("unused")
    private static <I extends Serializable, DI extends I> void overrideFillClass(Class<I> fillClass, Class<DI> overrideFillClass) {
        synchronized (deafultFillClasses) {
            deafultFillClasses.put(fillClass, overrideFillClass);
        }
    }

    /**
     * Tronca la data
     *
     * @param date
     *            Data da troncare
     * @return data troncata
     */
    public static Date safeSetDateTruncate(Date date) {
        return date == null ? null : DateUtils.truncate(date, Calendar.DAY_OF_MONTH);
    }

    /**
     * Controlla la data passata
     *
     * @param date
     *            data da controllare
     * @return data
     */
    public static Date safeSetDate4Digit(Date date) {
        if (date != null) {
            try {
                Calendar cal = Calendar.getInstance();
                cal.setTime(date);

                if (cal.get(Calendar.YEAR) < MIN_DATE) {
                    return DateUtils.parseDate(DateFormatUtils.format(date, "dd/MM/yy"), new String[] { "dd/MM/yy" });
                }

                return date;
            } catch (ParseException e) {
                // non dovrebbe mai avvenire, parto da una data
            }
        }

        return null;
    }

    /**
     * Esegue un safe get
     *
     * @param list
     *            lista
     * @param <I>
     *            generico
     * @return oggetto richiesto
     */
    public static <I> I safeGetItem(List<I> list) {
        return list == null || list.isEmpty() ? null : list.get(0);
    }

    /**
     * Esegue un safe set
     *
     * @param item
     *            item da aggiungere
     * @param <I>
     *            generico
     * @return lista
     */
    public static <I> List<I> safeSetItem(I item) {
        return item == null ? null : Arrays.asList(item);
    }

    /**
     * Esegue un safe add
     *
     * @param item
     *            item
     * @param items
     *            lista di item
     * @param <I>
     *            generico
     * @return la lista
     */
    public static <I> List<I> safeAddItem(I item, List<I> items) {
        if (item == null) {
            return items;
        }
        List<I> internalItems = items;
        if (internalItems == null) {
            internalItems = new ArrayList<>();
        }

        internalItems.add(item);

        return internalItems;
    }

    /**
     * esegue un safe non vuoto
     *
     * @param list
     *            lista
     * @param <I>
     *            genereico
     * @return true o false
     */
    public static <I> boolean safeIsNotEmpty(Collection<I> list) {
        return list != null && !list.isEmpty();
    }

    /**
     * esegue un safe vuoto
     *
     * @param list
     *            lista
     * @param <I>
     *            generico
     * @return true o false
     */
    public static <I> boolean safeIsEmpty(Collection<I> list) {
        return list == null || list.isEmpty();
    }

    /**
     * Controlla se un campo e' vuoto
     *
     * @param fields
     *            campi da controllare
     * @return true se almeno un cmapo e' vuoto, false altrimenti
     */
    public static boolean isAFieldEmpty(String... fields) {
        for (String field : fields) {
            if (StringUtils.isEmpty(field)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Controlla se tutti i campi sono vuoti
     *
     * @param fields
     *            campi
     * @return true se sono tutti vuoti, false altrimenti
     */
    public static boolean areEveryFieldsEmpty(String... fields) {
        for (String field : fields) {
            if (!StringUtils.isEmpty(field)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Controlla se tutti i campi non sono vuoti
     *
     * @param fields
     *            campi
     * @return true se non sono vuoti, false se ce ne e' almeno uno vuoto
     */
    public static boolean areEveryFieldsNotEmpty(String... fields) {
        return !isAFieldEmpty(fields);
    }

    public static <P extends IPrioritized> List<P> filter(List<P> prioritizeds) {
        if (prioritizeds == null || prioritizeds.isEmpty()) {
            return prioritizeds;
        }

        List<P> out = new ArrayList<>(prioritizeds);
        for (P prioritized : prioritizeds) {
            Set<P> minors = prioritized.getPrioritiesMinor();
            for (P minor : minors) {
                out.remove(minor);
            }
        }

        return out;
    }

    /**
     * Crea un nuovo nome di file
     *
     * @param fileName
     *            nome file
     * @return nome file piu' numero causale
     */
    public static String createNewFileName(String fileName) {
        return fileName + '_' + (long) (Math.random() * ONE_THOUSAND);
    }

    /**
     * COntrolla Risosrsa nulla
     *
     * @param value
     *            risorsa richiesta
     * @return true o false
     */
    public static boolean isNullResource(String value) {
        return value != null && value.startsWith(IConstants.NULL_RESOURCE_STRING) && value.endsWith(IConstants.NULL_RESOURCE_STRING);
    }

    public static Object clone(final Object obj) {
        if (obj instanceof Cloneable) {
            Class< ? > clazz = obj.getClass();
            Method m;
            try {
                m = clazz.getMethod("clone", (Class[]) null);
            } catch (NoSuchMethodException ex) {
                throw new NoSuchMethodError(ex.getMessage());
            }
            try {
                return m.invoke(obj, (Object[]) null);
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    public static <C> List<C> clone(final List<C> list) {
        List<C> cloneList = new ArrayList<>();

        for (C obj : list) {
            cloneList.add((C) clone(obj));
        }

        return cloneList;
    }

    public static <T> List<T> fromJson(String jsonString, Type type) {
        if (StringUtils.isBlank(jsonString)) {
            return null;
        }

        Gson gson = buildGson();
        return gson.fromJson(new StringReader(jsonString), type);
    }

    private static Gson buildGson() {
        GsonBuilder gsonBuilder = new GsonBuilder();

        gsonBuilder.registerTypeHierarchyAdapter(IEMFEnhancedEnum.class, enhancedEnumAdapter);
        return gsonBuilder.excludeFieldsWithoutExposeAnnotation().create();
    }

    /**
     * Enum to Json
     * @param list
     *            altri enum
     * @param type
     *            Type
     *
     * @param <T>
     *            generico
     * @return Stringa
     */
    public static <T> String toJson(List<T> list, Type type) {
        if (list == null) {
            return "[]";
        }

        Gson gson = buildGson();
        return gson.toJson(list, type);
    }

    public static <E extends EnhancedEnum<E, String>> List<E> fromJson(Class<E> clazz, String jsonString) {
        Gson gson = buildGson();
        List<String> strings = gson.fromJson(jsonString, List.class);

        List<E> list = new ArrayList<>();

        if (strings != null) {
            for (String s : strings) {
                list.add(EnhancedEnum.valueOf(clazz, s));
            }
        }

        return list;
    }

    public static <E extends EnhancedEnum<E, String>> String toJson(List<E> list) {
        Gson gson = buildGson();
        List<String> rawList = new ArrayList<>();
        for (E e : list) {
            rawList.add(e.toString());
        }

        return gson.toJson(rawList);
    }

    public static <E extends IEMFEnhancedEnum<E>> List<E> fromEMFJson(Class<E> enhancedEnumClass, String jsonString) {
        Gson gson = buildGson();
        List<String> strings = gson.fromJson(jsonString, List.class);

        List<E> list = new ArrayList<>();

        if (strings != null) {
            for (String s : strings) {
                E value = valueOf(enhancedEnumClass, s, false);

                if (value != null) {
                    list.add(value);
                }
            }
        }

        return list;
    }

    public static <E extends IEMFEnhancedEnum<E>> String toEMFJson(List<E> list) {
        Gson gson = buildGson();
        List<String> rawList = new ArrayList<>();
        for (E e : list) {
            rawList.add(e.getName());
        }

        return gson.toJson(rawList);
    }

    public static String toJson(Object src) {
        Gson gson = buildGson();

        return gson.toJson(src);
    }

    public static <C extends Object> C fromJson(String jsonString, Class<C> clazz) {
        Gson gson = buildGson();

        return gson.fromJson(jsonString, clazz);
    }

    public static String[] collectPropertyNames(Class< ? > clazz) {
        SortedSet<Field> propertyFields = new TreeSet<>(propertyFieldComparator);

        collectPropertyNames(clazz, propertyFields);

        Collection<String> propertyNames = CollectionUtils.collect(propertyFields, new BeanToPropertyValueTransformer("name"));

        return propertyNames.toArray(new String[] {});
    }

    public static void collectPropertyNames(Class< ? > clazz, final SortedSet<Field> propertyFields) {
        if (clazz.equals(Object.class)) {
            return;
        }

        forAllDo(clazz, new AnnotationClosure<Property>() {
            @Override
            public void execute(Field field, Property property) {
                if (property.showAsColumn() || property.order() != Integer.MAX_VALUE) {
                    propertyFields.add(field);
                }
            }
        });

        collectPropertyNames(clazz.getSuperclass(), propertyFields);
    }

    public static <A extends Annotation> void forAllDo(Class< ? > clazz, AnnotationClosure<A> annotationClosure) {
        Field[] fields = clazz.getDeclaredFields();

        CollectionUtils.forAllDo(Arrays.asList(fields), annotationClosure);
    }

    public static <A extends Annotation> A getAnnotation(Class< ? > clazz, String propertyName, Class<A> annotationClass) {
        if (clazz == null) {
            return null;
        }

        Field[] fields = clazz.getDeclaredFields();

        Field field = (Field) CollectionUtils.find(Arrays.asList(fields), new AnnotationPredicate<A>(propertyName, annotationClass) {
        });

        if (field != null) {
            return field.getAnnotation(annotationClass);
        }

        return getAnnotation(clazz.getSuperclass(), propertyName, annotationClass);
    }

    public static boolean isValidOn(ICronExpression cronExpression, Date operationDate) {
        if (StringUtils.isBlank(cronExpression.getCronExpression())) {
            return true;
        }

        return operationDate == null || cronExpression.getCron().isSatisfiedBy(operationDate);
    }

    public static CronExpression buildCron(String cronExpression) {
        if (cronExpression != null) {
            try {
                return new CronExpression(cronExpression);
            } catch (ParseException e) {
                throw new AppException(EStatusReason.CRON_EXPRESSION_INVALID, e);
            }
        }

        return null;
    }

    public static void checkCronExpression(String cronExpression) {
        if (cronExpression != null) {
            try {
                new CronExpression(cronExpression);
            } catch (ParseException e) {
                throw new AppException(EStatusReason.CRON_EXPRESSION_INVALID, e);
            }
        }
    }

    public static <S> S getService(Class< ? > bundleClass, Class<S> serviceClass, boolean throwIfNull) {
        BundleContext bundleContext = FrameworkUtil.getBundle(bundleClass).getBundleContext();
        ServiceReference<S> reference = bundleContext.getServiceReference(serviceClass);

        S service = null;
        if (reference != null) {
            service = bundleContext.getService(reference);
        }

        if (service == null && throwIfNull) {
            throw new AppException(EStatusReason.SERVICE_NOT_FOUND);
        }

        return service;
    }

    public static boolean isI18NField(Field field) {
        Where where = field.getAnnotation(Where.class);

        return where != null && where.value().isI18N();
    }

    public static boolean checkMinLengthI18N(String string) {
        return StringUtils.isBlank(string) || string.length() >= ModelProperties.getInstance().minSearchCharacterI18N();
    }

    public static AppException convert(PersistOperation operation, PersistenceException pe) {
        EStatusReason statusReason = EStatusReason.ERROR;

        if (operation.equals(PersistOperation.DELETE)) {
            statusReason = EStatusReason.REFERENCED_OBJECT_FOUND;
        }

        return new AppException(statusReason, pe);
    }

    // Via Azzano, 137, 24050 Grassobbio, BG, Italia
    public static String getLocationAddress(ILocation location) {
        return location.getAddress()
                + ", "
                + location.getCivicNumber()
                + ", "
                + location.getZipCode()
                + ' '
                + location.getCity()
                + ", "
                + location.getProvCode()
                + ", "
                + location.getCountry();
    }

    public static <T extends IEMFModel> T copy(T model) {
        Copier copier = new CustomCopier();
        EObject result = copier.copy(model);
        copier.copyReferences();

        T copiedModel = (T) result;

//        T copiedModel = EcoreUtil.copy(model);

        copiedModel.eSetDeliver(false);
        copiedModel.setDirty(model.isDirty());
        copiedModel.eSetDeliver(true);

        return copiedModel;
    }

    public static EClass getEClass(Class< ? > dtoClass) {
        for (Object object : EPackage.Registry.INSTANCE.values()) {
            EPackage ePackage = null;

            if (object instanceof EPackage) {
                ePackage = (EPackage) object;
            } else if (object instanceof EPackage.Descriptor) {
                ePackage = ((EPackage.Descriptor) object).getEPackage();
            }

            if (ePackage != null) {
                for (EClassifier classifier : ePackage.getEClassifiers()) {
                    if (dtoClass.isAssignableFrom(classifier.getInstanceClass())) {
                        return (EClass) classifier;
                    }
                }
            }
        }

        return null;
    }

    public static <D extends EMFModel> List<D> buildModelList(final EClass modelEClass, List< ? extends Object> dbModelList) {
        return (List<D>) CollectionUtils.collect(dbModelList, new Transformer() {
            @Override
            public D transform(Object object) {
                return buildModel(modelEClass, object);
            }
        });
    }

    public static <D extends EMFModel> D buildModel(EClass modelEClass, Object dbModel) {
        EFactory factory = modelEClass.getEPackage().getEFactoryInstance();
        D model = (D) factory.create(modelEClass);

        try {
            for (EStructuralFeature feature : modelEClass.getEAllStructuralFeatures()) {
                if (!feature.isChangeable() || (Boolean) getAnnotation(feature, EAnnotation.CUSTOM_BUILD)) {
                    continue;
                }

                if (feature.isTransient() && !IEMFEnhancedEnum.class.isAssignableFrom(feature.getEType().getInstanceClass())) {
                    continue;
                }

                String property = (String) getAnnotation(feature, EAnnotation.DB_PROPERTY, feature.getName());

                try {
                    model.eSet(feature, PropertyUtils.getProperty(dbModel, property));
                } catch (NoSuchMethodException e) {
                    // ignore property
                }
            }

            if (factory instanceof CustomModelFactory) {
                model = ((CustomModelFactory) factory).buildCustomModel(dbModel, model);
            }
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        model.setDirty(false);

        return model;
    }

    public static <D extends EMFModel> Object build(D model) {
        Object dbModel = null;
        try {
            EClass modelEClass = model.eClass();
            Class< ? > dbModelClass = (Class< ? >) getAnnotation(modelEClass, EAnnotation.DB_MODEL);

            dbModel = dbModelClass.newInstance();

            for (EStructuralFeature feature : modelEClass.getEStructuralFeatures()) {
                if (feature.isTransient() && feature instanceof EAttribute || (Boolean) getAnnotation(feature, EAnnotation.CUSTOM_BUILD)) {
                    continue;
                }

                String property = (String) getAnnotation(feature, EAnnotation.DB_PROPERTY, feature.getName());

                try {
                    PropertyUtils.setProperty(dbModel, property, model.eGet(feature));
                } catch (NoSuchMethodException e) {
                    // ignore property
                }
            }

            EFactory factory = modelEClass.getEPackage().getEFactoryInstance();
            if (factory instanceof CustomModelFactory) {
                dbModel = ((CustomModelFactory) factory).buildCustomDbModel(dbModel, model);
            }

        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }

        return dbModel;
    }

    public static void forAllDo(EClass eClass, EAnnotationClosure< ? > eAnnotationClosure) {
        List<EStructuralFeature> features = eClass.getEAllStructuralFeatures();

        forAllDo(features, eAnnotationClosure);
    }

    public static void forAllDo(List<EStructuralFeature> features, EAnnotationClosure< ? > eAnnotationClosure) {
        CollectionUtils.forAllDo(features, eAnnotationClosure);
    }

    public static boolean isI18NFeature(EStructuralFeature feature) {
        EWhereClauseEMF clause = (EWhereClauseEMF) getAnnotation(feature, EAnnotation.CLAUSE, EWhereClauseEMF.NONE);

        return clause.equals(EWhereClauseEMF.I18N);
    }

    // /**
    // * Mappa di enum
    // */
    // private static ConcurrentMap<Class<? extends IEnum>, ConcurrentMap<String, IEnum>> enums = new ConcurrentHashMap<Class<? extends IEnum>,
    // ConcurrentMap<String, IEnum>>();
    //
    // /**
    // * Aggiunge estensione Enum
    // * Per i progetti che estendo LA2
    // *
    // * @param interfaceClass
    // * classe di interfaccia
    // * @param defaultEnumClass
    // * calsse default enume
    // * @param extendedEnumClass
    // * classe che estende l'enum
    // * @param <I>
    // * generico
    // * @param <E>
    // * generico
    // * @param <EX>
    // * generico
    // */
    // public static <I extends IEnum, E extends Enum<E>, EX extends Enum<EX>> void addEnumExtension(Class<I> interfaceClass, Class<E>
    // defaultEnumClass,
    // Class<EX> extendedEnumClass) {
    // synchronized (enums) {
    // ConcurrentMap<String, I> enumMap = getEnumMap(interfaceClass, defaultEnumClass);
    //
    // for (Enum<EX> ex : extendedEnumClass.getEnumConstants()) {
    // enumMap.putIfAbsent(ex.name(), (I) ex);
    // }
    // }
    // }
    //
    // /**
    // * Ricava un Enum
    // *
    // * @param interfaceClass
    // * classe di interfaccia
    // * @param defaultEnumClass
    // * classe enum di fefault
    // * @param name
    // * nome
    // * @param <I>
    // * generico
    // * @param <E>
    // * generico
    // * @return l'enum
    // */
    // public static <I extends IEnum, E extends Enum<E>> I getEnum(Class<I> interfaceClass, Class<E> defaultEnumClass, String name) {
    // ConcurrentMap<String, I> enumMap = getEnumMap(interfaceClass, defaultEnumClass);
    //
    // return enumMap.get(name);
    // }
    //
    // /**
    // * Ricava mappa di Enum
    // *
    // * @param interfaceClass
    // * classe di interfaccia
    // * @param defaultEnumClass
    // * classe di default dell'enum
    // * @param <I>
    // * generico
    // * @param <E>
    // * generico
    // * @return l'enum
    // */
    // public static <I extends IEnum, E extends Enum<E>> ConcurrentMap<String, I> getEnumMap(Class<I> interfaceClass, Class<E> defaultEnumClass) {
    // synchronized (enums) {
    // ConcurrentMap<String, IEnum> enumMap = enums.get(interfaceClass);
    //
    // if (enumMap == null) {
    // if (defaultEnumClass != null) {
    // enumMap = new ConcurrentHashMap<String, IEnum>();
    // enums.putIfAbsent(interfaceClass, enumMap);
    //
    // for (Enum<E> e : defaultEnumClass.getEnumConstants()) {
    // enumMap.putIfAbsent(e.name(), (IEnum) e);
    // }
    // } else {
    // // caso anomalo in cui viene fatta la chiamata senza la classe enum di default( tipicamente da un converter web)
    // // ma la mappa con l'interfaccia richiesta non e' stata precaricata nell'EnumManager
    // LOGGER.warn("call to getEnumMap without defaultEnumClass but enums not initialized");
    // }
    // }
    //
    // return (ConcurrentMap<String, I>) enumMap;
    // }
    // }
    //
    // /**
    // * Ha mappa Enum
    // *
    // * @param interfaceClass
    // * casse di interfaccia
    // * @param <I>
    // * generico
    // * @return true o false
    // */
    // public static <I extends IEnum> boolean hasEnumMap(Class<I> interfaceClass) {
    // synchronized (enums) {
    // return enums.containsKey(interfaceClass);
    // }
    // }

    public static Object getAnnotation(EModelElement modelElement, EAnnotation annotation) {
        return getAnnotation(modelElement, annotation, annotation.getDefaultValue());
    }

    public static Object getAnnotation(EModelElement modelElement, EAnnotation annotation, Object defaultValue) {
        String value = EcoreUtil.getAnnotation(modelElement, annotation.sourceURI(), annotation.key());

        EDataType dataType = annotation.getEDataType();

        if (EcorePackage.Literals.EJAVA_CLASS.equals(dataType)) {
            try {
                return FrameworkUtil.getBundle(((EClass) modelElement).getInstanceClass()).loadClass(value);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } else if (ModelInterfacesPackage.Literals.ESTRUCTURAL_FEATURE.equals(dataType) && value != null) {
            return getEStructuralFeature(modelElement, value);
        }

        return value == null ? defaultValue : dataType.getEPackage().getEFactoryInstance().createFromString(dataType, value);
    }

    public static EStructuralFeature getEStructuralFeature(EModelElement modelElement, String value) {
        EClass eClass = null;

        if (EcorePackage.Literals.ECLASS.isSuperTypeOf(modelElement.eClass())) {
            eClass = (EClass) modelElement;
        } else if (EcorePackage.Literals.EREFERENCE.isSuperTypeOf(modelElement.eClass())) {
            eClass = (EClass) modelElement.eContainer();
        } else {
            eClass = (EClass) modelElement.eContainingFeature();
        }

        return eClass.getEStructuralFeature(value);
    }

    public static <E extends IEMFEnhancedEnum<E>> void registerEnhancedEnum(E enhancedEnum, Class<E> enhancedEnumClass) {
        String name = enhancedEnum.getName();

        List<E> list = (List<E>) LIST_VALUES.get(enhancedEnumClass);
        Map<String, E> values = (Map<String, E>) getMapValues(DEFAULT_KEY, enhancedEnumClass);

        if (list == null) {
            list = new ArrayList<>();
            LIST_VALUES.put(enhancedEnumClass, list);
        }

        if (values.get(name) != null) {
            // duplicate value probably due to a bundle redeploy
            System.out.println("Duplicate name #" + name + " for enum #" + enhancedEnumClass + " - overwrite");

            for (Iterator<E> iterator = list.iterator(); iterator.hasNext();) {
                E e = iterator.next();

                if (e.getName().equals(name)) {
                    iterator.remove();
                    break;
                }
            }

            for (Map.Entry<Object, Map<String, ? extends IEMFEnhancedEnum< ? >>> entry : MAP_VALUES.get(enhancedEnumClass).entrySet()) {
                Map<String, ? extends IEMFEnhancedEnum< ? >> mapValue = entry.getValue();

                mapValue.remove(name);
            }
        }

        list.add(enhancedEnum);
        values.put(name, enhancedEnum);
    }

    private static <E extends IEMFEnhancedEnum<E>> Map<String, ? extends IEMFEnhancedEnum< ? >> getMapValues(Object objectKey, Class<E> enhancedEnumClass) {
        Map<Object, Map<String, ? extends IEMFEnhancedEnum< ? >>> map = MAP_VALUES.get(enhancedEnumClass);

        if (map == null) {
            map = new WeakHashMap<>();

            MAP_VALUES.put(enhancedEnumClass, map);
        }

        Map<String, E> mapValues = (Map<String, E>) map.get(objectKey);

        if (mapValues == null) {
            mapValues = new HashMap<>();

            map.put(objectKey, mapValues);

            if (objectKey != DEFAULT_KEY) {
                Map<String, E> defaultMapValues = (Map<String, E>) getMapValues(DEFAULT_KEY, enhancedEnumClass);

                for (Entry<String, E> defaultEntry : defaultMapValues.entrySet()) {
                    mapValues.put(defaultEntry.getKey(), (E) clone(defaultEntry.getValue()));
                }
            }
        }

        return mapValues;
    }

    /**
     * Value of.
     *
     * @param enhancedEnumClass
     *            the enhanced enum class
     * @param name
     *            the name
     * @return the e
     */
    public static <E extends IEMFEnhancedEnum<E>> E valueOf(Class<E> enhancedEnumClass, String name) {
        return valueOf(DEFAULT_KEY, enhancedEnumClass, name, true);
    }

    public static <E extends IEMFEnhancedEnum<E>> E valueOf(Object objectKey, Class<E> enhancedEnumClass, String name) {
        return valueOf(objectKey, enhancedEnumClass, name, true);
    }

    public static <E extends IEMFEnhancedEnum<E>> E valueOf(Class<E> enhancedEnumClass, String name, boolean throwException) {
        return valueOf(DEFAULT_KEY, enhancedEnumClass, name, throwException);
    }

    public static <E extends IEMFEnhancedEnum<E>> E valueOf(Object objectKey, Class<E> enhancedEnumClass, String name, boolean throwException) {
        Map<String, E> values = (Map<String, E>) getMapValues(objectKey, enhancedEnumClass);

        if (values.isEmpty() && throwException) {
            throw new IllegalArgumentException("No values for Enhanced enum class #" + enhancedEnumClass + " - name #" + name);
        }

        E value = values.get(name);

        if (value == null) {
            if (throwException) {
                throw new IllegalArgumentException("No Enhanced enum const " + enhancedEnumClass + '.' + name);
            } else {
                System.out.println("No Enhanced enum const " + enhancedEnumClass + '.' + name);
            }
        }

        return value;
    }

    /**
     * Estrae dal solo nome un enum, da usare con cautela perche' potrebbero esserci enum di diverse classi con lo stesso name
     * @param name
     */
    public static <E extends IEMFEnhancedEnum<E> & Serializable> E enumByName(String name) {
        for (Map<Object, Map<String, ? extends IEMFEnhancedEnum< ? >>> maps : MAP_VALUES.values()) {
            Map<String, ? extends IEMFEnhancedEnum< ? >> values = maps.get(DEFAULT_KEY);

            E value = (E) values.get(name);

            if (value != null) {
                return value;
            }
        }

        return null;
    }

    public static <E extends IEMFEnhancedEnum<E>> List<E> values(Class< ? extends E> enhancedEnumClass) {
        List<E> values = (List<E>) LIST_VALUES.get(enhancedEnumClass);

        if (values == null) {
            throw new IllegalArgumentException("No Enhanced enum values for const " + enhancedEnumClass);
        }

        return new ArrayList<>(values); // copia di sicurezza
    }

    public static String getID(EObject eObject) {
        EClass eClass = eObject.eClass();
        EAttribute eIDAttribute = eClass.getEIDAttribute();

        if (eIDAttribute != null) {
            return EcoreUtil.getID(eObject);
        }

        for (EReference reference : eClass.getEAllReferences()) {
            Boolean id = (Boolean) getAnnotation(reference, EAnnotation.ID);

            if (id) {
                if (eObject.eIsSet(reference)) {
                    return eObject.eGet(reference).toString();
                }

                break;
            }
        }

        return null;
    }

    public static boolean equals(final Object obj1, final Object obj2) {
        if (obj1 == obj2) {
            return true;
        }

        if (obj1 == null || obj2 == null || !(obj1 instanceof EObject) || !(obj2 instanceof EObject)) {
            return false;
        }

        String id1 = getID((EObject) obj1);
        String id2 = getID((EObject) obj2);

        return ObjectUtils.equals(id1, id2);
    }

    public static int compareTo(final EObject obj1, final EObject obj2) {
        if (obj1 instanceof Comparable) {
            return ((Comparable<EObject>) obj1).compareTo(obj2);
        }

        String id1 = getID(obj1);
        String id2 = getID(obj2);

        return id1.compareTo(id2);
    }

    public static <T> void addAll(List<T> srcList, List<T> destList) {
        for (T t : srcList) {
            if (!destList.contains(t)) {
                destList.add(t);
            }
        }
    }

    public static <T> void removeAll(List<T> list, List<T> listToRemove) {
        for (T t : listToRemove) {
            list.remove(t);
        }
    }

    public static <T> void clear(List<T> list) {
        for (Iterator<T> iterator = list.iterator(); iterator.hasNext();) {
            iterator.next();
            iterator.remove();
        }
    }

    public static void sort(List<EStructuralFeature> list) {
        Collections.sort(list, new Comparator<EStructuralFeature>() {

            @Override
            public int compare(EStructuralFeature o1, EStructuralFeature o2) {
                return o1.getFeatureID() - o2.getFeatureID();
            }
        });
    }

    public static String getRAPLocaleString(boolean translate) {
        Locale locale = getRAPLocale(translate);

        if (locale != null) {
            return locale.toString();
        }

        return null;
    }

    public static Locale getRAPLocale(boolean translate) {
        if (ContextProvider.hasContext() && translate) {
            Locale locale = RWT.getUISession().getLocale();

            if (!locale.equals(Locale.getDefault())) {
                return locale;
            }
        }

        return null;
    }

}