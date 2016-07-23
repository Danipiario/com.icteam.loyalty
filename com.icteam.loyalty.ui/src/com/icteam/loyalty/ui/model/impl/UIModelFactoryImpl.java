/**
 */
package com.icteam.loyalty.ui.model.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import com.icteam.loyalty.model.EMFModel;
import com.icteam.loyalty.model.template.AbstractEMFTemplate;
import com.icteam.loyalty.ui.model.DefaultEditorEMFModel;
import com.icteam.loyalty.ui.model.NToMEMFModel;
import com.icteam.loyalty.ui.model.UIModelFactory;
import com.icteam.loyalty.ui.model.UIModelPackage;
import com.icteam.loyalty.ui.model.VirtualViewEMFModel;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class UIModelFactoryImpl extends EFactoryImpl implements UIModelFactory {
    /**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static UIModelFactory init() {
        try {
            UIModelFactory theUIModelFactory = (UIModelFactory) EPackage.Registry.INSTANCE.getEFactory(UIModelPackage.eNS_URI);
            if (theUIModelFactory != null) {
                return theUIModelFactory;
            }
        } catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new UIModelFactoryImpl();
    }

    /**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public UIModelFactoryImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EObject create(EClass eClass) {
        switch (eClass.getClassifierID()) {
            case UIModelPackage.NTO_MEMF_MODEL:
                return createNToMEMFModel();
            case UIModelPackage.DEFAULT_EDITOR_EMF_MODEL:
                return createDefaultEditorEMFModel();
            case UIModelPackage.VIRTUAL_VIEW_EMF_MODEL:
                return createVirtualViewEMFModel();
            default:
                throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NToMEMFModel createNToMEMFModel() {
        NToMEMFModelImpl nToMEMFModel = new NToMEMFModelImpl();
        return nToMEMFModel;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public <D extends EMFModel> DefaultEditorEMFModel<D> createDefaultEditorEMFModel() {
        DefaultEditorEMFModelImpl<D> defaultEditorEMFModel = new DefaultEditorEMFModelImpl<D>();
        return defaultEditorEMFModel;
    }

    @Override
    public <D extends EMFModel> DefaultEditorEMFModel<D> createDefaultEditorEMFModelForSearch(D model) {
        return new DefaultEditorEMFModelImpl<>(model);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public <T extends AbstractEMFTemplate< ? >, D extends EMFModel> VirtualViewEMFModel<T, D> createVirtualViewEMFModel() {
        VirtualViewEMFModelImpl<T, D> virtualViewEMFModel = new VirtualViewEMFModelImpl<T, D>();
        return virtualViewEMFModel;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public UIModelPackage getUIModelPackage() {
        return (UIModelPackage) getEPackage();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
    @Deprecated
    public static UIModelPackage getPackage() {
        return UIModelPackage.eINSTANCE;
    }

} //UIModelFactoryImpl
