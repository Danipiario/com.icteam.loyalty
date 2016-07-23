package com.icteam.loyalty.model.interfaces;

import com.icteam.loyalty.api.interfaces.EnhancedEnum;
import com.icteam.loyalty.api.interfaces.Property;
import com.icteam.loyalty.api.interfaces.PropertyClass;

@PropertyClass(translateAll = true)
public class EPerspective extends EnhancedEnum<EPerspective, String> {

    private static final long serialVersionUID = -7774168263162178871L;

    public static final EPerspective ADMINISTRATION = new EPerspective("ADMINISTRATION", "administration_perspective");
    public static final EPerspective CONFIGURATION = new EPerspective("CONFIGURATION", "configuration_perspective");

    @Property(translatable = false)
    private final String id;

    public EPerspective(String name, String id) {
        super(name);

        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public int compareTo(EPerspective o) {
//        if (this.equals(ADMINISTRATION) && !ADMINISTRATION.equals(o)) {
//            return -1;
//        }
//
//        if (!this.equals(ADMINISTRATION) && ADMINISTRATION.equals(o)) {
//            return 1;
//        }

        return super.compareTo(o);
    }

}
