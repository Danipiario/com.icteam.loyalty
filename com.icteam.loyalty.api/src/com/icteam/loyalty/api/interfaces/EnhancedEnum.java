package com.icteam.loyalty.api.interfaces;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import com.google.gson.annotations.Expose;

/**
 * The type Enhanced enum.
 */
public abstract class EnhancedEnum<E extends EnhancedEnum<E, S>, S extends Serializable & Comparable<S>> implements IEnhancedEnum<E, S>,
        ISelectable<S> {

    private static final long serialVersionUID = -8173457165010114289L;

    /**
     * The constant REMOVE_PREFIX.
     */
    @Property(translatable = false)
    public static final String REMOVE_PREFIX = "REMOVE_";

    @Expose
    @Property(translatable = false)
    protected S name;

    @Property
    protected S key; // utilizzato solo come placeholder

    @Property(translatable = false)
    private static final Map<String, Map< ? , ? extends EnhancedEnum< ? , ? >>> VALUES = new HashMap<>();
    @Property(translatable = false)
    private static final Map<String, Set< ? extends EnhancedEnum< ? , ? >>> SETS = new HashMap<>();

    public EnhancedEnum() {
        super();
    }

    public EnhancedEnum(S name) {
        // placeholder for blueprint initialization
        if ("".equals(name)) {
            return;
        }

        this.name = name;

        if (name.toString().startsWith(REMOVE_PREFIX)) {
            removeFromValues();
            removeFromSets();
        } else {
            addInValues();
            addInSets();
        }
    }

    @Override
    public S name() {
        return name;
    }

    /**
     * Values list.
     *
     * @param enhancedEnumClass
     *            the enhanced enum class
     * @return the list
     */
    public static <S extends Serializable & Comparable<S>, E extends EnhancedEnum<E, S>> List<E> values(Class< ? extends E> enhancedEnumClass) {
        Set< ? extends EnhancedEnum< ? , ? >> values = SETS.get(enhancedEnumClass.getName());

        if (values == null) {
            initLazyEnums(enhancedEnumClass);

            values = SETS.get(enhancedEnumClass.getName());

            if (values == null) {

                throw new IllegalArgumentException("No Enhanced enum values for const " + enhancedEnumClass);
            }
        }

        return new ArrayList<>((Collection< ? extends E>) values);
    }

    /**
     * Value of.
     *
     * @param enhancedEnumClass
     *            the enhanced enum class
     * @param name
     *            the name
     * @return the e
     */
    public static <S extends Serializable & Comparable<S>, E extends EnhancedEnum<E, S>> E valueOf(Class< ? extends E> enhancedEnumClass, S name) {
        Map<S, E> values = (Map<S, E>) VALUES.get(enhancedEnumClass.getName());

        if (values == null) {
            initLazyEnums(enhancedEnumClass);

            values = (Map<S, E>) VALUES.get(enhancedEnumClass.getName());

            if (values == null) {
                throw new IllegalArgumentException("No values for Enhanced enum class " + enhancedEnumClass);
            }
        }

        E value = null;
        int i = 0;

        while (true) {
            value = values.get(name);

            if (value == null) {
                if (i > 10) {
                    throw new IllegalArgumentException("No Enhanced enum const " + enhancedEnumClass + '.' + name);
                } else {
                    // initialization delay
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                break;
            }
        }

        return value;
    }

    /**
     * Estrae dal solo nome un enum, da usare con cautela perche' potrebbero esserci enum di diverse classi con lo stesso name
     * @param name
     */
    public static <S extends Serializable & Comparable<S>, E extends EnhancedEnum<E, S>> E enumByName(S name) {
        for (Map< ? , ? extends EnhancedEnum< ? , ? >> values : VALUES.values()) {
            E value = (E) values.get(name);

            if (value != null) {
                return value;
            }
        }

        return null;
    }

    public static void initLazyEnums(Class< ? > lazyEnumClass) {
        Field[] fields = lazyEnumClass.getFields();

        for (Field field : fields) {
            if (Modifier.isStatic(field.getModifiers()) && Modifier.isPublic(field.getModifiers())) {
                try {
                    field.get(null);
                    break;
                } catch (IllegalArgumentException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public int compareTo(E o) {
        if (!getClass().getName().equals(o.getClass().getName())) {
            throw new ClassCastException();
        }

        return name.compareTo(o.name());
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + getClass().hashCode();
        result = prime * result + (name == null ? 0 : name.hashCode());

        return result;
    }

    @Override
    public boolean equals(Object obj) {
        Class< ? > clazz = getClass();
        Class< ? > otherClazz = obj == null ? null : obj.getClass();

        return clazz.equals(otherClazz) && name.equals(((E) obj).name());

    }

    @Override
    public String toString() {
        return name.toString();
    }

    protected void addInValues() {
        Map<S, E> values = (Map<S, E>) VALUES.get(getClass().getName());

        if (values == null) {
            values = new HashMap<>();
            VALUES.put(getClass().getName(), values);
        }

        Object old = values.get(name);

        if (old != null && !old.getClass().getName().equals(getClass().getName())) {
            throw new IllegalArgumentException("Duplicate name #" + name + " for enum #" + getClass());
        }

        values.put(name, (E) this);
    }

    private void removeFromValues() {
        Map<String, E> values = (Map<String, E>) VALUES.get(getClass().getName());

        if (values == null || !values.containsKey(name)) {
            throw new IllegalArgumentException("Enum #" + getClass() + " with name #" + name + " not found for remove");
        }

        values.remove(name);
    }

    private void addInSets() {
        Set<E> sets = (Set<E>) SETS.get(getClass().getName());

        if (sets == null) {
            sets = buildSet();
            SETS.put(getClass().getName(), sets);
        }

        sets.add((E) this);
    }

    /**
     * ritorna il set con cui memorizzare i valori dell'enum
     *
     * @return l 'implementazione di default ritorna un
     */
    protected Set<E> buildSet() {
        return new TreeSet<>();
    }

    private void removeFromSets() {
        Set<E> sets = (Set<E>) SETS.get(getClass().getName());

        if (sets == null || !sets.contains(this)) {
            throw new IllegalArgumentException("Enum #" + getClass() + " with name #" + name + " not found for remove");
        }

        sets.remove(this);
    }

    Object readResolve() {
        return valueOf(getClass(), name);
    }

    @Override
    @Translated
    public S getKey() {
        return name();
    }

    @Override
    public String getDescription() {
        return getClass().getSimpleName() + '_' + name();
    }

}
