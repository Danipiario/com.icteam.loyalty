package com.icteam.loyalty.ui.internal;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.eclipse.rap.rwt.RWT;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.menus.WorkbenchWindowControlContribution;

import com.icteam.loyalty.api.Messages;

public class DatabaseStatusLine extends WorkbenchWindowControlContribution {

    private static DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        DatabaseStatusLine.dataSource = dataSource;
    }

    @Override
    protected Control createControl(Composite parent) {
        CLabel label = new CLabel(parent, SWT.SHADOW_NONE);
        label.setData(RWT.MARKUP_ENABLED, true);
        label.setData(RWT.TOOLTIP_MARKUP_ENABLED, true);
        label.setTopMargin(3);
        label.setBottomMargin(9);

        Connection connection = null;

        try {
            connection = dataSource.getConnection();

            String schema = connection.getMetaData().getUserName();
            String database = connection.getMetaData().getDatabaseProductName();
            String databaseVersion = connection.getMetaData().getDatabaseProductVersion();
            String databaseURL = connection.getMetaData().getURL();

            label.setText(Messages.getFormatted(Messages.get().database_status_line, database, schema));
            label.setToolTipText(Messages.getFormatted(Messages.get().database_status_line_tooltip, databaseVersion, databaseURL));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    // nothing to do
                }
            }
        }

        return label;
    }

}
