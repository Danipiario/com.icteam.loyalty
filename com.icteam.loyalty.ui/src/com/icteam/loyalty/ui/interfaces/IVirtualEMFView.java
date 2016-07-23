package com.icteam.loyalty.ui.interfaces;

import com.icteam.loyalty.model.EMFModel;
import com.icteam.loyalty.model.interfaces.ISearchProvider;
import com.icteam.loyalty.model.template.AbstractEMFTemplate;
import com.icteam.loyalty.ui.model.VirtualViewEMFModel;

public interface IVirtualEMFView<V extends VirtualViewEMFModel< ? extends AbstractEMFTemplate< ? >, ? extends EMFModel>> {

    V getVirtualViewEMFModel();

    ISearchProvider getSearchProvider();
}
