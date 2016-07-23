package com.icteam.loyalty.model.interfaces;

import com.icteam.loyalty.api.interfaces.ConverterClass;
import com.icteam.loyalty.api.interfaces.EnhancedEnum;
import com.icteam.loyalty.api.interfaces.PropertyClass;

/**
 * This source file was created by ICTeam S.P.A.
 * <p/>
 * The software must not be used nor reproduced in any form without ICTeam and customer authorization
 * <p/>
 * Project : LoyaltyActivator Customer : ICTeam
 * <p/>
 * Author : $Author: l.tomasini $ File : $HeadURL:
 * http://jolokia:1080/svn/ICTeam/Loyalty2.0/trunk/loyalty-interfaces/src/main/java/com/icteam/loyalty/interfaces/enums/EStatus.java $ Revision :
 * $Revision: 3127 $ Last Checkin: $Date: 2012-12-13 11:57:15 +0100(gio, 13 dic 2012) $
 */
@PropertyClass(translateAll = true)
@ConverterClass
public class EStatus extends EnhancedEnum<EStatus, String> {
    private static final long serialVersionUID = 5482967466841381266L;

    public static final EStatus ATTIVO = new EStatus("ATTIVO");
    public static final EStatus DISATTIVO = new EStatus("DISATTIVO");

    public EStatus(String name) {
        super(name);
    }

}