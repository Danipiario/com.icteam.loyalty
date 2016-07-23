package com.icteam.loyalty.model.interfaces;

import org.eclipse.emf.ecore.EFactory;

import com.icteam.loyalty.model.EMFModel;

public interface CustomModelFactory extends EFactory {

    <D extends EMFModel> D buildCustomModel(Object dbModel, D model);

    <D extends EMFModel> Object buildCustomDbModel(Object dbModel, D model);
}
