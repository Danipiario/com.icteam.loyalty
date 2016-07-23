package com.icteam.loyalty.ui.interfaces;

import java.util.List;

import com.icteam.loyalty.model.ModelBuilder;
import com.icteam.loyalty.model.interfaces.IDtoModel;
import com.icteam.loyalty.model.template.AbstractTemplate;

public interface IVirtualView<T extends AbstractTemplate< ? >, D extends IDtoModel> extends IViewerProvider {

    static final int PAGE_SIZE = 100;
    static final int HALF_PAGE_SIZE = 50;

    String getViewID();

    String getObjectID();

    String getEditorID();

    T getTemplate();

    T getDefaultTemplate();

    T buildTemplate();

    int handleCount(T t);

    List<D> handleSearch(T t);

    List<D> getViewInput();

    boolean reload(boolean closeEditors);

    void setAdvancedSearchTemplate(T template);

    void setFilterProperties(List<String> filterProperties, boolean reload);

    void setFilter(String filter);

    String getFilter();

    Class<D> getDtoModelClass();

    ModelBuilder<D> getModelBuilder();

}
