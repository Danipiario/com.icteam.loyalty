/**
 */
package com.icteam.loyalty.ui.model;

import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecp.view.spi.model.VFeaturePathDomainModelReference;
import org.eclipse.ui.IEditorPart;

import com.icteam.loyalty.model.EMFModel;
import com.icteam.loyalty.model.interfaces.Action;
import com.icteam.loyalty.model.interfaces.ISearchProvider;
import com.icteam.loyalty.model.template.AbstractEMFTemplate;
import com.icteam.loyalty.ui.interfaces.IBaseClassProvider;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Virtual EMF View Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.icteam.loyalty.ui.model.VirtualViewEMFModel#getTemplate <em>Template</em>}</li>
 *   <li>{@link com.icteam.loyalty.ui.model.VirtualViewEMFModel#getFilter <em>Filter</em>}</li>
 *   <li>{@link com.icteam.loyalty.ui.model.VirtualViewEMFModel#getList <em>List</em>}</li>
 *   <li>{@link com.icteam.loyalty.ui.model.VirtualViewEMFModel#getSearchProvider <em>Search Provider</em>}</li>
 *   <li>{@link com.icteam.loyalty.ui.model.VirtualViewEMFModel#getSelectedList <em>Selected List</em>}</li>
 *   <li>{@link com.icteam.loyalty.ui.model.VirtualViewEMFModel#getOpenEditorAction <em>Open Editor Action</em>}</li>
 *   <li>{@link com.icteam.loyalty.ui.model.VirtualViewEMFModel#getFilterColumnsAction <em>Filter Columns Action</em>}</li>
 *   <li>{@link com.icteam.loyalty.ui.model.VirtualViewEMFModel#getAdvancedFilterAction <em>Advanced Filter Action</em>}</li>
 *   <li>{@link com.icteam.loyalty.ui.model.VirtualViewEMFModel#getRefreshAction <em>Refresh Action</em>}</li>
 *   <li>{@link com.icteam.loyalty.ui.model.VirtualViewEMFModel#getSelectColumnAction <em>Select Column Action</em>}</li>
 *   <li>{@link com.icteam.loyalty.ui.model.VirtualViewEMFModel#getAddAction <em>Add Action</em>}</li>
 *   <li>{@link com.icteam.loyalty.ui.model.VirtualViewEMFModel#getRemoveAction <em>Remove Action</em>}</li>
 *   <li>{@link com.icteam.loyalty.ui.model.VirtualViewEMFModel#getColumnWidths <em>Column Widths</em>}</li>
 *   <li>{@link com.icteam.loyalty.ui.model.VirtualViewEMFModel#getItemCount <em>Item Count</em>}</li>
 *   <li>{@link com.icteam.loyalty.ui.model.VirtualViewEMFModel#getViewID <em>View ID</em>}</li>
 *   <li>{@link com.icteam.loyalty.ui.model.VirtualViewEMFModel#getModelClass <em>Model Class</em>}</li>
 *   <li>{@link com.icteam.loyalty.ui.model.VirtualViewEMFModel#getTemplateClass <em>Template Class</em>}</li>
 *   <li>{@link com.icteam.loyalty.ui.model.VirtualViewEMFModel#getColumnDomainModelReferences <em>Column Domain Model References</em>}</li>
 *   <li>{@link com.icteam.loyalty.ui.model.VirtualViewEMFModel#getEditorModelEClass <em>Editor Model EClass</em>}</li>
 * </ul>
 *
 * @see com.icteam.loyalty.ui.model.UIModelPackage#getVirtualViewEMFModel()
 * @model
 * @generated
 */
public interface VirtualViewEMFModel<T extends AbstractEMFTemplate< ? >, D extends EMFModel> extends EMFModel, IBaseClassProvider {

    static final int PAGE_SIZE = 100;
    static final int HALF_PAGE_SIZE = 50;

    /**
     * Returns the value of the '<em><b>Search Provider</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Search Provider</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Search Provider</em>' attribute.
     * @see #setSearchProvider(ISearchProvider)
     * @see com.icteam.loyalty.ui.model.UIModelPackage#getVirtualViewEMFModel_SearchProvider()
     * @model dataType="com.icteam.loyalty.model.interfaces.ISearchProvider" transient="true"
     * @generated
     */
    ISearchProvider getSearchProvider();

    /**
     * Sets the value of the '{@link com.icteam.loyalty.ui.model.VirtualViewEMFModel#getSearchProvider <em>Search Provider</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Search Provider</em>' attribute.
     * @see #getSearchProvider()
     * @generated
     */
    void setSearchProvider(ISearchProvider value);

    /**
     * Returns the value of the '<em><b>Selected List</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Selected List</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Selected List</em>' reference list.
     * @see com.icteam.loyalty.ui.model.UIModelPackage#getVirtualViewEMFModel_SelectedList()
     * @model resolveProxies="false" transient="true"
     * @generated
     */
    EList<D> getSelectedList();

    /**
     * Returns the value of the '<em><b>Open Editor Action</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Open Editor Action</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Open Editor Action</em>' reference.
     * @see com.icteam.loyalty.ui.model.UIModelPackage#getVirtualViewEMFModel_OpenEditorAction()
     * @model resolveProxies="false" transient="true" changeable="false" volatile="true"
     * @generated
     */
    Action getOpenEditorAction();

    /**
     * Returns the value of the '<em><b>Column Widths</b></em>' map.
     * The key is of type {@link org.eclipse.emf.ecore.EStructuralFeature},
     * and the value is of type {@link java.lang.Integer},
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Column Widths</em>' map isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Column Widths</em>' map.
     * @see com.icteam.loyalty.ui.model.UIModelPackage#getVirtualViewEMFModel_ColumnWidths()
     * @model mapType="com.icteam.loyalty.ui.interfaces.EStructuralFeatureToIntMap<com.icteam.loyalty.model.interfaces.EStructuralFeature, org.eclipse.emf.ecore.EIntegerObject>"
     * @generated
     */
    EMap<EStructuralFeature, Integer> getColumnWidths();

    /**
     * Returns the value of the '<em><b>Item Count</b></em>' attribute.
     * The default value is <code>"-1"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Item Count</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Item Count</em>' attribute.
     * @see #setItemCount(int)
     * @see com.icteam.loyalty.ui.model.UIModelPackage#getVirtualViewEMFModel_ItemCount()
     * @model default="-1"
     * @generated
     */
    int getItemCount();

    /**
     * Sets the value of the '{@link com.icteam.loyalty.ui.model.VirtualViewEMFModel#getItemCount <em>Item Count</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Item Count</em>' attribute.
     * @see #getItemCount()
     * @generated
     */
    void setItemCount(int value);

    /**
     * Returns the value of the '<em><b>View ID</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>View ID</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>View ID</em>' attribute.
     * @see com.icteam.loyalty.ui.model.UIModelPackage#getVirtualViewEMFModel_ViewID()
     * @model id="true" transient="true" changeable="false" volatile="true"
     * @generated
     */
    String getViewID();

    /**
     * Returns the value of the '<em><b>Model Class</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Model Class</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Model Class</em>' attribute.
     * @see com.icteam.loyalty.ui.model.UIModelPackage#getVirtualViewEMFModel_ModelClass()
     * @model changeable="false"
     * @generated
     */
    Class<D> getModelClass();

    /**
     * Returns the value of the '<em><b>Template Class</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Template Class</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Template Class</em>' attribute.
     * @see com.icteam.loyalty.ui.model.UIModelPackage#getVirtualViewEMFModel_TemplateClass()
     * @model changeable="false"
     * @generated
     */
    Class<T> getTemplateClass();

    /**
     * Returns the value of the '<em><b>Column Domain Model References</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Column Domain Model References</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Column Domain Model References</em>' attribute.
     * @see #setColumnDomainModelReferences(Map)
     * @see com.icteam.loyalty.ui.model.UIModelPackage#getVirtualViewEMFModel_ColumnDomainModelReferences()
     * @model transient="true"
     * @generated
     */
    Map<EStructuralFeature, VFeaturePathDomainModelReference> getColumnDomainModelReferences();

    /**
     * Sets the value of the '{@link com.icteam.loyalty.ui.model.VirtualViewEMFModel#getColumnDomainModelReferences <em>Column Domain Model References</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Column Domain Model References</em>' attribute.
     * @see #getColumnDomainModelReferences()
     * @generated
     */
    void setColumnDomainModelReferences(Map<EStructuralFeature, VFeaturePathDomainModelReference> value);

    /**
     * Returns the value of the '<em><b>Editor Model EClass</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Editor Model EClass</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Editor Model EClass</em>' reference.
     * @see com.icteam.loyalty.ui.model.UIModelPackage#getVirtualViewEMFModel_EditorModelEClass()
     * @model resolveProxies="false" transient="true" changeable="false" volatile="true"
     * @generated
     */
    EClass getEditorModelEClass();

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='        EClass dtoEClass = ModelUtil.getEClass(getTemplateClass());\r\n        \r\n        EFactory factory = dtoEClass.getEPackage().getEFactoryInstance();\r\n        return (T) factory.create(dtoEClass);'"
     * @generated
     */
    T buildTemplate();

    /**
     * Returns the value of the '<em><b>Refresh Action</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Refresh Action</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Refresh Action</em>' reference.
     * @see com.icteam.loyalty.ui.model.UIModelPackage#getVirtualViewEMFModel_RefreshAction()
     * @model resolveProxies="false" transient="true" changeable="false" volatile="true"
     * @generated
     */
    Action getRefreshAction();

    /**
     * Returns the value of the '<em><b>Select Column Action</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Select Column Action</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Select Column Action</em>' reference.
     * @see com.icteam.loyalty.ui.model.UIModelPackage#getVirtualViewEMFModel_SelectColumnAction()
     * @model resolveProxies="false" transient="true" changeable="false" volatile="true"
     * @generated
     */
    Action getSelectColumnAction();

    /**
     * Returns the value of the '<em><b>Add Action</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Add Action</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Add Action</em>' reference.
     * @see com.icteam.loyalty.ui.model.UIModelPackage#getVirtualViewEMFModel_AddAction()
     * @model resolveProxies="false" transient="true" changeable="false" volatile="true"
     * @generated
     */
    Action getAddAction();

    /**
     * Returns the value of the '<em><b>Remove Action</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Remove Action</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Remove Action</em>' reference.
     * @see com.icteam.loyalty.ui.model.UIModelPackage#getVirtualViewEMFModel_RemoveAction()
     * @model resolveProxies="false" transient="true" changeable="false" volatile="true"
     * @generated
     */
    Action getRemoveAction();

    /**
     * Returns the value of the '<em><b>Filter Columns Action</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Filter Columns Action</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Filter Columns Action</em>' reference.
     * @see com.icteam.loyalty.ui.model.UIModelPackage#getVirtualViewEMFModel_FilterColumnsAction()
     * @model resolveProxies="false" transient="true" changeable="false" volatile="true"
     * @generated
     */
    Action getFilterColumnsAction();

    /**
     * Returns the value of the '<em><b>Advanced Filter Action</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Advanced Filter Action</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Advanced Filter Action</em>' reference.
     * @see com.icteam.loyalty.ui.model.UIModelPackage#getVirtualViewEMFModel_AdvancedFilterAction()
     * @model resolveProxies="false" transient="true" changeable="false" volatile="true"
     * @generated
     */
    Action getAdvancedFilterAction();

    /**
     * Returns the value of the '<em><b>Template</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Template</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Template</em>' reference.
     * @see com.icteam.loyalty.ui.model.UIModelPackage#getVirtualViewEMFModel_Template()
     * @model resolveProxies="false" transient="true" changeable="false"
     * @generated
     */
    T getTemplate();

    /**
     * Returns the value of the '<em><b>Filter</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Filter</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Filter</em>' attribute.
     * @see #setFilter(String)
     * @see com.icteam.loyalty.ui.model.UIModelPackage#getVirtualViewEMFModel_Filter()
     * @model annotation="http://com.icteam.loyalty/ui filter='true'"
     * @generated
     */
    String getFilter();

    /**
     * Sets the value of the '{@link com.icteam.loyalty.ui.model.VirtualViewEMFModel#getFilter <em>Filter</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Filter</em>' attribute.
     * @see #getFilter()
     * @generated
     */
    void setFilter(String value);

    /**
     * Returns the value of the '<em><b>List</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>List</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>List</em>' reference list.
     * @see com.icteam.loyalty.ui.model.UIModelPackage#getVirtualViewEMFModel_List()
     * @model resolveProxies="false"
     *        annotation="http://com.icteam.loyalty/property selectedFeature='selectedList' defaultAction='openEditorAction'"
     * @generated
     */
    EList<D> getList();

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model
     * @generated
     */
    void openEditor();

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model annotation="http://www.eclipse.org/emf/2002/GenModel body=' T oldTemplate = this.template;\r\n\r\n        this.template = template;\r\n\r\n        if (!reload(true)) {\r\n            setAdvancedSearchTemplate(oldTemplate);\r\n        }'"
     * @generated
     */
    void setAdvancedSearchTemplate(T template);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='try {\r\n            eUnset(UIModelPackage.VIRTUAL_VIEW_EMF_MODEL__LIST);\r\n            eUnset(UIModelPackage.VIRTUAL_VIEW_EMF_MODEL__SELECTED_LIST);\r\n            eUnset(UIModelPackage.VIRTUAL_VIEW_EMF_MODEL__ITEM_COUNT);\r\n\r\n\t    if (closeEditors) {\r\n               closeEditors();\r\n           }\r\n        } catch (AppException e) {\r\n            MessageDialog.openError(null, com.icteam.loyalty.api.Messages.get().load_error, e.getLocalizedMessage());\r\n            return false;\r\n        }\r\n\r\n        return true;'"
     * @generated
     */
    boolean reload(boolean closeEditors);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model filterFeaturesDataType="com.icteam.loyalty.model.interfaces.EStructuralFeature" filterFeaturesMany="true"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel body='        EList<EStructuralFeature> oldFilterFeatures = getTemplate().getDynamicFilterFeatures();\r\n\r\n        getTemplate().setDynamicFilterFeatures(filterFeatures);\r\n\r\n        if (reload) {\r\n            if (!reload(true)) {\r\n                setFilterFeatures(oldFilterFeatures, reload);\r\n            }\r\n        }\r\n'"
     * @generated
     */
    void setFilterFeatures(EList<EStructuralFeature> filterFeatures, boolean reload);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='IEditorReference[] editorReferences = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getEditorReferences();\r\n        java.util.List<IEditorReference> list = new ArrayList<>();\r\n\r\n        for (IEditorReference editorReference : editorReferences) {\r\n            try {\r\n                if (getEditorModelEClass().isInstance(editorReference.getEditorInput())) {\r\n                    list.add(editorReference);\r\n                }\r\n            } catch (PartInitException e) {\r\n                // nothing to do\r\n            }\r\n        }\r\n\r\n        PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().closeEditors(list.toArray(new IEditorReference[] {}), true);'"
     * @generated
     */
    void closeEditors();

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model type="com.icteam.loyalty.ui.interfaces.IEditorPart"
     * @generated
     */
    IEditorPart findEditor(D model);

} // VirtualViewEMFModel
