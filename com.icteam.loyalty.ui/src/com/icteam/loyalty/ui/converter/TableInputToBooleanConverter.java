package com.icteam.loyalty.ui.converter;

import java.lang.ref.WeakReference;

import org.eclipse.core.databinding.conversion.Converter;
import org.eclipse.jface.viewers.TableViewer;

public class TableInputToBooleanConverter extends Converter {

    private final WeakReference<TableViewer> tableViewer;

    public TableInputToBooleanConverter(TableViewer tableViewer) {
        super(boolean.class, boolean.class);
        this.tableViewer = new WeakReference<>(tableViewer);
    }

    @Override
    public Object convert(Object fromObject) {
        boolean empty = (boolean) fromObject;
        if (empty) {
            return false;
        }

        return !(tableViewer.get().getTable().getItemCount() == 0);
    }
}