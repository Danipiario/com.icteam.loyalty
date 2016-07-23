package com.icteam.loyalty.ui.internal;

import java.util.Date;

import org.eclipse.rap.rwt.RWT;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.menus.WorkbenchWindowControlContribution;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.Version;

import com.icteam.loyalty.api.Messages;

public class VersionStatusLine extends WorkbenchWindowControlContribution {

    @Override
    protected Control createControl(Composite parent) {
        CLabel label = new CLabel(parent, SWT.SHADOW_NONE);
        label.setData(RWT.MARKUP_ENABLED, true);
        label.setData(RWT.TOOLTIP_MARKUP_ENABLED, true);
        label.setTopMargin(3);
        label.setBottomMargin(9);

        Bundle bundle = FrameworkUtil.getBundle(VersionStatusLine.class);
        Date lastModified = new Date(bundle.getLastModified());
        Version version = bundle.getVersion();

        label.setText(Messages.getFormatted(Messages.get().version_status_line, version.toString()));
        label.setToolTipText(Messages.getFormatted(Messages.get().version_status_line_tooltip, lastModified));

        return label;
    }

}
