package com.icteam.loyalty.ui.model;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.beans.PropertyDescriptor;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Id;

import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.NestedNullException;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.beanutils.expression.Resolver;
import org.apache.commons.lang.StringUtils;
import org.eclipse.core.databinding.conversion.IConverter;

import com.icteam.loyalty.model.DtoListModel;
import com.icteam.loyalty.model.interfaces.Editable;
import com.icteam.loyalty.model.interfaces.IModel;
import com.icteam.loyalty.model.interfaces.Password;
import com.icteam.loyalty.model.interfaces.Required;
import com.icteam.loyalty.model.interfaces.Validated;
import com.icteam.loyalty.ui.converter.ConverterUtils;
import com.icteam.loyalty.ui.interfaces.IModelProperty;

public class ModelProperty<M extends IModel, S extends Object> implements IModelProperty<M, S>, Serializable, Cloneable {

    private static final long serialVersionUID = -3315192583049329699L;

    private final boolean dirty = false;

    protected final PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private final M model;

    private final String property;

    private boolean enabled = true;

    private boolean required = false;

    private boolean password = false;

    private boolean editable = false;

    private Validated validated = null;

    private final Map<Integer, PropertyChangeListener> modelPropertyChangeListeners = new HashMap<>();

    private IConverter modelConverter;
    private IConverter targetConverter;

    private final PropertyChangeListener dirtyPropertyChangeListener = new PropertyChangeListener() {
        @Override
        public void propertyChange(PropertyChangeEvent evt) {
            setDirty(true);
        }
    };

    private Field fieldProperty;

    public ModelProperty(M model, String property) {
        this.model = model;
        this.property = property;

        initialize();
    }

    @Override
    public void initialize() {
        try {
            initNestedListeners();

            PropertyDescriptor propertyDescriptor = PropertyUtils.getPropertyDescriptor(model, property);
            Method readPropertyMethod = propertyDescriptor.getReadMethod();

            setFieldProperty(propertyDescriptor);

            Object value = PropertyUtils.getProperty(model, property);

            boolean id = readPropertyMethod.isAnnotationPresent(Id.class);
            boolean req = readPropertyMethod.isAnnotationPresent(Required.class);
            boolean pwd = readPropertyMethod.isAnnotationPresent(Password.class);

            setEnabled(model.isEditable() && !(id && value != null));
            setRequired(id || req && isEnabled());
            setPassword(pwd);
            setEditable(readPropertyMethod.getAnnotation(Editable.class));
            setValidated(readPropertyMethod.getAnnotation(Validated.class));

            setModelConverter(ConverterUtils.computePropertyConverter(propertyDescriptor, false));
            setTargetConverter(ConverterUtils.computePropertyConverter(propertyDescriptor, true));

            initPropertyValueListener();
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        } catch (NestedNullException nne) {
            // handled by listeners
        }
    }

    private void setFieldProperty(PropertyDescriptor propertyDescriptor) {
        fieldProperty = getFieldProperty(getNestedModelClass(), propertyDescriptor.getName());
    }

    private Field getFieldProperty(Class< ? > clazz, String name) {
        try {
            if (clazz != null) {
                return clazz.getDeclaredField(name);
            }

            return null;
        } catch (NoSuchFieldException | SecurityException e) {
            // search in super class
            return getFieldProperty(clazz.getSuperclass(), name);
        }
    }

    @Override
    public Field getFieldProperty() {
        return fieldProperty;
    }

    private void setModelConverter(IConverter modelConverter) {
        this.modelConverter = modelConverter;
    }

    @Override
    public IConverter getModelConverter() {
        return modelConverter;
    }

    @Override
    public IConverter getTargetConverter() {
        return targetConverter;
    }

    public void setTargetConverter(IConverter targetConverter) {
        this.targetConverter = targetConverter;
    }

    private void initPropertyValueListener() {
        changeSupport.removePropertyChangeListener("propertyValue", dirtyPropertyChangeListener);

        changeSupport.firePropertyChange("propertyValue", null, getPropertyValue());

        changeSupport.addPropertyChangeListener("propertyValue", dirtyPropertyChangeListener);
    }

    private void initNestedListeners() throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        Resolver resolver = BeanUtilsBean.getInstance().getPropertyUtils().getResolver();

        String name = property;
        Object bean = model;

        if (resolver.hasNested(name)) {
            int level = 0;
            while (resolver.hasNested(name)) {
                String next = resolver.next(name);

                ModelPropertyChangeListener.addListener(this, bean, next, level);

                Object nestedBean = PropertyUtils.getProperty(bean, next);

                if (nestedBean == null) {
                    break;
                }

                bean = nestedBean;
                name = resolver.remove(name);

                level++;
            }
        } else {
            ModelPropertyChangeListener.addListener(this, bean, name, 0);
        }
    }

    @Override
    public S getPropertyValue() {
        try {
            return (S) PropertyUtils.getProperty(model, property);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        } catch (NestedNullException nne) {
            // no property value
        }

        return null;
    }

    @Override
    public void setPropertyValue(S propertyValue) {
        try {
            S newPropertyValue = propertyValue;

            if (newPropertyValue != null && StringUtils.isEmpty(newPropertyValue.toString())) {
                newPropertyValue = null;
            }

            S oldValue = getPropertyValue();

            PropertyUtils.setProperty(model, property, newPropertyValue);

            changeSupport.firePropertyChange("propertyValue", oldValue, newPropertyValue);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        } catch (NestedNullException nne) {
            // no property value
        }
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    @Override
    public void addPropertyChangeListener(String propertyName, PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(propertyName, listener);
    }

    @Override
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

    @Override
    public void removePropertyChangeListener(String propertyName, PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(propertyName, listener);
    }

    @Override
    public String getProperty() {
        return property;
    }

    @Override
    public String getNestedProperty() {
        return ModelProperty.getNestedProperty(property);
    }

    @Override
    public M getModel() {
        return model;
    }

    public boolean isDtoListModel() {
        return model instanceof DtoListModel && DtoListModel.class.isAssignableFrom(getNestedModelClass());
    }

    @Override
    public Class< ? > getNestedModelClass() {
        return ModelProperty.getNestedClass(property, model.getClass());
    }

    @Override
    public Class<S> getNestedPropertyClass() {
        Class< ? > nestedModelClass = getNestedModelClass();
        String nestedProperty = getNestedProperty();

        PropertyDescriptor propertyDescriptor = ModelProperty.extractPropertyDescriptor(nestedModelClass, nestedProperty);

        return (Class<S>) propertyDescriptor.getPropertyType();
    }

    @Override
    public boolean isDirty() {
        return dirty;
    }

    public void setDirty(boolean dirty) {
        model.setDirty(dirty);
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public boolean isRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        changeSupport.firePropertyChange("required", this.required, this.required = required);
    }

    @Override
    public boolean isPassword() {
        return password;
    }

    public void setPassword(boolean password) {
        changeSupport.firePropertyChange("password", this.password, this.password = password);
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(Editable editable) {
        setEditable(editable == null || editable.value());
    }

    public void setEditable(boolean editable) {
        changeSupport.firePropertyChange("editable", this.editable, this.editable = editable);
    }

    public void setValidated(Validated validated) {
        this.validated = validated;
    }

    @Override
    public Validated getValidated() {
        return validated;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public Map<Integer, PropertyChangeListener> getPropertyChangeListeners() {
        return modelPropertyChangeListeners;
    }

    public static String getNestedProperty(String name) {
        Resolver resolver = BeanUtilsBean.getInstance().getPropertyUtils().getResolver();

        while (resolver.hasNested(name)) {

            name = resolver.remove(name);
        }

        return name;
    }

    public static Class< ? > getNestedClass(String name, Class< ? > beanClass) {
        Resolver resolver = BeanUtilsBean.getInstance().getPropertyUtils().getResolver();

        while (resolver.hasNested(name)) {
            String next = resolver.next(name);

            PropertyDescriptor propertyDescriptor = ModelProperty.extractPropertyDescriptor(beanClass, next);

            name = resolver.remove(name);

            if (propertyDescriptor != null) {
                beanClass = propertyDescriptor.getPropertyType();
            }
        }

        return beanClass;
    }

    public static PropertyDescriptor extractPropertyDescriptor(Class< ? > beanClass, String property) {
        PropertyDescriptor[] pds = PropertyUtils.getPropertyDescriptors(beanClass);

        for (PropertyDescriptor pd : pds) {
            if (pd.getName().equals(property)) {
                return pd;
            }
        }

        return null;
    }
}