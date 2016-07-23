package com.icteam.loyalty.api.interfaces;

import java.io.Serializable;

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
 * File        : $HeadURL: http://jolokia:1080/svn/ICTeam/Loyalty2.0/trunk/loyalty-interfaces/src/main/java/com/icteam/loyalty/interfaces/ISelectable.java $
 * Revision    : $Revision: 3092 $
 * Last Checkin: $Date: 2012-12-11 17:17:53 +0100(mar, 11 dic 2012) $
 */
public interface ISelectable<S extends Serializable> extends Serializable {
    /**
     * Ritorna la chiave
     *
     * @return chiave
     */
    S getKey();

    /**
     * Ritorna la descrizione
     *
     * @return descrizione
     */
    String getDescription();
}
