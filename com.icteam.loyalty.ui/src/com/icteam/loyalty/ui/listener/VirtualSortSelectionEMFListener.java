package com.icteam.loyalty.ui.listener;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.databinding.FeaturePath;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecp.view.spi.model.VFeaturePathDomainModelReference;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;

import com.icteam.loyalty.model.EMFModel;
import com.icteam.loyalty.model.interfaces.OrderDirectionEMF;
import com.icteam.loyalty.model.template.AbstractEMFTemplate;
import com.icteam.loyalty.ui.model.VirtualViewEMFModel;

public class VirtualSortSelectionEMFListener<T extends AbstractEMFTemplate< ? >, D extends EMFModel> extends DefaultSortSelectionEMFListener {

    private static final long serialVersionUID = -5335144747231037618L;

    private final T template;
    private final VirtualViewEMFModel<T, D> virtualViewEMFModel;

    private final FeaturePath featurePath;

    public VirtualSortSelectionEMFListener(VirtualViewEMFModel<T, D> virtualViewEMFModel, TableViewer tableViewer, Class< ? extends Object> beanClass,
            EStructuralFeature structuralFeature) {
        super(tableViewer, beanClass, structuralFeature);

        this.virtualViewEMFModel = virtualViewEMFModel;
        this.template = virtualViewEMFModel.getTemplate();
        VFeaturePathDomainModelReference vFeaturePathDomainModelReference = virtualViewEMFModel.getColumnDomainModelReferences().get(structuralFeature);

        List<EStructuralFeature> structuralFeatures = new ArrayList<>();
        for (EStructuralFeature eStructuralFeature : vFeaturePathDomainModelReference.getDomainModelEReferencePath()) {
            structuralFeatures.add(eStructuralFeature);
        }

        structuralFeatures.add(structuralFeature);

        featurePath = FeaturePath.fromList(structuralFeatures.toArray(new EStructuralFeature[] {}));
    }

    @Override
    protected void handleSort() {
        template.setDynamicOrderFeature(featurePath);
        template.setDynamicOrderDirection(convert(getTable().getSortDirection()));

        virtualViewEMFModel.reload(false);
    }

    private static OrderDirectionEMF convert(int direction) {
        switch (direction) {
            case SWT.UP:
                return OrderDirectionEMF.ASC;
            case SWT.DOWN:
                return OrderDirectionEMF.DESC;
            default:
                return null;
        }
    }
}