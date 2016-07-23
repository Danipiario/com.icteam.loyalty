package com.icteam.loyalty.model;

import aQute.bnd.annotation.metatype.Meta.AD;
import aQute.bnd.annotation.metatype.Meta.OCD;

@OCD(name = "Loyalty Api Configuration", id = "com.icteam.loyalty.model", description = "Parametri di configurazione globali dell'intera applicazione")
public interface ModelConfiguration {

    @AD(deflt = "1500", required = false, min = "0", max = "3000", description = "Tempo in millisecondi per la visualizzazione dei tooltip di warning")
    int tooltipShowTimeMillis();

    @AD(deflt = "3", required = false, min = "2", description = "Numero minimo di caratteri per effettuare la ricerca nei campi tradotti")
    int minSearchCharacterI18N();

    @AD(deflt = "100", required = false, max = "1000", description = "Numero massimo di elementi che si possono inserire in una clausola IN all'interno di una query. Utilizzato nelle query con campi tradotti")
    int inClauseMaxLength();
}
