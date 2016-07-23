package com.icteam.loyalty.model;

import javax.persistence.Id;

import org.kahvi.paketti.dtobuilder.annotations.DtoClass;

import com.google.gson.annotations.Expose;
import com.icteam.loyalty.api.interfaces.Property;
import com.icteam.loyalty.api.interfaces.PropertyClass;
import com.icteam.loyalty.model.interfaces.EStatusReason;
import com.icteam.loyalty.model.interfaces.Required;

/**
 * Operator generated by hbm2java
 */
@DtoClass(sourceClasses = Result.class)
@PropertyClass(translateAll = true)
public class ResultDto extends DtoModel {

    private static final long serialVersionUID = 5908081444350053534L;

    @Property(order = 1)
    @Expose
    private EStatusReason statusReason;

    @Property(order = 2)
    @Expose
    private String exception;

    public ResultDto() {
        super();
    }

    public ResultDto(EStatusReason statusReason) {
        super();

        this.statusReason = statusReason;
    }

    @Override
    public String getDtoName() {
        return getStatusReason().name();
    }

    @Id
    @Required
    public EStatusReason getStatusReason() {
        return statusReason;
    }

    public void setStatusReason(EStatusReason statusReason) {
        firePropertyChange("statusReason", this.statusReason, this.statusReason = statusReason);
    }

    @Required
    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        firePropertyChange("exception", this.exception, this.exception = exception);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (statusReason == null ? 0 : statusReason.hashCode());
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
        ResultDto other = (ResultDto) obj;
        if (statusReason == null) {
            if (other.statusReason != null) {
                return false;
            }
        } else if (!statusReason.equals(other.statusReason)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return statusReason + (exception != null ? ":" + exception : "");
    }

}
