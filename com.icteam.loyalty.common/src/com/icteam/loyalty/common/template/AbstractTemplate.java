package com.icteam.loyalty.common.template;

import java.beans.PropertyChangeSupport;
import java.beans.PropertyDescriptor;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.security.AccessController;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Dictionary;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Stream;

import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.From;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.ManagedType;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.security.auth.Subject;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;

import com.icteam.loyalty.common.enums.EDynamicFilterable;
import com.icteam.loyalty.common.enums.EStatus;
import com.icteam.loyalty.common.enums.Property;
import com.icteam.loyalty.common.enums.Where;
import com.icteam.loyalty.common.enums.WhereTemplate;
import com.icteam.loyalty.common.interfaces.IFilterPriority;
import com.icteam.loyalty.common.interfaces.IModel;
import com.icteam.loyalty.common.interfaces.ITemplate;
import com.icteam.loyalty.common.internal.Messages;
import com.querydsl.core.support.QueryBase;
import com.querydsl.sql.RelationalPathBase;

/**
 * AbstractTemplate
 *
 * @param <T>
 *            generico
 */
public abstract class AbstractTemplate<T extends Serializable> implements ITemplate<T>, IModel, Cloneable {

	private static final String STATUS_FIELD = "status";

	private static final long serialVersionUID = -5775813505727656200L;

	@Property(translatable = false)
	private final List<String> excludedProperties = new ArrayList<>();

	@Property(translatable = false)
	private OrderDirection[] orderDirections;
	@Property(translatable = false)
	private String[] orderFields;
	@Property(translatable = false)
	private OrderDirection dynamicOrderDirection = OrderDirection.NONE;
	@Property(translatable = false)
	private String dynamicOrderField;
	@Property(translatable = false)
	private int maxResults = -1;
	@Property(translatable = false)
	private int firstResult = -1;
	@Property(translatable = false)
	private Distinct distinct = Distinct.SQL;
	@Property(translatable = false)
	private boolean lightSearch;
	@Property(translatable = false)
	private boolean singleResult;

	@Property(translatable = false)
	private List<Predicate> wheres;

	@Property(translatable = false)
	private List<String> dynamicFilterProperties = new ArrayList<>();
	@Property(translatable = false)
	private String[] dynamicFilters;

	@Property(translatable = false)
	private From<?, T> root;

	@Property(translatable = false)
	private CriteriaBuilder builder;

	@Property(translatable = false)
	private CriteriaQuery<?> criteria;

	@Property(translatable = false)
	private boolean dirty = false;

	@Property(translatable = false)
	private boolean editable = true;

	@Property(translatable = false)
	private final PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

	@Property(translatable = false)
	Field id;

	@Property(translatable = false)
	private boolean nested = false;

	/**
	 * Costruttore
	 */
	public AbstractTemplate() {
		getExcludedProperties().add("class");
		getExcludedProperties().add("excludedProperties");
		getExcludedProperties().add("searchMode");
		getExcludedProperties().add("dirty");
		getExcludedProperties().add("editable");
		getExcludedProperties().add("changeSupport");
		getExcludedProperties().add("distinct");
		getExcludedProperties().add("lightSearch");
		getExcludedProperties().add("singleResult");
		getExcludedProperties().add("maxResults");
		getExcludedProperties().add("firstResult");
		getExcludedProperties().add("templateClass");
		getExcludedProperties().add("metamodelClass");

		initDefaultDynamicFilterProperties();

		initDefaults();

		templateClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	protected void initDefaults() {
	}

	@Override
	public boolean isDirty() {
		return dirty && editable;
	}

	@Override
	public void setDirty(boolean dirty) {
		if (editable) {
			firePropertyChange("dirty", this.dirty, this.dirty = dirty);
		}
	}

	@Override
	public boolean isEditable() {
		return editable;
	}

	@Override
	public void setEditable(boolean editable) {
		this.editable = editable;
	}

	protected void firePropertyChange(String propertyName, Object oldValue, Object newValue) {
		if (!Objects.equals(oldValue, newValue)) {
			changeSupport.firePropertyChange(propertyName, oldValue, newValue);
		}
	}

	protected void initDefaultDynamicFilterProperties() {
		List<String> filterableProperties = getFilterableProperties();
		List<String> defaultDynamicFilterProperties = new ArrayList<>();

		for (String prop : filterableProperties) {
			try {
				Field field = getClass().getDeclaredField(prop);

				if (field.getAnnotation(Property.class).dynamicFilterable().equals(EDynamicFilterable.DEFAULT_FILTER)) {
					defaultDynamicFilterProperties.add(prop);
				}
			} catch (NoSuchFieldException | SecurityException e) {
				e.printStackTrace();
			}
		}

		if (!defaultDynamicFilterProperties.isEmpty()) {
			setDynamicFilterProperties(defaultDynamicFilterProperties);
		}
	}

	public List<String> getFilterableProperties() {
		final List<String> filterableProperties = new ArrayList<>();

		Stream.of(getClass().getDeclaredFields()).forEach(field -> {
			Property property = field.getAnnotation(Property.class);

			if (property != null && !property.dynamicFilterable().equals(EDynamicFilterable.NO)) {
				filterableProperties.add(field.getName());
			}
		});

		return filterableProperties;
	}

	@Override
	public Class<T> getTemplateClass() {
		return templateClass;
	}

	@Override
	public ManagedType<T> getMetamodelClass() {
		return entityManager == null ? null : entityManager.getMetamodel().managedType(getTemplateClass());
	}

	private ESearchMode searchMode = ESearchMode.DEFAULT;

	private EntityManager entityManager;

	private final Class<T> templateClass;

	/**
	 * Indica se e' inizializzato
	 *
	 * @return true se si, false se no
	 */
	@Override
	public boolean initialized() {
		boolean set = false;

		Map<String, Object> properties;
		try {
			properties = PropertyUtils.describe(this);

			for (Entry<String, Object> property : properties.entrySet()) {
				if (initialized(property.getKey(), property.getValue())) {
					set = true;
					break;
				}
			}
		} catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
			e.printStackTrace();
		}

		return set;
	}

	protected boolean initialized(String name, Object value) {
		if (value == null || getExcludedProperties().contains(name)) {
			return false;
		}

		if (value instanceof ITemplate<?>) {
			return ((ITemplate<T>) value).initialized();
		}

		return !(value instanceof Collection) || !((Collection<?>) value).isEmpty();

	}

	/**
	 * @return il valore della variabile excludedProperties di tipo
	 *         PsiType:List<String>.
	 */
	protected List<String> getExcludedProperties() {
		return excludedProperties;
	}

	/**
	 * Gets search mode.
	 *
	 * @return il valore della variabile searchMode di tipo PsiType:ESearchMode.
	 */
	public ESearchMode getSearchMode() {
		return searchMode;
	}

	/**
	 * Setter per la variabile searchMode.
	 *
	 * @param searchMode
	 *            il valore da assegnare alla variabile di tipo
	 *            PsiType:ESearchMode.
	 */
	public void setSearchMode(ESearchMode searchMode) {
		this.searchMode = searchMode;
	}

	@Override
	public String[] getOrderFields() {
		return orderFields;
	}

	@Override
	public OrderDirection[] getOrderDirections() {
		return orderDirections;
	}

	/**
	 * Setter per la variabile orderDirections.
	 *
	 * @param orderDirections
	 *            il valore da assegnare alla variabile di tipo
	 *            PsiType:OrderDirection....
	 */
	public void setOrderDirections(OrderDirection... orderDirections) {
		this.orderDirections = orderDirections;
	}

	/**
	 * Setter per la variabile orderFields.
	 *
	 * @param orderFields
	 *            il valore da assegnare alla variabile di tipo
	 *            PsiType:String....
	 */
	public void setOrderFields(String... orderFields) {
		this.orderFields = orderFields;
	}

	public void setDynamicOrder(String dynamicOrderField, OrderDirection dynamicOrderDirection) {
		this.dynamicOrderField = dynamicOrderField;
		this.dynamicOrderDirection = dynamicOrderDirection;
	}

	/**
	 * Is light search.
	 *
	 * @return il valore della variabile lightSearch di tipo PsiType:boolean.
	 */
	public boolean isLightSearch() {
		return lightSearch;
	}

	/**
	 * Setter per la variabile lightSearch.
	 *
	 * @param lightSearch
	 *            il valore da assegnare alla variabile di tipo PsiType:boolean.
	 */
	public void setLightSearch(boolean lightSearch) {
		this.lightSearch = lightSearch;
	}

	/**
	 * Is single result.
	 *
	 * @return il valore della variabile singleResult di tipo PsiType:boolean.
	 */
	public boolean isSingleResult() {
		return singleResult;
	}

	/**
	 * Setter per la variabile singleResult.
	 *
	 * @param singleResult
	 *            il valore da assegnare alla variabile di tipo PsiType:boolean.
	 */
	public void setSingleResult(boolean singleResult) {
		this.singleResult = singleResult;
	}

	private void buildOrder() {
		List<Order> orders = new ArrayList<>();

		if (getOrderDirections() != null) {
			for (int i = 0; i < getOrderDirections().length; i++) {
				if (getOrderDirections()[i].equals(OrderDirection.ASC)) {
					orders.add(builder.asc(buildFieldExpression(getOrderFields()[i])));
				} else if (getOrderDirections()[i].equals(OrderDirection.DESC)) {
					orders.add(builder.desc(buildFieldExpression(getOrderFields()[i])));
				}
			}
		}

		if (hasDynamicOrder()) {
			if (dynamicOrderDirection.equals(OrderDirection.ASC)) {
				orders.add(builder.asc(buildFieldExpression(dynamicOrderField)));
			} else if (dynamicOrderDirection.equals(OrderDirection.DESC)) {
				orders.add(builder.desc(buildFieldExpression(dynamicOrderField)));
			}
		}

		criteria.orderBy(orders);
	}

	private boolean hasDynamicOrder() {
		return dynamicOrderDirection != null && !OrderDirection.NONE.equals(dynamicOrderDirection);
	}

	private Expression<?> buildFieldExpression(String expression) {
		String[] items = expression.split("\\.");
		Path<?> out = root;
		for (String item : items) {
			out = out.get(item);
		}
		return out;
	}

	/**
	 * Gets wheres.
	 *
	 * @return il valore della variabile wheres di tipo PsiType:List<Predicate>.
	 */
	public List<Predicate> getWheres() {
		return wheres;
	}

	/**
	 * Setter per la variabile wheres.
	 *
	 * @param wheres
	 *            il valore da assegnare alla variabile di tipo
	 *            PsiType:List<Predicate>.
	 */
	protected void setWheres(List<Predicate> wheres) {
		this.wheres = wheres;
	}

	/**
	 * Gets root.
	 *
	 * @return il valore della variabile root di tipo PsiType:From<?, ?>.
	 */
	public From<?, T> getRoot() {
		return root;
	}

	/**
	 * Setter per la variabile root.
	 *
	 * @param root
	 *            il valore da assegnare alla variabile di tipo PsiType:From<?,
	 *            ?>.
	 */
	protected void setRoot(From<?, T> root) {
		this.root = root;
	}

	/**
	 * Gets builder.
	 *
	 * @return il valore della variabile builder di tipo
	 *         PsiType:CriteriaBuilder.
	 */
	public CriteriaBuilder getBuilder() {
		return builder;
	}

	/**
	 * Setter per la variabile builder.
	 *
	 * @param builder
	 *            il valore da assegnare alla variabile di tipo
	 *            PsiType:CriteriaBuilder.
	 */
	protected void setBuilder(CriteriaBuilder builder) {
		this.builder = builder;
	}

	/**
	 * Gets criteria.
	 *
	 * @return il valore della variabile criteria di tipo
	 *         PsiType:CriteriaQuery<R>.
	 */
	public <R> CriteriaQuery<R> getCriteria() {
		return (CriteriaQuery<R>) criteria;
	}

	/**
	 * Setter per la variabile criteria.
	 *
	 * @param criteria
	 *            il valore da assegnare alla variabile di tipo
	 *            PsiType:CriteriaQuery<R>.
	 */
	protected <R> void setCriteria(CriteriaQuery<R> criteria) {
		this.criteria = criteria;
	}

	/**
	 * Crea Criteria
	 *
	 * @param builder
	 *            CriteriaBuilder
	 * @return CriteriaQuery criteria query
	 */
	public <R> CriteriaQuery<R> buildCriteria(CriteriaBuilder builder) {
		return (CriteriaQuery<R>) buildCriteria(getTemplateClass(), builder);
	}

	public <R> CriteriaQuery<R> buildCriteria(Class<R> resultClass, CriteriaBuilder builder) {
		initCriteria(resultClass, builder);

		return buildCriteria();
	}

	/**
	 * Init criteria.
	 *
	 * @param builder
	 *            the builder
	 */
	protected <R> void initCriteria(Class<R> resultClass, CriteriaBuilder builder) {
		setCriteria(builder.createQuery(resultClass));
		setRoot(criteria.from(getTemplateClass()));
		setBuilder(builder);
		setWheres(new ArrayList<Predicate>());
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	protected EntityManager getEntityManager() {
		return entityManager;
	}

	/**
	 * Ritorna la lista dei risultati
	 *
	 * @param em
	 *            entityManager
	 * @return lista dei risultati
	 */
	@Override
	public <R> List<R> getResultList(EntityManager em) {
		setEntityManager(em);

		List<R> list;

		if (isLightSearch()) {
			list = getResultListLightSearch(em);
		} else {
			CriteriaQuery<R> internalCriteria = buildCriteria(em.getCriteriaBuilder());

			TypedQuery<R> query = em.createQuery(internalCriteria);

			handleMaxResults(query);
			handleFirstResult(query);

			list = query.getResultList();
		}

		list = initializeAndApplyFilters(list);

		if (isSingleResult()) {
			if (list.isEmpty()) {
				throw new NoResultException();
			}

			if (list.size() > 1) {
				throw new NonUniqueResultException();
			}
		}

		return list;
	}

	/**
	 * metodo utile per implementare filtri custom nei template di default
	 * applica il filtro distinct via codice se abilitato
	 *
	 * @param list
	 */
	protected <R> List<R> initializeAndApplyFilters(List<R> list) {
		list = filterDistinctValues(list);

		list = filterPriority(list);

		return list;
	}

	private <R> List<R> filterPriority(List<R> list) {
		if (this instanceof IFilterPriority) {
			if (BooleanUtils.isTrue(((IFilterPriority) this).getFilterPriority())) {
				list = (List<R>) ModelUtil.filter((List<IPrioritized>) list);
			}
		}

		return list;
	}

	/**
	 * filtro i risultati via codice se il valore di
	 *
	 * @param list
	 */
	private <R> List<R> filterDistinctValues(List<R> list) {
		if (getDistinct().equals(Distinct.CODE)) {
			Set<R> set = new LinkedHashSet<>(list);
			list = new ArrayList<>(set);
		}

		return list;
	}

	/**
	 * Gets result count.
	 *
	 * @param em
	 *            the entity manager
	 * @return the result count
	 */
	@Override
	public <R> Long getResultCount(EntityManager em) {
		setEntityManager(em);

		CriteriaQuery<Long> criteriaCount = buildCriteria(em.getCriteriaBuilder());
		criteriaCount.select(getBuilder().countDistinct(getRoot()));
		criteriaCount.orderBy((List<Order>) null); // annullo l'eventuale
													// ordinamento, con la count
													// si rompe

		return em.createQuery(criteriaCount).getSingleResult();
	}

	private <R> void handleFirstResult(TypedQuery<R> query) {
		if (getFirstResult() != -1) {
			query.setFirstResult(getFirstResult());
		}
	}

	private <R> void handleMaxResults(TypedQuery<R> query) {
		if (getMaxResults() != -1) {
			query.setMaxResults(getMaxResults());
		}
	}

	/**
	 * Gets result list light search.
	 *
	 * @param em
	 *            the entity manager
	 * @return the result list light search
	 */
	protected <R> List<R> getResultListLightSearch(EntityManager em) {
		T result = entityManager.find(getTemplateClass(), getId());

		List<T> list = new ArrayList<>();

		if (result != null) {
			list.add(result);
		}

		Iterator<T> iterator = list.iterator();
		while (iterator.hasNext()) {
			result = iterator.next();

			if (checkDefaultWheres(result) && checkLightSearch(result)) {
				continue;
			}

			iterator.remove();
		}

		return (List<R>) list;
	}

	protected boolean checkLightSearch(T result) {
		return true;
	}

	private Object getId() {
		if (id == null) {
			id = Stream.of(getClass().getDeclaredFields()).filter(field -> field.isAnnotationPresent(Id.class))
					.findFirst().get();
		}

		try {
			return id.get(this);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * Ritorna il primo risultato della query
	 *
	 * @param em
	 *            EntityManager
	 * @return singola classe
	 */
	@Override
	public <R> R getFirstResult(EntityManager em) {
		int oldMaxResults = maxResults;

		setMaxResults(1);

		try {
			List<R> list = getResultList(em);
			if (list.isEmpty()) {
				return null;
			}

			return list.get(0);
		} finally {
			setMaxResults(oldMaxResults);
		}
	}

	/**
	 * Build criteria.
	 *
	 * @return the criteria query
	 */
	protected <R> CriteriaQuery<R> buildCriteria() {
		buildWheres();

		buildFetches();

		buildDynamicFilters();

		criteria.where(wheres.toArray(new Predicate[wheres.size()]));

		buildOrder();

		criteria.distinct(getDistinct().equals(Distinct.SQL));

		return getCriteria();
	}

	private void buildAnnotationWheres() {
		Stream.of(getClass().getDeclaredFields()).filter(field -> field.isAnnotationPresent(Where.class))
				.forEach(field -> {
					Where where = field.getAnnotation(Where.class);

					if (!field.getName().equals(STATUS_FIELD)) {
						try {
							switch (where.value()) {
							case EQUAL:
								handleWhereEqual(field.getName(), (Serializable) field.get(AbstractTemplate.this));
								break;
							case GREATER_EQUAL:
								handleWhereGreaterOrEqual(where.fieldName(),
										(Comparable) field.get(AbstractTemplate.this));
								break;
							case LIKE_IGNORE_CASE:
								handleWhereLikeIgnoreCase(field.getName(), (String) field.get(AbstractTemplate.this));
								break;

							case I18N:
								// nel caso di template innestato se il campo e'
								// un
								// id ho la chiave e non la traduzione
								if (isNested() && field.isAnnotationPresent(Id.class)) {
									handleWhereEqual(field.getName(), (Serializable) field.get(AbstractTemplate.this));
								} else {
									handleWhereI18N(field.getName(), (String) field.get(AbstractTemplate.this),
											where.prefixI18N());
								}
								break;

							default:
								break;
							}
						} catch (IllegalArgumentException | IllegalAccessException e) {
							e.printStackTrace();
						}
					}
				});

		Stream.of(getClass().getDeclaredFields()).filter(field -> field.isAnnotationPresent(WhereTemplate.class))
				.forEach(field -> {
					try {
						handleWhereTemplateEqual(field.getName(),
								(AbstractTemplate<Serializable>) field.get(AbstractTemplate.this));
					} catch (IllegalArgumentException | IllegalAccessException e) {
						e.printStackTrace();
					}
				});
	}

	<Y extends Serializable> void handleWhereEqual(String field, Y value) {
		SingularAttribute<? super T, Y> singularAttribute = (SingularAttribute<? super T, Y>) getMetamodelClass()
				.getSingularAttribute(field);

		buildWhereEqual(singularAttribute, value);
	}

	<Y extends Comparable<? super Y>> void handleWhereGreaterOrEqual(String field, Y value) {
		SingularAttribute<? super T, Y> singularAttribute = (SingularAttribute<? super T, Y>) getMetamodelClass()
				.getSingularAttribute(field);

		buildWhereGreaterThanOrEqualTo(singularAttribute, value);
	}

	void handleWhereLikeIgnoreCase(String field, String value) {
		SingularAttribute<? super T, String> singularAttribute = (SingularAttribute<? super T, String>) getMetamodelClass()
				.getSingularAttribute(field);

		buildWhereLikeIgnoreCase(singularAttribute, value);
	}

	void handleWhereI18N(String field, String value, String prefixI18N) {
		if (value != null) {
			SingularAttribute<? super T, String> singularAttribute = (SingularAttribute<? super T, String>) getMetamodelClass()
					.getSingularAttribute(field);

			wheres.add(buildWhereI18N(singularAttribute, value, prefixI18N));
		}
	}

	private Predicate buildWhereI18N(SingularAttribute<? super T, String> singularAttribute, String value,
			String prefixI18N) {
		String keyClass = prefixI18N;

		if (StringUtils.isBlank(keyClass)) {
			keyClass = getMetamodelClass().getJavaType().getSimpleName() + "Dto";
		}

		Collection<String> keys = Messages.getKeys(keyClass, value);

		if (keys.size() > ModelProperties.getInstance().inClauseMaxLength()) {
			throw new AppException(EStatusReason.MAX_LENGTH_IN_IN_CLAUSE_REACHED);
		}

		return builder.isMember(root.get(singularAttribute), builder.literal(keys));
	}

	<Y extends Serializable> void handleWhereTemplateEqual(String field, AbstractTemplate<Y> value) {
		SingularAttribute<? super T, Y> singularAttribute = (SingularAttribute<? super T, Y>) getMetamodelClass()
				.getSingularAttribute(field);

		buildWhereTemplate(singularAttribute, value);
	}

	protected void buildFetches() {
		// defualt nothing
	}

	public List<String> getDynamicFilterProperties() {
		return dynamicFilterProperties;
	}

	public void setDynamicFilterProperties(List<String> dynamicFilterProperties) {
		if (dynamicFilterProperties == null) {
			dynamicFilterProperties = new ArrayList<>();
		}

		checkDynamicFilters(dynamicFilterProperties, dynamicFilters);

		this.dynamicFilterProperties = dynamicFilterProperties;
	}

	private void checkDynamicFilters(List<String> dynamicFilterProperties, String[] dynamicFilters) {
		if (dynamicFilterProperties != null && dynamicFilters != null && dynamicFilters.length > 0) {
			for (String fieldName : dynamicFilterProperties) {
				try {
					Field field = getClass().getDeclaredField(fieldName);

					if (ModelUtil.isI18NField(field)) {
						for (String dynamicFilter : dynamicFilters) {
							if (!ModelUtil.checkMinLengthI18N(dynamicFilter)) {
								throw new AppException(EStatusReason.MIN_CHARACTER_SEARCH_LENGTH,
										ModelProperties.getInstance().minSearchCharacterI18N());
							}
						}
					}
				} catch (NoSuchFieldException | SecurityException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void setRawFilter(String rawFilter) {
		String[] filters = StringUtils.stripAll(StringUtils.split(rawFilter));

		checkDynamicFilters(dynamicFilterProperties, filters);

		this.dynamicFilters = filters;
	}

	protected void buildDynamicFilters() {
		if (hasDynamicFilters()) {
			List<Predicate> predicates = new ArrayList<>();

			for (String fieldName : dynamicFilterProperties) {
				EntityType<T> metaModel = (EntityType<T>) getRoot().getModel();

				SingularAttribute<? super T, String> attribute = metaModel.getSingularAttribute(fieldName,
						String.class);

				try {
					Field field = getClass().getDeclaredField(fieldName);
					Where ann = field.getAnnotation(Where.class);

					for (String filter : dynamicFilters) {
						if (ann != null && ann.value().isI18N()) {
							predicates.add(buildWhereI18N(attribute, filter, ann.prefixI18N()));
						} else {
							predicates.add(buildPredicateLikeIgnoreCase(attribute, filter));
						}
					}
				} catch (NoSuchFieldException | SecurityException e) {
					e.printStackTrace();
				}
			}

			if (!predicates.isEmpty()) {
				wheres.add(builder.or(predicates.toArray(new Predicate[] {})));
			}
		}
	}

	public boolean hasDynamicFilters() {
		return dynamicFilterProperties != null && dynamicFilters != null && dynamicFilters.length > 0;
	}

	/**
	 * Build wheres.
	 */
	protected void buildWheres() {
		buildAnnotationWheres();

		buildWhereValidDate();
		buildWhereFromToDate();
		buildWhereStatus();
	}

	/**
	 * Build where status.
	 */
	protected void buildWhereStatus() {
		if (this instanceof IStatusTemplate) {
			IStatusTemplate template = (IStatusTemplate) this;

			buildWhereEqual(getMetamodelClass().getSingularAttribute(STATUS_FIELD, EStatus.class),
					template.getStatus());
		}
	}

	/**
	 * Build where valid date.
	 */
	protected void buildWhereValidDate() {
		if (this instanceof IValidDateTemplate) {
			IValidDateTemplate template = (IValidDateTemplate) this;

			if (template.getValidDate() != null) {
				Date validDate = DateUtils.truncate(template.getValidDate(), Calendar.DAY_OF_MONTH);
				wheres.add(builder.lessThanOrEqualTo(
						root.get(getMetamodelClass().getSingularAttribute(IConstants.T_START, Date.class)), validDate));
				wheres.add(builder.or(
						builder.isNull(
								root.get(getMetamodelClass().getSingularAttribute(IConstants.T_END, Date.class))),
						builder.greaterThanOrEqualTo(
								root.get(getMetamodelClass().getSingularAttribute(IConstants.T_END, Date.class)),
								validDate)));
			}
		} else if (this instanceof IValidDateTime) {
			IValidDateTime template = (IValidDateTime) this;

			Date validDate = template.getValidDateTime();
			if (validDate != null) {
				wheres.add(builder.lessThanOrEqualTo(
						root.get(getMetamodelClass().getSingularAttribute(IConstants.T_START, Date.class)), validDate));
				wheres.add(builder.or(
						builder.isNull(
								root.get(getMetamodelClass().getSingularAttribute(IConstants.T_END, Date.class))),
						builder.greaterThanOrEqualTo(
								root.get(getMetamodelClass().getSingularAttribute(IConstants.T_END, Date.class)),
								validDate)));
			}
		}
	}

	/**
	 * Build where from to date.
	 */
	protected void buildWhereFromToDate() {
		if (this instanceof IFromToDateTemplate) {
			IFromToDateTemplate template = (IFromToDateTemplate) this;

			Date from = template.getFrom();
			if (from != null) {
				from = ModelUtil.safeSetDateTruncate(from);
				wheres.add(builder.or(
						builder.isNull(
								root.get(getMetamodelClass().getSingularAttribute(IConstants.T_END, Date.class))),
						builder.greaterThanOrEqualTo(
								root.get(getMetamodelClass().getSingularAttribute(IConstants.T_END, Date.class)),
								from)));
			}
			Date to = template.getTo();
			if (to != null) {
				to = ModelUtil.safeSetDateTruncate(to);
				wheres.add(builder.lessThanOrEqualTo(
						root.get(getMetamodelClass().getSingularAttribute(IConstants.T_START, Date.class)), to));
			}
		}
	}

	protected <Y extends Serializable> void buildWhereEqual(SingularAttribute<? super T, Y> field, Y value) {
		if (value != null) {
			wheres.add(builder.equal(root.get(field), value));
		}
	}

	/**
	 * Build where equal match null.
	 *
	 * @param field
	 *            the field
	 * @param value
	 *            the value
	 */
	protected <Y extends Serializable> void buildWhereEqualMatchNull(SingularAttribute<? super T, Y> field, Y value) {
		if (value == null) {
			buildWhereIsNull(field);
		} else {
			buildWhereEqual(field, value);
		}
	}

	/**
	 * Build where equal use search mode.
	 *
	 * @param field
	 *            the field
	 * @param value
	 *            the value
	 */
	protected <Y extends Serializable> void buildWhereEqualUseSearchMode(SingularAttribute<? super T, Y> field,
			Y value) {
		if (ESearchMode.DEFAULT.equals(searchMode)) {
			buildWhereEqual(field, value);
		} else if (ESearchMode.POLICY.equals(searchMode)) {
			if (value == null) {
				buildWhereIsNull(field);
			} else {
				buildWhereEqualOrNull(field, value);
			}
		}
	}

	/**
	 * Build where not equal.
	 *
	 * @param field
	 *            the field
	 * @param value
	 *            the value
	 */
	protected <Y extends Serializable> void buildWhereNotEqual(SingularAttribute<? super T, Y> field, Y value) {
		if (value != null) {
			wheres.add(builder.not(builder.equal(root.get(field), value)));
		}
	}

	/**
	 * Build where equal or null.
	 *
	 * @param field
	 *            the field
	 * @param value
	 *            the value
	 */
	protected <Y extends Serializable> void buildWhereEqualOrNull(SingularAttribute<? super T, Y> field, Y value) {
		if (value != null) {
			wheres.add(builder.or(builder.isNull(root.get(field)), builder.equal(root.get(field), value)));
		}
	}

	/**
	 * Build where id equal.
	 *
	 * @param field
	 *            the field
	 * @param value
	 *            the value
	 */
	protected <Y, V extends Serializable> void buildWhereIdEqual(SingularAttribute<? super T, Y> id,
			SingularAttribute<? super Y, V> field, V value) {
		if (value != null) {
			wheres.add(builder.equal(root.get(id).get(field), value));
		}
	}

	/**
	 * Build where equal ignore case.
	 *
	 * @param field
	 *            the field
	 * @param value
	 *            the value
	 */
	protected void buildWhereEqualIgnoreCase(SingularAttribute<? super T, String> field, String value) {
		if (value != null) {
			wheres.add(builder.equal(builder.lower(root.get(field)), StringUtils.trim(StringUtils.lowerCase(value))));
		}
	}

	/**
	 * Build where like ignore case.
	 *
	 * @param field
	 *            the field
	 * @param value
	 *            the value
	 */
	protected void buildWhereLikeIgnoreCase(SingularAttribute<? super T, String> field, String value) {
		buildWhereLikeIgnoreCase(field, value, null);
	}

	/**
	 * Build where like ignore case.
	 *
	 * @param field
	 *            the field
	 * @param value
	 *            the value
	 * @param pattern
	 *            the pattern
	 */
	protected void buildWhereLikeIgnoreCase(SingularAttribute<? super T, String> field, String value, String pattern) {
		if (value != null) {
			if (pattern == null) {
				wheres.add(buildPredicateLikeIgnoreCase(field, value));
			} else {
				wheres.add(buildPredicateLikeIgnoreCasePattern(field, pattern));
			}
		}
	}

	protected Predicate buildPredicateLikeIgnoreCase(SingularAttribute<? super T, String> field, String value) {
		return builder.like(builder.lower(root.get(field)), forLikeIgnoreCase(value));
	}

	protected Predicate buildPredicateLikeIgnoreCasePattern(SingularAttribute<? super T, String> field,
			String pattern) {
		return builder.like(builder.lower(root.get(field)), StringUtils.trim(StringUtils.lowerCase(pattern)));
	}

	/**
	 * Build where like.
	 *
	 * @param field
	 *            the field
	 * @param value
	 *            the value
	 */
	protected void buildWhereLike(SingularAttribute<? super T, String> field, String value) {
		buildWhereLike(field, value, null);
	}

	/**
	 * Build where like.
	 *
	 * @param field
	 *            the field
	 * @param value
	 *            the value
	 * @param pattern
	 *            the pattern
	 */
	protected void buildWhereLike(SingularAttribute<? super T, String> field, String value, String pattern) {
		if (value != null) {
			if (pattern == null) {
				wheres.add(builder.like(root.get(field), forLike(value)));
			} else {
				wheres.add(builder.like(root.get(field), pattern));
			}
		}
	}

	/**
	 * Build where i 18 n.
	 *
	 * @param field
	 *            the field
	 * @param value
	 *            the value
	 */
	protected void buildWhereI18N(SetAttribute<? super T, Dictionary> field, String value) {
		if (value != null) {
			DictionaryTemplate dictionaryTemplate = new DictionaryTemplate();
			dictionaryTemplate.setValue(value);

			buildWhereTemplate(field, dictionaryTemplate);
		}
	}

	/**
	 * Build where in.
	 *
	 * @param field
	 *            the field
	 * @param value
	 *            the value
	 */
	protected <Y extends Serializable> void buildWhereIn(SingularAttribute<? super T, Y> field, Collection<Y> value) {
		QueryBase<?> queryBase;
		RelationalPathBase<?> object;


		queryBase.where(object.getMetadata(null).).

		if (ModelUtil.safeIsNotEmpty(value)) {
			wheres.add(root.get(field).in(value));
		}
	}

	/**
	 * Build where in use search mode.
	 *
	 * @param field
	 *            the field
	 * @param value
	 *            the value
	 */
	protected <Y extends Serializable> void buildWhereInUseSearchMode(SingularAttribute<? super T, Y> field,
			Collection<Y> value) {
		if (ESearchMode.DEFAULT.equals(searchMode)) {
			buildWhereIn(field, value);
		} else if (ESearchMode.POLICY.equals(searchMode)) {
			if (value == null || value.isEmpty()) {
				buildWhereIsNull(field);
			} else {
				buildWhereInOrNull(field, value);
			}
		}
	}

	/**
	 * Build where in or null.
	 *
	 * @param field
	 *            the field
	 * @param value
	 *            the value
	 */
	protected <Y extends Serializable> void buildWhereInOrNull(SingularAttribute<? super T, Y> field,
			Collection<Y> value) {
		if (ModelUtil.safeIsNotEmpty(value)) {
			wheres.add(builder.or(builder.isNull(root.get(field)), root.get(field).in(value)));
		}
	}

	/**
	 * Build where is not null.
	 *
	 * @param field
	 *            the field
	 */
	protected <Y extends Serializable> void buildWhereIsNotNull(SingularAttribute<? super T, Y> field) {
		wheres.add(builder.isNotNull(root.get(field)));
	}

	/**
	 * Build where not in.
	 *
	 * @param field
	 *            the field
	 * @param value
	 *            the value
	 */
	protected <Y extends Serializable> void buildWhereNotIn(SingularAttribute<? super T, Y> field,
			Collection<Y> value) {
		if (ModelUtil.safeIsNotEmpty(value)) {
			wheres.add(builder.not(root.get(field).in(value)));
		}
	}

	/**
	 * Build where is null.
	 *
	 * @param field
	 *            the field
	 */
	protected <Y extends Serializable> void buildWhereIsNull(SingularAttribute<? super T, Y> field) {
		wheres.add(builder.isNull(root.get(field)));
	}

	@SuppressWarnings("rawtypes")
	protected <Y extends Serializable> void buildWhereIsEmpty(SetAttribute<? super T, Y> field) {
		wheres.add(builder.isEmpty(root.get((SetAttribute) field)));
	}

	@SuppressWarnings("rawtypes")
	protected <Y extends Serializable> void buildWhereContains(SetAttribute<? super T, Y> field, Y value) {
		wheres.add(builder.isMember(value, root.get((SetAttribute) field)));
	}

	/**
	 * Build where less than or equal to.
	 *
	 * @param field
	 *            the field
	 * @param value
	 *            the value
	 */
	protected <Y extends Comparable<? super Y>> void buildWhereLessThanOrEqualTo(SingularAttribute<? super T, Y> field,
			Y value) {
		if (value != null) {
			wheres.add(builder.lessThanOrEqualTo(root.get(field), value));
		}
	}

	/**
	 * Build where greater than or equal to.
	 *
	 * @param field
	 *            the field
	 * @param value
	 *            the value
	 */
	protected <Y extends Comparable<? super Y>> void buildWhereGreaterThanOrEqualTo(
			SingularAttribute<? super T, Y> field, Y value) {
		if (value != null) {
			wheres.add(builder.greaterThanOrEqualTo(root.get(field), value));
		}
	}

	/**
	 * Build where greater than or equal to or null.
	 *
	 * @param field
	 *            the field
	 * @param value
	 *            the value
	 */
	protected <Y extends Comparable<? super Y>> void buildWhereGreaterThanOrEqualToOrNull(
			SingularAttribute<? super T, Y> field, Y value) {
		if (value != null) {
			wheres.add(
					builder.or(builder.isNull(root.get(field)), builder.greaterThanOrEqualTo(root.get(field), value)));
		}
	}

	protected <Y extends Serializable> void buildWhereTemplate(SingularAttribute<? super T, Y> joinField,
			AbstractTemplate<Y> template) {
		if (root instanceof Join) {
			buildWhereTemplate(joinField, ((Join<?, ?>) getRoot()).getJoinType(), template);
		} else {
			buildWhereTemplate(joinField, JoinType.INNER, template);
		}
	}

	protected <Y extends Serializable> void buildWhereTemplate(SetAttribute<? super T, Y> joinField,
			AbstractTemplate<Y> template) {
		if (root instanceof Join) {
			buildWhereTemplate(joinField, ((Join<?, ?>) getRoot()).getJoinType(), template);
		} else {
			buildWhereTemplate(joinField, JoinType.INNER, template);
		}
	}

	protected <Y extends Serializable> void buildWhereTemplate(SingularAttribute<? super T, Y> joinField,
			JoinType joinType, AbstractTemplate<Y> template) {
		if (template != null && template.initialized()) {
			template.setRoot(root.join(joinField, joinType));
			template.setWheres(wheres);
			template.setBuilder(builder);
			template.setNested(true);
			template.setEntityManager(getEntityManager());

			template.buildWheres();
		}
	}

	protected <Y extends Serializable> void buildWhereTemplate(SetAttribute<? super T, Y> joinField, JoinType joinType,
			AbstractTemplate<Y> template) {
		if (template != null && template.initialized()) {
			template.setRoot(root.join(joinField, joinType));
			template.setWheres(wheres);
			template.setBuilder(builder);
			template.setNested(true);
			template.setEntityManager(getEntityManager());

			template.buildWheres();
		}
	}

	protected <Y> void buildWhereExists(SingularAttribute<Y, T> joinEntity, SingularAttribute<T, Y> joinField,
			Boolean exists) {
		if (exists == null) {
			return;
		}

		Class<Y> joinClass = joinEntity.getDeclaringType().getJavaType();
		Subquery<Y> subquery = criteria.subquery(joinClass);
		Root<Y> subroot = subquery.from(joinClass);
		subquery.where(builder.equal(root.get(joinField), subroot.get(joinEntity).get(joinField)));
		subquery.select(subroot);

		if (exists) {
			wheres.add(builder.exists(subquery));
		} else {
			wheres.add(builder.not(builder.exists(subquery)));
		}
	}

	/**
	 * For like ignore case.
	 *
	 * @param s
	 *            the s
	 * @return the string
	 */
	protected String forLikeIgnoreCase(String s) {
		return StringUtils.isBlank(s) ? null : '%' + StringUtils.trim(StringUtils.lowerCase(s)) + '%';
	}

	/**
	 * For like.
	 *
	 * @param s
	 *            the s
	 * @return the string
	 */
	protected String forLike(String s) {
		return StringUtils.isBlank(s) ? null : '%' + s + '%';
	}

	@Override
	public T build(Class<T> buildClass) {
		T builded = null;
		try {
			builded = buildClass.newInstance();

			PropertyUtils.copyProperties(builded, this);
		} catch (InstantiationException | IllegalAccessException | InvocationTargetException
				| NoSuchMethodException e) {
			e.printStackTrace();
		}

		return builded;
	}

	@Override
	public int getMaxResults() {
		return maxResults;
	}

	@Override
	public void setMaxResults(int maxResults) {
		this.maxResults = maxResults;
	}

	/**
	 * Gets first result.
	 *
	 * @return the first result
	 */
	public int getFirstResult() {
		return firstResult;
	}

	/**
	 * Sets first result.
	 *
	 * @param firstResult
	 *            the first result
	 */
	public void setFirstResult(int firstResult) {
		this.firstResult = firstResult;
	}

	public boolean isNested() {
		return nested;
	}

	public void setNested(boolean nested) {
		this.nested = nested;
	}

	@Override
	public Distinct getDistinct() {
		return distinct;
	}

	public void setDistinct(Distinct distinct) {
		this.distinct = distinct;
	}

	/**
	 * Check where in.
	 *
	 * @param object
	 *            the object
	 * @param field
	 *            the field
	 * @param values
	 *            the values
	 * @return the boolean
	 */
	protected <Y extends Serializable> boolean checkWhereIn(T object, SingularAttribute<? super T, Y> field,
			Collection<Y> values) {
		if (ModelUtil.safeIsNotEmpty(values)) {
			Y value = getValue(object, field);

			return values.contains(value);
		}

		return true;
	}

	/**
	 * Check default wheres.
	 *
	 * @param object
	 *            the object
	 * @return the boolean
	 */
	protected boolean checkDefaultWheres(T object) {
		return checkValidDate(object) && checkFromDate(object) && checkStatus(object);
	}

	protected boolean checkStatus(T object) {
		if (this instanceof IStatusTemplate) {
			IStatusTemplate template = (IStatusTemplate) this;

			return checkWhereEqual(object, getMetamodelClass().getSingularAttribute(IConstants.STATUS, EStatus.class),
					template.getStatus());
		}

		return true;
	}

	/**
	 * Check valid date.
	 *
	 * @param object
	 *            the object
	 * @return the boolean
	 */
	protected boolean checkValidDate(T object) {
		if (this instanceof IValidDateTemplate) {
			IValidDateTemplate template = (IValidDateTemplate) this;

			if (template.getValidDate() != null) {
				Date validDate = DateUtils.truncate(template.getValidDate(), Calendar.DAY_OF_MONTH);

				Date tStart = ModelUtil.safeSetDateTruncate(
						getValue(object, getMetamodelClass().getSingularAttribute(IConstants.T_START, Date.class)));
				if (tStart.after(validDate)) {
					return false;
				}

				Date tEnd = ModelUtil.safeSetDateTruncate(
						getValue(object, getMetamodelClass().getSingularAttribute(IConstants.T_END, Date.class)));
				if (tEnd != null && tEnd.before(validDate)) {
					return false;
				}
			}
		}

		return true;
	}

	/**
	 * Check from date.
	 *
	 * @param object
	 *            the object
	 * @return the boolean
	 */
	protected boolean checkFromDate(T object) {
		if (this instanceof IFromToDateTemplate) {
			IFromToDateTemplate template = (IFromToDateTemplate) this;

			if (template.getFrom() != null) {
				Date tEnd = ModelUtil.safeSetDateTruncate(
						getValue(object, getMetamodelClass().getSingularAttribute(IConstants.T_END, Date.class)));

				if (tEnd != null && tEnd.before(template.getFrom())) {
					return false;
				}
			}

			if (template.getTo() != null) {
				Date tStart = ModelUtil.safeSetDateTruncate(
						getValue(object, getMetamodelClass().getSingularAttribute(IConstants.T_START, Date.class)));

				if (tStart.after(template.getTo())) {
					return false;
				}
			}
		}

		return true;
	}

	/**
	 * Check where equal.
	 *
	 * @param object
	 *            the object
	 * @param field
	 *            the field
	 * @param value
	 *            the value
	 * @return the boolean
	 */
	protected <Y extends Serializable> boolean checkWhereEqual(T object, SingularAttribute<? super T, Y> field,
			Y value) {
		if (value != null) {
			Y fieldValue = getValue(object, field);
			return fieldValue != null && fieldValue.equals(value);
		}

		return true;
	}

	/**
	 * Gets value.
	 *
	 * @param object
	 *            the object
	 * @param field
	 *            the field
	 * @return the value
	 */
	protected <Y extends Serializable> Y getValue(T object, SingularAttribute<? super T, Y> field) {
		PropertyDescriptor propertyDescriptor;
		try {
			propertyDescriptor = PropertyUtils.getPropertyDescriptor(object, field.getName());

			return (Y) propertyDescriptor.getReadMethod().invoke(object, (Object[]) null);
		} catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public AbstractTemplate<T> clone() {
		try {
			return (AbstractTemplate<T>) super.clone();
		} catch (CloneNotSupportedException e) {
			return null;
		}
	}

	protected void buildWhereOperatorGroupPermission() {
		if (this instanceof IOperatorGroupPermission) {
			Subject subject = Subject.getSubject(AccessController.getContext());

			if (subject != null) {
				for (Object credential : subject.getPrivateCredentials()) {
					if (credential instanceof EnhancedEnum<?, ?>) {
						String match = '"' + ((EnhancedEnum<?, String>) credential).getKey() + '"';

						wheres.add(builder.equal(
								builder.locate(builder.coalesce(root.get(getMetamodelClass().getSingularAttribute(
										((IOperatorGroupPermission) this).getOperatorGroupPermissionField(),
										String.class)), " "), match),
								0));
					}
				}
			}
		}
	}
}
