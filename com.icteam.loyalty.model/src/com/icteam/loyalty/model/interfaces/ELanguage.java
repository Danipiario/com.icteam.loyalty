package com.icteam.loyalty.model.interfaces;

import java.util.Locale;

import com.icteam.loyalty.api.interfaces.ConverterClass;
import com.icteam.loyalty.api.interfaces.EnhancedEnum;
import com.icteam.loyalty.api.interfaces.Property;
import com.icteam.loyalty.api.interfaces.PropertyClass;

/**
 * This source file was created by ICTeam S.P.A.
 * <p/>
 * The software must not be used nor reproduced in any form without ICTeam and customer authorization
 * <p/>
 * Project : altyActivator Customer : ICTeam
 * <p/>
 * Author : $Author: d.pirola $ File : $HeadURL:
 * http://jolokia:1080/svn/ICTeam/Loyalty2.0/trunk/loyalty-interfaces/src/main/java/com/icteam/loyalty/interfaces/enums/ELanguage.java $ Revision :
 * $Revision: 3770 $ Last Checkin: $Date: 2013-03-20 13:05:58 +0100(mer, 20 mar 2013) $
 */
@PropertyClass(translateAll = true)
@ConverterClass
public class ELanguage extends EnhancedEnum<ELanguage, String> {

    private static final long serialVersionUID = 5759960918171633063L;

    // inserire come prima lingua quella di default e poi le altre nell'ordine desiderato
    public static final ELanguage ITALIAN = new ELanguage("ITALIAN", Locale.ITALY, true);
    public static final ELanguage ENGLISH = new ELanguage("ENGLISH", Locale.UK, false);

    @Property(translatable = false)
    private final boolean defaultLanguage;
    @Property(translatable = false)
    private final Locale locale;

    /**
     * Costruttore
     *
     * @param locale
     *            Locale
     * @param defaultLanguage
     *            se e' la default language
     */
    public ELanguage(String name, Locale locale, boolean defaultLanguage) {
        super(name);

        this.locale = locale;
        this.defaultLanguage = defaultLanguage;
    }

    /**
     * @return il valore della variabile locale di tipo PsiType:Locale.
     */
    public Locale getLocale() {
        return locale;
    }

    /**
     * @return il valore della variabile defaultLanguage di tipo PsiType:boolean.
     */
    public boolean isDefaultLanguage() {
        return defaultLanguage;
    }

    /**
     * Ritorna ELanguage dal Locale
     *
     * @param locale
     *            Locale
     * @return ELanguage
     */
    public static ELanguage getLanguage(Locale locale) {
        for (ELanguage language : EnhancedEnum.values(ELanguage.class)) {
            if (language.getLocale().equals(locale)) {
                return language;
            }
        }

        return null;
    }

    /**
     * @return il valore della variabile defaultLanguage di tipo PsiType:ELanguage.
     */
    public static ELanguage getDefaultLanguage() {
        for (ELanguage language : EnhancedEnum.values(ELanguage.class)) {
            if (language.isDefaultLanguage()) {
                return language;
            }
        }

        return null;
    }
}
