package com.icteam.loyalty.ui.validator;

import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.icteam.loyalty.model.provider.LoyaltyItemProviderAdapter;
import com.icteam.loyalty.model.util.ModelUtil;

public class LoyaltyDiagnostician extends Diagnostician {

    private EObject eObject = null;

    public LoyaltyDiagnostician(EObject eObject) {
        super();

        this.eObject = eObject;
    }

    @Override
    public String getObjectLabel(EObject eObject) {
        return ModelUtil.getID(eObject);
    }

    @Override
    public String getFeatureLabel(EStructuralFeature eStructuralFeature) {
        return LoyaltyItemProviderAdapter.getDiplayName(eObject, eStructuralFeature);
    }

    @Override
    public String getValueLabel(EDataType eDataType, Object value) {
        return EcoreUtil.convertToString(eDataType, value);
    }
}
