package com.icteam.loyalty.model.interfaces;

import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EcorePackage;

import com.icteam.loyalty.api.interfaces.IConstants;

public enum EAnnotation {

    DB_MODEL(IConstants.SOURCE_URI_PROPERTY, "dbModel", EcorePackage.Literals.EJAVA_CLASS), ID(IConstants.SOURCE_URI_PROPERTY, "id",
            EcorePackage.Literals.EBOOLEAN_OBJECT, Boolean.FALSE), CUSTOM_BUILD(IConstants.SOURCE_URI_PROPERTY, "customBuild",
            EcorePackage.Literals.EBOOLEAN_OBJECT, Boolean.FALSE), DB_PROPERTY(IConstants.SOURCE_URI_PROPERTY, "dbProperty",
            EcorePackage.Literals.ESTRING), CHOICES_FEATURE(IConstants.SOURCE_URI_PROPERTY, "choices",
            ModelInterfacesPackage.Literals.ESTRUCTURAL_FEATURE), REVERT_CHOICES_FEATURE(IConstants.SOURCE_URI_PROPERTY, "revertChoices",
            ModelInterfacesPackage.Literals.ESTRUCTURAL_FEATURE), SHOW_AS_COLUMN(IConstants.SOURCE_URI_PROPERTY, "showAsColumn",
            EcorePackage.Literals.EBOOLEAN_OBJECT, Boolean.TRUE), COLUMNS_TO_SHOW(IConstants.SOURCE_URI_PROPERTY, "columnsToShow",
            EcorePackage.Literals.ESTRING), PASSWORD(IConstants.SOURCE_URI_UI, "password", EcorePackage.Literals.EBOOLEAN_OBJECT, Boolean.FALSE), FILTER(
            IConstants.SOURCE_URI_UI, "filter", EcorePackage.Literals.EBOOLEAN_OBJECT, Boolean.FALSE), COPY(IConstants.SOURCE_URI_PROPERTY, "copy",
            EcorePackage.Literals.EBOOLEAN_OBJECT, Boolean.TRUE), DYNAMIC_FILTERABLE(IConstants.SOURCE_URI_WHERE, "dynamicFilterable",
            ModelInterfacesPackage.Literals.EDYNAMIC_FILTERABLE_EMF, EDynamicFilterableEMF.NO), CLAUSE(IConstants.SOURCE_URI_WHERE, "clause",
            ModelInterfacesPackage.Literals.EWHERE_CLAUSE_EMF, EWhereClauseEMF.EQUAL), TEMPLATE_CLAUSE(IConstants.SOURCE_URI_WHERE, "templateClause",
            ModelInterfacesPackage.Literals.EWHERE_TEMPLATE_CLAUSE_EMF, EWhereTemplateClauseEMF.EQUAL), PREFIX_I18N(IConstants.SOURCE_URI_WHERE,
            "prefixI18N", EcorePackage.Literals.ESTRING), SELECTED_FEATURE(IConstants.SOURCE_URI_PROPERTY, "selectedFeature",
            ModelInterfacesPackage.Literals.ESTRUCTURAL_FEATURE), DEFAULT_ACTION(IConstants.SOURCE_URI_PROPERTY, "defaultAction",
            ModelInterfacesPackage.Literals.ESTRUCTURAL_FEATURE);

    private final String key;
    private final String sourceURI;
    private final EDataType dataType;
    private final Object defaultValue;

    EAnnotation(String sourceURI, String key, EDataType dataType) {
        this(sourceURI, key, dataType, null);
    }

    EAnnotation(String sourceURI, String key, EDataType dataType, Object defaultValue) {
        this.sourceURI = sourceURI;
        this.key = key;
        this.dataType = dataType;
        this.defaultValue = defaultValue;
    }

    public String sourceURI() {
        return sourceURI;
    }

    public String key() {
        return key;
    }

    public EDataType getEDataType() {
        return dataType;
    }

    public Object getDefaultValue() {
        return defaultValue;
    }

}
