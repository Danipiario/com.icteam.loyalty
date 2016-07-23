/**
 */
package com.icteam.loyalty.model.interfaces;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>IEMF Model</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see com.icteam.loyalty.model.interfaces.ModelInterfacesPackage#getIEMFModel()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface IEMFModel extends IEditable {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='        if (!deliver) {\r\n            destModel.eSetDeliver(false);\r\n        }\r\n\r\n        for (EStructuralFeature feature : eClass().getEAllStructuralFeatures()) {\r\n            if (feature.isChangeable()) {\r\n                Boolean copy = (Boolean) ModelUtil.getAnnotation(feature, com.icteam.loyalty.model.interfaces.EAnnotation.COPY);\r\n\r\n                if (copy) {\r\n                    destModel.eSet(feature, eGet(feature));\r\n                }\r\n            }\r\n        }\r\n\r\n        destModel.setDirty(isDirty());\r\n\r\n        if (!deliver) {\r\n            destModel.eSetDeliver(true);\r\n        }'"
     * @generated
     */
    <C extends IEMFModel> void copyTo(C destModel, boolean deliver);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='return ModelUtil.equals(this, obj);'"
     * @generated
     */
    @Override
    boolean equals(Object obj);

} // IEMFModel
