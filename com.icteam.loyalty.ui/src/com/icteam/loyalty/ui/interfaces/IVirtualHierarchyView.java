package com.icteam.loyalty.ui.interfaces;

import com.icteam.loyalty.model.interfaces.IDtoModel;
import com.icteam.loyalty.model.template.AbstractTemplate;

public interface IVirtualHierarchyView<T extends AbstractTemplate< ? >, D extends IDtoModel> extends IVirtualView<T, D> {

}
