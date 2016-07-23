package com.icteam.loyalty.ui.control;

import java.util.LinkedHashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecp.view.spi.custom.model.ECPHardcodedReferences;
import org.eclipse.emf.ecp.view.spi.model.VDomainModelReference;
import org.eclipse.emf.ecp.view.spi.model.VFeaturePathDomainModelReference;
import org.eclipse.emf.ecp.view.spi.model.VViewFactory;

public class NToMDomainModelReferences implements ECPHardcodedReferences {

    @Override
    public Set<VDomainModelReference> getNeededDomainModelReferences() {
        Set<VDomainModelReference> features = new LinkedHashSet<>();
        VFeaturePathDomainModelReference list = VViewFactory.eINSTANCE.createFeaturePathDomainModelReference();
        list.setDomainModelEFeature(EcoreFactory.eINSTANCE.getEcorePackage().getEEList().eContainingFeature());
        features.add(list);

        return features;
    }

}
