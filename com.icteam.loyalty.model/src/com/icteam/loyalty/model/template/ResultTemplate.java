package com.icteam.loyalty.model.template;

import com.icteam.loyalty.api.interfaces.Property;
import com.icteam.loyalty.api.interfaces.PropertyClass;
import com.icteam.loyalty.model.Result;
import com.icteam.loyalty.model.interfaces.EStatusReason;
import com.icteam.loyalty.model.interfaces.Where;

/**
 * OperatorTemplate
 */
@PropertyClass
public class ResultTemplate extends AbstractTemplate<Result> {

    @Where
    @Property(order = 1)
    private EStatusReason statusReason;

    public EStatusReason getStatusReason() {
        return statusReason;
    }

    public void setStatusReason(EStatusReason statusReason) {
        this.statusReason = statusReason;
    }

    @Override
    public String toString() {
        return "ResultTemplate [" + (statusReason != null ? "statusReason=" + statusReason : "") + "]";
    }

}
