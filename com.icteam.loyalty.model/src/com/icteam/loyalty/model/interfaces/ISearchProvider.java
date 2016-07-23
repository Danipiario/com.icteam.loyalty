package com.icteam.loyalty.model.interfaces;

import java.util.List;

import com.icteam.loyalty.model.EMFModel;

public interface ISearchProvider {

    List< ? extends EMFModel> search(IEMFTemplate< ? > template);

    int count(IEMFTemplate< ? > template);

}
