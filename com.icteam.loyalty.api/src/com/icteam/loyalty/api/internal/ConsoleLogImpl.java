package com.icteam.loyalty.api.internal;

import org.osgi.service.log.LogEntry;
import org.osgi.service.log.LogListener;
import org.osgi.service.log.LogReaderService;

public class ConsoleLogImpl implements LogListener {

    private LogReaderService logReaderService;

    public void setLogReaderService(LogReaderService logReaderService) {
        this.logReaderService = logReaderService;
    }

    public void init() {
        logReaderService.addLogListener(this);
    }

    public void stop() {
        logReaderService.removeLogListener(this);
    }

    @Override
    public void logged(LogEntry log) {
        if (log.getMessage() != null) {
            System.out.println("[" + log.getBundle().getSymbolicName() + "] " + log.getMessage());
        }
    }
}