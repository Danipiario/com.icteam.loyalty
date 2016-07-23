package com.icteam.loyalty.ui.listener;

import java.lang.ref.WeakReference;

import org.eclipse.core.databinding.observable.map.IMapChangeListener;
import org.eclipse.core.databinding.observable.map.MapChangeEvent;
import org.eclipse.jface.viewers.ColumnViewer;

import com.icteam.loyalty.ui.util.ControlUtils;

public class MapChangeListener implements IMapChangeListener {
    private final WeakReference<ColumnViewer> columnViewerRef;

    public MapChangeListener(ColumnViewer columnViewer) {
        this.columnViewerRef = new WeakReference<>(columnViewer);
    }

    @Override
    public void handleMapChange(MapChangeEvent event) {
        ControlUtils.pack(columnViewerRef.get());
    }
}