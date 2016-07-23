package com.icteam.loyalty.api.format;

import org.osgi.service.component.annotations.Component;

import com.icteam.loyalty.api.interfaces.EnhancedEnum;
import com.icteam.loyalty.api.interfaces.IDelegated;
import com.icteam.loyalty.api.interfaces.IFormat;

/**
 * This source file was created by ICTeam S.P.A.
 * <p/>
 * The software must not be used nor reproduced in any form without
 * ICTeam and customer authorization
 * <p/>
 * Project     : LoyaltyActivator
 * Customer    : ICTeam
 * <p/>
 * Author      : $Author: l.tomasini $
 * File        : $HeadURL: http://jolokia:1080/svn/ICTeam/Loyalty2.0/trunk/loyalty-core/src/main/java/com/icteam/loyalty/core/format/DateFormat.java $
 * Revision    : $Revision: 3092 $
 * Last Checkin: $Date: 2012-12-11 17:17:53 +0100(mar, 11 dic 2012) $
 */
@Component(service = { IFormat.class, IDelegated.class }, property = { "delegatedId=EnumFormat" })
public class EnumFormat implements IFormat<EnhancedEnum< ? , String>> {

    private static final long serialVersionUID = -2190686856922914965L;

    @Override
    public String format(EnhancedEnum< ? , String> obj) {
        if (obj == null) {
            return null;
        }

        return obj.getKey();
    }

    @Override
    public EnhancedEnum< ? , String> parseObject(String source) {
        if (source == null) {
            return null;
        }

        return EnhancedEnum.enumByName(source);
    }

}
