package com.icteam.loyalty.model;

// Generated 3-mar-2011 9.42.28 by Hibernate Tools 3.4.0.CR1

import java.io.Serializable;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.openjpa.persistence.jdbc.Strategy;

import com.icteam.loyalty.model.interfaces.Language;

/**
 * Dictionary generated by hbm2java
 */
@Entity
@Table(name = "DICTIONARY")
@Access(AccessType.FIELD)
public class DictionaryEMF implements Serializable {

    private static final long serialVersionUID = 7632567784091307779L;

    @Id
    @GeneratedValue
    @Column(name = "K_DICTIONARY", nullable = false)
    private Long kDictionary;

    @Column(name = "K_KEY", nullable = false)
    private String kKey;

    @Column(name = "LANGUAGE")
    @Strategy("com.icteam.loyalty.model.EnhancedEnumValueHandler")
    private Language language;

    @Column(name = "VALUE")
    private String value;

    public Long getkDictionary() {
        return kDictionary;
    }

    public void setkDictionary(Long kDictionary) {
        this.kDictionary = kDictionary;
    }

    public String getkKey() {
        return kKey;
    }

    /**
     * Setter per la variabile kKey.
     *
     * @param kKey
     *            il valore da assegnare alla variabile di tipo PsiType:String.
     */
    public void setkKey(String kKey) {
        this.kKey = kKey;
    }

    /**
     * @return il valore della variabile language di tipo PsiType:ELanguage.
     */
    public Language getLanguage() {
        return language;
    }

    /**
     * Setter per la variabile language.
     *
     * @param language
     *            il valore da assegnare alla variabile di tipo PsiType:ELanguage.
     */
    public void setLanguage(Language language) {
        this.language = language;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (kDictionary == null ? 0 : kDictionary.hashCode());
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
        DictionaryEMF other = (DictionaryEMF) obj;
        if (kDictionary == null) {
            if (other.kDictionary != null) {
                return false;
            }
        } else if (!kDictionary.equals(other.kDictionary)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Dictionary ["
                + (kDictionary != null ? "kDictionary=" + kDictionary + ", " : "")
                + (kKey != null ? "kKey=" + kKey + ", " : "")
                + (language != null ? "language=" + language + ", " : "")
                + (value != null ? "value=" + value : "")
                + "]";
    }

}
