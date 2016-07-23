package com.icteam.loyalty.model.interfaces;

import java.util.Collection;

import org.apache.commons.beanutils.BeanPropertyValueEqualsPredicate;
import org.apache.commons.collections.CollectionUtils;

import com.icteam.loyalty.api.interfaces.ConverterClass;
import com.icteam.loyalty.api.interfaces.EnhancedEnum;
import com.icteam.loyalty.api.interfaces.IConstants;
import com.icteam.loyalty.api.interfaces.Property;
import com.icteam.loyalty.api.interfaces.PropertyClass;

/**
 * This source file was created by ICTeam S.P.A.
 * <p/>
 * The software must not be used nor reproduced in any form without ICTeam and customer authorization
 * <p/>
 * Project : altyActivator Customer : ICTeam
 * <p/>
 * Author : $Author: artebani$ File : $HeadURL:
 * http://jolokia:1080/svn/ICTeam/Loyalty2.0/trunk/loyalty-interfaces/src/main/java/com/icteam/loyalty/interfaces/enums/EOperatorType.java $ Revision
 * : $Revision: 3092 $ Last Checkin: $Date: 2012-12-11 17:17:53 +0100(mar, 11 dic 2012) $
 */
@PropertyClass(translateAll = true)
@ConverterClass
public class EPermission extends EnhancedEnum<EPermission, String> implements Comparable<EPermission> {

    private static final long serialVersionUID = -2660388559241236205L;

    @Property(translatable = false)
    public static final String[] availableActions = new String[] { IConstants.EDIT, IConstants.VIEW, IConstants.ADD, IConstants.REMOVE };

    @Property(translatable = false)
    private static final String OBJECT_ADMINISTRATION = "administration";
    @Property(translatable = false)
    private static final String OBJECT_CONFIGURATION = "configuration";

    public static final EPermission ADMINISTRATION_VIEW = new EPermission("ADMINISTRATION_VIEW", OBJECT_ADMINISTRATION, IConstants.VIEW);
    public static final EPermission CONFIGURATION_VIEW = new EPermission("CONFIGURATION_VIEW", OBJECT_CONFIGURATION, IConstants.VIEW);

    @Property(translatable = false)
    private final String object;
    @Property(translatable = false)
    private final String action;

    public EPermission(String name, String object, String action) {
        super(name);

        this.object = object;
        this.action = action;
    }

    public String getPermission() {
        return object + IConstants.UNDERSCORE + action;
    }

    public boolean isStarPermission() {
        return IConstants.STAR.equals(action);
    }

    public String getObject() {
        return object;
    }

    public String getAction() {
        return action;
    }

    public static Collection<EPermission> getPermissions(EPermission permission) {
        return getPermissions(permission.getObject());
    }

    public static Collection<EPermission> getPermissions(String object) {
        return CollectionUtils.select(values(EPermission.class), new BeanPropertyValueEqualsPredicate("object", object));
    }

    @Override
    public int compareTo(EPermission o) {
        if (this.isStarPermission() && !o.isStarPermission()) {
            return -1;
        }

        if (!this.isStarPermission() && o.isStarPermission()) {
            return 1;
        }

        int c = getPermission().compareTo(o.getPermission());

        if (c == 0) {
            c = name().compareTo(o.name());
        }

        return c;
    }

}
