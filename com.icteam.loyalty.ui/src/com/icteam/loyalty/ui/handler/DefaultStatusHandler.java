package com.icteam.loyalty.ui.handler;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.ui.statushandlers.StatusAdapter;
import org.eclipse.ui.statushandlers.StatusManager;
import org.eclipse.ui.statushandlers.WorkbenchErrorHandler;
import org.eclipse.ui.statushandlers.WorkbenchStatusDialogManager;

import com.icteam.loyalty.api.AppException;
import com.icteam.loyalty.api.interfaces.IStatusReason;

public class DefaultStatusHandler extends WorkbenchErrorHandler {

    public static final String ID = "statushandler";

    @Override
    public void handle(StatusAdapter statusAdapter, int style) {
        Throwable exception = statusAdapter.getStatus().getException();

        exception.printStackTrace();

        if (exception instanceof AppException) {
            AppException e = (AppException) exception;
            IStatusReason statusReason = e.getStatusReason();

            statusAdapter.setStatus(new Status(IStatus.ERROR, statusReason.getPluginId(), statusReason.getCode(), e.getLocalizedMessage(), e));
        }

        super.handle(statusAdapter, StatusManager.BLOCK);
    }

    @Override
    protected void configureStatusDialog(WorkbenchStatusDialogManager statusDialog) {
        super.configureStatusDialog(statusDialog);

        statusDialog.enableDefaultSupportArea(false);
    }

}
