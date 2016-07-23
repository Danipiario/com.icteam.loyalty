package com.icteam.loyalty.api;

import com.icteam.loyalty.api.interfaces.IStatusReason;

public class AppException extends RuntimeException {

    private static final long serialVersionUID = 4572735358900050255L;
    private IStatusReason statusReason;
    private Object[] params;
    private boolean messageProvided = false;

    public AppException(String message) {
        this(message, null);
    }

    public AppException(String message, Exception e) {
        super(message, e);

        messageProvided = true;
    }

    public AppException(IStatusReason statusReason) {
        this(statusReason, (Exception) null, (Object[]) null);
    }

    public AppException(IStatusReason statusReason, Object... params) {
        this(statusReason, null, params);
    }

    public AppException(IStatusReason statusReason, Exception e) {
        this(statusReason, e, (Object[]) null);
    }

    public AppException(IStatusReason statusReason, Exception e, Object... params) {
        super(null, e);

        this.statusReason = statusReason;
        this.params = params;
    }

    @Override
    public String getLocalizedMessage() {
        if (messageProvided) {
            return getMessage();
        }

        String translateKey = Messages.get(statusReason.getClass(), statusReason.getKey());
        if (params != null) {
            return Messages.getFormatted(translateKey, params);
        }

        return translateKey;
    }

    public IStatusReason getStatusReason() {
        return statusReason;
    }

}
