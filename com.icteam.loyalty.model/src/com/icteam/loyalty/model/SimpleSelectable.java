package com.icteam.loyalty.model;

import com.icteam.loyalty.api.interfaces.ISelectable;

public class SimpleSelectable implements ISelectable<String>, Comparable<SimpleSelectable> {

    private final String element;

    public SimpleSelectable(String element) {
        this.element = element;
    }

    @Override
    public String getKey() {
        return element;
    }

    @Override
    public String getDescription() {
        return element.toString();
    }

    @Override
    public String toString() {
        return "SimpleSelectable [element=" + element + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (element == null ? 0 : element.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        SimpleSelectable other = (SimpleSelectable) obj;
        if (element == null) {
            if (other.element != null) {
                return false;
            }
        } else if (!element.equals(other.element)) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(SimpleSelectable o) {
        return element.compareTo(o.element);
    }
}