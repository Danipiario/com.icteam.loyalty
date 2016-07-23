package com.icteam.loyalty.model;

import com.google.gson.annotations.Expose;
import com.icteam.loyalty.model.interfaces.EStatusReason;

public class Result extends DbModel<ResultDto> {

    private static final long serialVersionUID = -1229546764851673588L;

    @Expose
    private EStatusReason statusReason;
    @Expose
    private String exception;

    public EStatusReason getStatusReason() {
        return statusReason;
    }

    public void setStatusReason(EStatusReason statusReason) {
        this.statusReason = statusReason;
    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }

    @Override
    public String toString() {
        return "Result ["
                + (statusReason != null ? "statusReason=" + statusReason + ", " : "")
                + (exception != null ? "exception=" + exception : "")
                + "]";
    }

}
