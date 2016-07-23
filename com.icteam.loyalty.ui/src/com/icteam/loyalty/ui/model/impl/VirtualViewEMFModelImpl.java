/**
 */
package com.icteam.loyalty.ui.model.impl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.commons.lang.ObjectUtils;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectEList;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.ecp.view.spi.model.VFeaturePathDomainModelReference;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

import com.icteam.loyalty.api.AppException;
import com.icteam.loyalty.model.EMFModel;
import com.icteam.loyalty.model.impl.EMFModelImpl;
import com.icteam.loyalty.model.interfaces.Action;
import com.icteam.loyalty.model.interfaces.ISearchProvider;
import com.icteam.loyalty.model.template.AbstractEMFTemplate;
import com.icteam.loyalty.model.util.ModelUtil;
import com.icteam.loyalty.ui.interfaces.IBaseClassProvider;
import com.icteam.loyalty.ui.interfaces.UIInterfacesPackage;
import com.icteam.loyalty.ui.interfaces.impl.EStructuralFeatureToIntMapImpl;
import com.icteam.loyalty.ui.model.DefaultEditorEMFModel;
import com.icteam.loyalty.ui.model.UIModelPackage;
import com.icteam.loyalty.ui.model.VirtualViewEMFModel;
import com.icteam.loyalty.ui.util.UIUtils;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Virtual EMF View Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.icteam.loyalty.ui.model.impl.VirtualViewEMFModelImpl#getBaseClass <em>Base Class</em>}</li>
 *   <li>{@link com.icteam.loyalty.ui.model.impl.VirtualViewEMFModelImpl#getTemplate <em>Template</em>}</li>
 *   <li>{@link com.icteam.loyalty.ui.model.impl.VirtualViewEMFModelImpl#getFilter <em>Filter</em>}</li>
 *   <li>{@link com.icteam.loyalty.ui.model.impl.VirtualViewEMFModelImpl#getList <em>List</em>}</li>
 *   <li>{@link com.icteam.loyalty.ui.model.impl.VirtualViewEMFModelImpl#getSearchProvider <em>Search Provider</em>}</li>
 *   <li>{@link com.icteam.loyalty.ui.model.impl.VirtualViewEMFModelImpl#getSelectedList <em>Selected List</em>}</li>
 *   <li>{@link com.icteam.loyalty.ui.model.impl.VirtualViewEMFModelImpl#getOpenEditorAction <em>Open Editor Action</em>}</li>
 *   <li>{@link com.icteam.loyalty.ui.model.impl.VirtualViewEMFModelImpl#getFilterColumnsAction <em>Filter Columns Action</em>}</li>
 *   <li>{@link com.icteam.loyalty.ui.model.impl.VirtualViewEMFModelImpl#getAdvancedFilterAction <em>Advanced Filter Action</em>}</li>
 *   <li>{@link com.icteam.loyalty.ui.model.impl.VirtualViewEMFModelImpl#getRefreshAction <em>Refresh Action</em>}</li>
 *   <li>{@link com.icteam.loyalty.ui.model.impl.VirtualViewEMFModelImpl#getSelectColumnAction <em>Select Column Action</em>}</li>
 *   <li>{@link com.icteam.loyalty.ui.model.impl.VirtualViewEMFModelImpl#getAddAction <em>Add Action</em>}</li>
 *   <li>{@link com.icteam.loyalty.ui.model.impl.VirtualViewEMFModelImpl#getRemoveAction <em>Remove Action</em>}</li>
 *   <li>{@link com.icteam.loyalty.ui.model.impl.VirtualViewEMFModelImpl#getColumnWidths <em>Column Widths</em>}</li>
 *   <li>{@link com.icteam.loyalty.ui.model.impl.VirtualViewEMFModelImpl#getItemCount <em>Item Count</em>}</li>
 *   <li>{@link com.icteam.loyalty.ui.model.impl.VirtualViewEMFModelImpl#getViewID <em>View ID</em>}</li>
 *   <li>{@link com.icteam.loyalty.ui.model.impl.VirtualViewEMFModelImpl#getModelClass <em>Model Class</em>}</li>
 *   <li>{@link com.icteam.loyalty.ui.model.impl.VirtualViewEMFModelImpl#getTemplateClass <em>Template Class</em>}</li>
 *   <li>{@link com.icteam.loyalty.ui.model.impl.VirtualViewEMFModelImpl#getColumnDomainModelReferences <em>Column Domain Model References</em>}</li>
 *   <li>{@link com.icteam.loyalty.ui.model.impl.VirtualViewEMFModelImpl#getEditorModelEClass <em>Editor Model EClass</em>}</li>
 * </ul>
 *
 * @generated
 */
public class VirtualViewEMFModelImpl<T extends AbstractEMFTemplate< ? >, D extends EMFModel> extends EMFModelImpl implements VirtualViewEMFModel<T, D> {
    /**
     * The cached value of the '{@link #getTemplate() <em>Template</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTemplate()
     * @generated
     * @ordered
     */
    protected T template;

    /**
     * The default value of the '{@link #getFilter() <em>Filter</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getFilter()
     * @generated
     * @ordered
     */
    protected static final String FILTER_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getFilter() <em>Filter</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getFilter()
     * @generated
     * @ordered
     */
    protected String filter = FILTER_EDEFAULT;

    /**
     * The cached value of the '{@link #getList() <em>List</em>}' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getList()
     * @generated
     * @ordered
     */
    protected EList<D> list;

    /**
     * The default value of the '{@link #getSearchProvider() <em>Search Provider</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSearchProvider()
     * @generated
     * @ordered
     */
    protected static final ISearchProvider SEARCH_PROVIDER_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getSearchProvider() <em>Search Provider</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSearchProvider()
     * @generated
     * @ordered
     */
    protected ISearchProvider searchProvider = SEARCH_PROVIDER_EDEFAULT;

    /**
     * The cached value of the '{@link #getSelectedList() <em>Selected List</em>}' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSelectedList()
     * @generated
     * @ordered
     */
    protected EList<D> selectedList;

    /**
     * The cached value of the '{@link #getColumnWidths() <em>Column Widths</em>}' map.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getColumnWidths()
     * @generated
     * @ordered
     */
    protected EMap<EStructuralFeature, Integer> columnWidths;

    /**
     * The default value of the '{@link #getItemCount() <em>Item Count</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getItemCount()
     * @generated
     * @ordered
     */
    protected static final int ITEM_COUNT_EDEFAULT = -1;

    /**
     * The cached value of the '{@link #getItemCount() <em>Item Count</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getItemCount()
     * @generated
     * @ordered
     */
    protected int itemCount = ITEM_COUNT_EDEFAULT;

    /**
     * The default value of the '{@link #getViewID() <em>View ID</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getViewID()
     * @generated
     * @ordered
     */
    protected static final String VIEW_ID_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getModelClass() <em>Model Class</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getModelClass()
     * @generated
     * @ordered
     */
    protected Class<D> modelClass;

    /**
     * The cached value of the '{@link #getTemplateClass() <em>Template Class</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTemplateClass()
     * @generated
     * @ordered
     */
    protected Class<T> templateClass;

    /**
     * The cached value of the '{@link #getColumnDomainModelReferences() <em>Column Domain Model References</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getColumnDomainModelReferences()
     * @generated
     * @ordered
     */
    protected Map<EStructuralFeature, VFeaturePathDomainModelReference> columnDomainModelReferences;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected VirtualViewEMFModelImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return UIModelPackage.Literals.VIRTUAL_VIEW_EMF_MODEL;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    @Override
    public Class<EObject> getBaseClass() {
        return (Class<EObject>) getModelClass();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public ISearchProvider getSearchProvider() {
        return searchProvider;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setSearchProvider(ISearchProvider newSearchProvider) {
        ISearchProvider oldSearchProvider = searchProvider;
        searchProvider = newSearchProvider;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, UIModelPackage.VIRTUAL_VIEW_EMF_MODEL__SEARCH_PROVIDER, oldSearchProvider, searchProvider));
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EList<D> getSelectedList() {
        if (selectedList == null) {
            selectedList = new EObjectEList<D>(EMFModel.class, this, UIModelPackage.VIRTUAL_VIEW_EMF_MODEL__SELECTED_LIST);
        }
        return selectedList;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    @Override
    public Action getOpenEditorAction() {
        return ModelUtil.valueOf(this, Action.class, UIInterfacesPackage.Literals.UI_ACTION__VIEW_OPEN_EDITOR.getName());
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    @Override
    public EMap<EStructuralFeature, Integer> getColumnWidths() {
        if (columnWidths == null) {
            columnWidths = new EcoreEMap<EStructuralFeature, Integer>(UIInterfacesPackage.Literals.ESTRUCTURAL_FEATURE_TO_INT_MAP, EStructuralFeatureToIntMapImpl.class, this,
                    UIModelPackage.VIRTUAL_VIEW_EMF_MODEL__COLUMN_WIDTHS);

            for (EStructuralFeature structuralFeature : getColumnDomainModelReferences().keySet()) {
                columnWidths.put(structuralFeature, null);
            }
        }

        return columnWidths;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    @Override
    public int getItemCount() {
        if (!eIsSet(UIModelPackage.VIRTUAL_VIEW_EMF_MODEL__ITEM_COUNT)) {
            itemCount = getSearchProvider().count(getTemplate());
        }

        return itemCount;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setItemCount(int newItemCount) {
        int oldItemCount = itemCount;
        itemCount = newItemCount;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, UIModelPackage.VIRTUAL_VIEW_EMF_MODEL__ITEM_COUNT, oldItemCount, itemCount));
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    @Override
    public String getViewID() {
        throw new UnsupportedOperationException("must override");
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    @Override
    public Class<D> getModelClass() {
        if (modelClass == null) {
            modelClass = (Class<D>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
        }

        return modelClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    @Override
    public Class<T> getTemplateClass() {
        if (templateClass == null) {
            templateClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        }

        return templateClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    @Override
    public Map<EStructuralFeature, VFeaturePathDomainModelReference> getColumnDomainModelReferences() {
        if (columnDomainModelReferences == null) {
            EList<VFeaturePathDomainModelReference> domainModelReferences = UIUtils.getColumnDomainModelReferences(ModelUtil.getEClass(getBaseClass()));

            columnDomainModelReferences = new LinkedHashMap<>();

            for (VFeaturePathDomainModelReference domainModelReference : domainModelReferences) {
                columnDomainModelReferences.put(domainModelReference.getDomainModelEFeature(), domainModelReference);
            }
        }

        return columnDomainModelReferences;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setColumnDomainModelReferences(Map<EStructuralFeature, VFeaturePathDomainModelReference> newColumnDomainModelReferences) {
        Map<EStructuralFeature, VFeaturePathDomainModelReference> oldColumnDomainModelReferences = columnDomainModelReferences;
        columnDomainModelReferences = newColumnDomainModelReferences;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, UIModelPackage.VIRTUAL_VIEW_EMF_MODEL__COLUMN_DOMAIN_MODEL_REFERENCES, oldColumnDomainModelReferences,
                    columnDomainModelReferences));
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    @Override
    public EClass getEditorModelEClass() {
        throw new UnsupportedOperationException("must override");
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public T buildTemplate() {
        EClass dtoEClass = ModelUtil.getEClass(getTemplateClass());

        EFactory factory = dtoEClass.getEPackage().getEFactoryInstance();
        return (T) factory.create(dtoEClass);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    @Override
    public Action getRefreshAction() {
        return ModelUtil.valueOf(this, Action.class, UIInterfacesPackage.Literals.UI_ACTION__VIEW_REFRESH.getName());
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    @Override
    public Action getSelectColumnAction() {
        return ModelUtil.valueOf(this, Action.class, UIInterfacesPackage.Literals.UI_ACTION__VIEW_SELECT_COLUMN.getName());
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    @Override
    public Action getAddAction() {
        return ModelUtil.valueOf(this, Action.class, UIInterfacesPackage.Literals.UI_ACTION__VIEW_ADD.getName());
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    @Override
    public Action getRemoveAction() {
        return ModelUtil.valueOf(this, Action.class, UIInterfacesPackage.Literals.UI_ACTION__VIEW_REMOVE.getName());
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    @Override
    public Action getFilterColumnsAction() {
        return ModelUtil.valueOf(this, Action.class, UIInterfacesPackage.Literals.UI_ACTION__VIEW_FILTER_COLUMNS.getName());
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    @Override
    public Action getAdvancedFilterAction() {
        return ModelUtil.valueOf(this, Action.class, UIInterfacesPackage.Literals.UI_ACTION__VIEW_ADVANCED_FILTER.getName());
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    @Override
    public T getTemplate() {
        if (template == null) {
            template = buildTemplate();
        }

        return template;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String getFilter() {
        return filter;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    @Override
    public void setFilter(String newFilter) {
        if (!ObjectUtils.equals(newFilter, filter)) {
            String oldFilter = filter;

            getTemplate().setRawFilter(newFilter);

            filter = newFilter;

            if (eNotificationRequired()) {
                eNotify(new ENotificationImpl(this, Notification.SET, UIModelPackage.VIRTUAL_VIEW_EMF_MODEL__FILTER, oldFilter, filter));
            }

            if (!reload(false)) {
                setFilter(oldFilter);
            }
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    @Override
    public EList<D> getList() {
        if (list == null) {
            list = new EObjectEList<D>(EMFModel.class, this, UIModelPackage.VIRTUAL_VIEW_EMF_MODEL__LIST) {

                private static final long serialVersionUID = 5332383351776924044L;

                // @see https://bugs.eclipse.org/bugs/show_bug.cgi?id=89325
                @Override
                protected boolean isUnique() {
                    return false;
                }
            };
        }
        return list;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    @Override
    public void openEditor() {
        EList<D> selList = ECollections.newBasicEList(getSelectedList());

        for (D selectedItem : selList) {
            if (selectedItem.hasEditor()) {
                try {
                    EClass editorModelClass = getEditorModelEClass();

                    DefaultEditorEMFModel<D> editorEMFModel = (DefaultEditorEMFModel<D>) EcoreUtil.create(editorModelClass);
                    editorEMFModel.init(selectedItem, this);

                    PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().openEditor(editorEMFModel, editorEMFModel.getEditorID());
                } catch (PartInitException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setAdvancedSearchTemplate(final T template) {
        T oldTemplate = this.template;

        this.template = template;

        if (!reload(true)) {
            setAdvancedSearchTemplate(oldTemplate);
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean reload(final boolean closeEditors) {
        try {
            eUnset(UIModelPackage.VIRTUAL_VIEW_EMF_MODEL__LIST);
            eUnset(UIModelPackage.VIRTUAL_VIEW_EMF_MODEL__SELECTED_LIST);
            eUnset(UIModelPackage.VIRTUAL_VIEW_EMF_MODEL__ITEM_COUNT);

            if (closeEditors) {
                closeEditors();
            }
        } catch (AppException e) {
            MessageDialog.openError(null, com.icteam.loyalty.api.Messages.get().load_error, e.getLocalizedMessage());
            return false;
        }

        return true;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setFilterFeatures(final EList<EStructuralFeature> filterFeatures, final boolean reload) {
        EList<EStructuralFeature> oldFilterFeatures = getTemplate().getDynamicFilterFeatures();

        getTemplate().setDynamicFilterFeatures(filterFeatures);

        if (reload) {
            if (!reload(true)) {
                setFilterFeatures(oldFilterFeatures, reload);
            }
        }

    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void closeEditors() {
        IEditorReference[] editorReferences = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getEditorReferences();
        java.util.List<IEditorReference> list = new ArrayList<>();

        for (IEditorReference editorReference : editorReferences) {
            try {
                if (getEditorModelEClass().isInstance(editorReference.getEditorInput())) {
                    list.add(editorReference);
                }
            } catch (PartInitException e) {
                // nothing to do
            }
        }

        PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().closeEditors(list.toArray(new IEditorReference[] {}), true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    @Override
    public IEditorPart findEditor(D model) {
        EClass editorModelClass = getEditorModelEClass();

        DefaultEditorEMFModel<D> editorEMFModel = (DefaultEditorEMFModel<D>) EcoreUtil.create(editorModelClass);
        editorEMFModel.init(model);

        IWorkbenchPage page = UIUtils.getActivePage();

        if (page != null) {
            return page.findEditor(editorEMFModel);
        }

        return null;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case UIModelPackage.VIRTUAL_VIEW_EMF_MODEL__COLUMN_WIDTHS:
                return ((InternalEList< ? >) getColumnWidths()).basicRemove(otherEnd, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case UIModelPackage.VIRTUAL_VIEW_EMF_MODEL__BASE_CLASS:
                return getBaseClass();
            case UIModelPackage.VIRTUAL_VIEW_EMF_MODEL__TEMPLATE:
                return getTemplate();
            case UIModelPackage.VIRTUAL_VIEW_EMF_MODEL__FILTER:
                return getFilter();
            case UIModelPackage.VIRTUAL_VIEW_EMF_MODEL__LIST:
                return getList();
            case UIModelPackage.VIRTUAL_VIEW_EMF_MODEL__SEARCH_PROVIDER:
                return getSearchProvider();
            case UIModelPackage.VIRTUAL_VIEW_EMF_MODEL__SELECTED_LIST:
                return getSelectedList();
            case UIModelPackage.VIRTUAL_VIEW_EMF_MODEL__OPEN_EDITOR_ACTION:
                return getOpenEditorAction();
            case UIModelPackage.VIRTUAL_VIEW_EMF_MODEL__FILTER_COLUMNS_ACTION:
                return getFilterColumnsAction();
            case UIModelPackage.VIRTUAL_VIEW_EMF_MODEL__ADVANCED_FILTER_ACTION:
                return getAdvancedFilterAction();
            case UIModelPackage.VIRTUAL_VIEW_EMF_MODEL__REFRESH_ACTION:
                return getRefreshAction();
            case UIModelPackage.VIRTUAL_VIEW_EMF_MODEL__SELECT_COLUMN_ACTION:
                return getSelectColumnAction();
            case UIModelPackage.VIRTUAL_VIEW_EMF_MODEL__ADD_ACTION:
                return getAddAction();
            case UIModelPackage.VIRTUAL_VIEW_EMF_MODEL__REMOVE_ACTION:
                return getRemoveAction();
            case UIModelPackage.VIRTUAL_VIEW_EMF_MODEL__COLUMN_WIDTHS:
                if (coreType) {
                    return getColumnWidths();
                } else {
                    return getColumnWidths().map();
                }
            case UIModelPackage.VIRTUAL_VIEW_EMF_MODEL__ITEM_COUNT:
                return getItemCount();
            case UIModelPackage.VIRTUAL_VIEW_EMF_MODEL__VIEW_ID:
                return getViewID();
            case UIModelPackage.VIRTUAL_VIEW_EMF_MODEL__MODEL_CLASS:
                return getModelClass();
            case UIModelPackage.VIRTUAL_VIEW_EMF_MODEL__TEMPLATE_CLASS:
                return getTemplateClass();
            case UIModelPackage.VIRTUAL_VIEW_EMF_MODEL__COLUMN_DOMAIN_MODEL_REFERENCES:
                return getColumnDomainModelReferences();
            case UIModelPackage.VIRTUAL_VIEW_EMF_MODEL__EDITOR_MODEL_ECLASS:
                return getEditorModelEClass();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case UIModelPackage.VIRTUAL_VIEW_EMF_MODEL__FILTER:
                setFilter((String) newValue);
                return;
            case UIModelPackage.VIRTUAL_VIEW_EMF_MODEL__LIST:
                getList().clear();
                getList().addAll((Collection< ? extends D>) newValue);
                return;
            case UIModelPackage.VIRTUAL_VIEW_EMF_MODEL__SEARCH_PROVIDER:
                setSearchProvider((ISearchProvider) newValue);
                return;
            case UIModelPackage.VIRTUAL_VIEW_EMF_MODEL__SELECTED_LIST:
                getSelectedList().clear();
                getSelectedList().addAll((Collection< ? extends D>) newValue);
                return;
            case UIModelPackage.VIRTUAL_VIEW_EMF_MODEL__COLUMN_WIDTHS:
                ((EStructuralFeature.Setting) getColumnWidths()).set(newValue);
                return;
            case UIModelPackage.VIRTUAL_VIEW_EMF_MODEL__ITEM_COUNT:
                setItemCount((Integer) newValue);
                return;
            case UIModelPackage.VIRTUAL_VIEW_EMF_MODEL__COLUMN_DOMAIN_MODEL_REFERENCES:
                setColumnDomainModelReferences((Map<EStructuralFeature, VFeaturePathDomainModelReference>) newValue);
                return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eUnset(int featureID) {
        switch (featureID) {
            case UIModelPackage.VIRTUAL_VIEW_EMF_MODEL__FILTER:
                setFilter(FILTER_EDEFAULT);
                return;
            case UIModelPackage.VIRTUAL_VIEW_EMF_MODEL__LIST:
                getList().clear();
                return;
            case UIModelPackage.VIRTUAL_VIEW_EMF_MODEL__SEARCH_PROVIDER:
                setSearchProvider(SEARCH_PROVIDER_EDEFAULT);
                return;
            case UIModelPackage.VIRTUAL_VIEW_EMF_MODEL__SELECTED_LIST:
                getSelectedList().clear();
                return;
            case UIModelPackage.VIRTUAL_VIEW_EMF_MODEL__COLUMN_WIDTHS:
                getColumnWidths().clear();
                return;
            case UIModelPackage.VIRTUAL_VIEW_EMF_MODEL__ITEM_COUNT:
                setItemCount(ITEM_COUNT_EDEFAULT);
                return;
            case UIModelPackage.VIRTUAL_VIEW_EMF_MODEL__COLUMN_DOMAIN_MODEL_REFERENCES:
                setColumnDomainModelReferences((Map<EStructuralFeature, VFeaturePathDomainModelReference>) null);
                return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean eIsSet(int featureID) {
        switch (featureID) {
            case UIModelPackage.VIRTUAL_VIEW_EMF_MODEL__BASE_CLASS:
                return getBaseClass() != null;
            case UIModelPackage.VIRTUAL_VIEW_EMF_MODEL__TEMPLATE:
                return template != null;
            case UIModelPackage.VIRTUAL_VIEW_EMF_MODEL__FILTER:
                return FILTER_EDEFAULT == null ? filter != null : !FILTER_EDEFAULT.equals(filter);
            case UIModelPackage.VIRTUAL_VIEW_EMF_MODEL__LIST:
                return list != null && !list.isEmpty();
            case UIModelPackage.VIRTUAL_VIEW_EMF_MODEL__SEARCH_PROVIDER:
                return SEARCH_PROVIDER_EDEFAULT == null ? searchProvider != null : !SEARCH_PROVIDER_EDEFAULT.equals(searchProvider);
            case UIModelPackage.VIRTUAL_VIEW_EMF_MODEL__SELECTED_LIST:
                return selectedList != null && !selectedList.isEmpty();
            case UIModelPackage.VIRTUAL_VIEW_EMF_MODEL__OPEN_EDITOR_ACTION:
                return getOpenEditorAction() != null;
            case UIModelPackage.VIRTUAL_VIEW_EMF_MODEL__FILTER_COLUMNS_ACTION:
                return getFilterColumnsAction() != null;
            case UIModelPackage.VIRTUAL_VIEW_EMF_MODEL__ADVANCED_FILTER_ACTION:
                return getAdvancedFilterAction() != null;
            case UIModelPackage.VIRTUAL_VIEW_EMF_MODEL__REFRESH_ACTION:
                return getRefreshAction() != null;
            case UIModelPackage.VIRTUAL_VIEW_EMF_MODEL__SELECT_COLUMN_ACTION:
                return getSelectColumnAction() != null;
            case UIModelPackage.VIRTUAL_VIEW_EMF_MODEL__ADD_ACTION:
                return getAddAction() != null;
            case UIModelPackage.VIRTUAL_VIEW_EMF_MODEL__REMOVE_ACTION:
                return getRemoveAction() != null;
            case UIModelPackage.VIRTUAL_VIEW_EMF_MODEL__COLUMN_WIDTHS:
                return columnWidths != null && !columnWidths.isEmpty();
            case UIModelPackage.VIRTUAL_VIEW_EMF_MODEL__ITEM_COUNT:
                return itemCount != ITEM_COUNT_EDEFAULT;
            case UIModelPackage.VIRTUAL_VIEW_EMF_MODEL__VIEW_ID:
                return VIEW_ID_EDEFAULT == null ? getViewID() != null : !VIEW_ID_EDEFAULT.equals(getViewID());
            case UIModelPackage.VIRTUAL_VIEW_EMF_MODEL__MODEL_CLASS:
                return modelClass != null;
            case UIModelPackage.VIRTUAL_VIEW_EMF_MODEL__TEMPLATE_CLASS:
                return templateClass != null;
            case UIModelPackage.VIRTUAL_VIEW_EMF_MODEL__COLUMN_DOMAIN_MODEL_REFERENCES:
                return columnDomainModelReferences != null;
            case UIModelPackage.VIRTUAL_VIEW_EMF_MODEL__EDITOR_MODEL_ECLASS:
                return getEditorModelEClass() != null;
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public int eBaseStructuralFeatureID(int derivedFeatureID, Class< ? > baseClass) {
        if (baseClass == IBaseClassProvider.class) {
            switch (derivedFeatureID) {
                case UIModelPackage.VIRTUAL_VIEW_EMF_MODEL__BASE_CLASS:
                    return UIInterfacesPackage.IBASE_CLASS_PROVIDER__BASE_CLASS;
                default:
                    return -1;
            }
        }
        return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public int eDerivedStructuralFeatureID(int baseFeatureID, Class< ? > baseClass) {
        if (baseClass == IBaseClassProvider.class) {
            switch (baseFeatureID) {
                case UIInterfacesPackage.IBASE_CLASS_PROVIDER__BASE_CLASS:
                    return UIModelPackage.VIRTUAL_VIEW_EMF_MODEL__BASE_CLASS;
                default:
                    return -1;
            }
        }
        return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    @SuppressWarnings("unchecked")
    public Object eInvoke(int operationID, EList< ? > arguments) throws InvocationTargetException {
        switch (operationID) {
            case UIModelPackage.VIRTUAL_VIEW_EMF_MODEL___BUILD_TEMPLATE:
                return buildTemplate();
            case UIModelPackage.VIRTUAL_VIEW_EMF_MODEL___OPEN_EDITOR:
                openEditor();
                return null;
            case UIModelPackage.VIRTUAL_VIEW_EMF_MODEL___SET_ADVANCED_SEARCH_TEMPLATE__ABSTRACTEMFTEMPLATE:
                setAdvancedSearchTemplate((T) arguments.get(0));
                return null;
            case UIModelPackage.VIRTUAL_VIEW_EMF_MODEL___RELOAD__BOOLEAN:
                return reload((Boolean) arguments.get(0));
            case UIModelPackage.VIRTUAL_VIEW_EMF_MODEL___SET_FILTER_FEATURES__ELIST_BOOLEAN:
                setFilterFeatures((EList<EStructuralFeature>) arguments.get(0), (Boolean) arguments.get(1));
                return null;
            case UIModelPackage.VIRTUAL_VIEW_EMF_MODEL___CLOSE_EDITORS:
                closeEditors();
                return null;
            case UIModelPackage.VIRTUAL_VIEW_EMF_MODEL___FIND_EDITOR__EMFMODEL:
                return findEditor((D) arguments.get(0));
        }
        return super.eInvoke(operationID, arguments);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String toString() {
        if (eIsProxy()) {
            return super.toString();
        }

        StringBuffer result = new StringBuffer(super.toString());
        result.append(" (filter: ");
        result.append(filter);
        result.append(", searchProvider: ");
        result.append(searchProvider);
        result.append(", itemCount: ");
        result.append(itemCount);
        result.append(", modelClass: ");
        result.append(modelClass);
        result.append(", templateClass: ");
        result.append(templateClass);
        result.append(", columnDomainModelReferences: ");
        result.append(columnDomainModelReferences);
        result.append(')');
        return result.toString();
    }
} //VirtualViewEMFModelImpl
