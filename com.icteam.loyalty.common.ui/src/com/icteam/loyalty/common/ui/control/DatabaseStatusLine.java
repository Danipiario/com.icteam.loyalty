package com.icteam.loyalty.common.ui.control;

import java.sql.Connection;
import java.sql.SQLException;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.sql.DataSource;

import org.eclipse.e4.ui.model.application.ui.menu.MToolControl;
import org.eclipse.rap.rwt.RWT;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.widgets.Composite;

import com.icteam.loyalty.common.nls.Messages;
import com.icteam.loyalty.common.nls.NLS;

public class DatabaseStatusLine {

	@Inject
	private DataSource dataSource;

	/**
	 * @param control
	 */
	@PostConstruct
	void createControl(Composite parent, MToolControl control) {
		final CLabel label = new CLabel(parent, SWT.SHADOW_NONE);
		label.setData(RWT.MARKUP_ENABLED, true);
		label.setData(RWT.TOOLTIP_MARKUP_ENABLED, true);
		label.setTopMargin(3);
		label.setBottomMargin(9);

		Connection connection = null;

		try {
			connection = dataSource.getConnection();

			final String schema = connection.getMetaData().getUserName();
			final String database = connection.getMetaData().getDatabaseProductName();
			final String databaseVersion = connection.getMetaData().getDatabaseProductVersion();
			final String databaseURL = connection.getMetaData().getURL();

			label.setText(NLS.getFormatted(Messages.get().databaseStatusLine, database, schema));
			label.setToolTipText(
					NLS.getFormatted(Messages.get().databaseStatusLineTooltip, databaseVersion, databaseURL));
		} catch (final SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (final SQLException e) {
					// nothing to do
				}
			}
		}
	}

}
