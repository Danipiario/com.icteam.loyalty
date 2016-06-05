package com.icteam.loyalty.application.jaas;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.callback.TextOutputCallback;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

/**
 * Handles the callbacks to show a RCP/RAP UI for the LoginModule.
 */
public class LoginCallbackHandler extends AbstractLoginDialog {

	private static final long serialVersionUID = -6750340512732436920L;

	/**
	 * @wbp.parser.constructor
	 */
	public LoginCallbackHandler() {
		this(Display.getDefault().getActiveShell());
	}

	protected LoginCallbackHandler(Shell parentShell) {
		super(parentShell);
	}

	@Override
	protected Point getInitialSize() {
		return new Point(450, 300);
	}

	@Override
	protected void configureShell(Shell shell) {
		super.configureShell(shell);
		shell.setText("AuthMessages.get().login_title");
	}

	@Override
	protected Control createContents(Composite parent) {
		final Control control = super.createContents(parent);

		getButton(IDialogConstants.OK_ID);

		return control;
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		final Composite dialogarea = (Composite) super.createDialogArea(parent);
		dialogarea.setLayoutData(new GridData(GridData.FILL_BOTH));
		final Composite composite = new Composite(dialogarea, SWT.NONE);
		composite.setLayout(new GridLayout(2, false));
		createCallbackHandlers(composite);

		return composite;
	}

	private void createCallbackHandlers(Composite composite) {
		final Callback[] callbacks = getCallbacks();
		for (final Callback callback : callbacks) {
			if (callback instanceof TextOutputCallback) {
				createTextOutputHandler((TextOutputCallback) callback);
			} else if (callback instanceof NameCallback) {
				createNameHandler(composite, (NameCallback) callback);
			} else if (callback instanceof PasswordCallback) {
				createPasswordHandler(composite, (PasswordCallback) callback);
			}
		}
	}

	private static void createPasswordHandler(Composite composite, final PasswordCallback callback) {
		final Label label = new Label(composite, SWT.NONE);
		label.setText(callback.getPrompt());
		final Text passwordText = new Text(composite, SWT.SINGLE | SWT.LEAD | SWT.PASSWORD | SWT.BORDER);
		passwordText.addModifyListener(new ModifyListener() {
			private static final long serialVersionUID = 1L;

			@Override
			public void modifyText(ModifyEvent event) {
				callback.setPassword(passwordText.getText().toCharArray());
			}
		});
	}

	private static void createNameHandler(Composite composite, final NameCallback callback) {
		final Label label = new Label(composite, SWT.NONE);
		label.setText(callback.getPrompt());
		final Text loginText = new Text(composite, SWT.SINGLE | SWT.LEAD | SWT.BORDER);
		loginText.addModifyListener(new ModifyListener() {
			private static final long serialVersionUID = 1L;

			@Override
			public void modifyText(ModifyEvent event) {
				callback.setName(loginText.getText());
			}
		});

		loginText.setFocus();
	}

	private void createTextOutputHandler(TextOutputCallback callback) {
		final int messageType = callback.getMessageType();
		int dialogMessageType = IMessageProvider.NONE;
		switch (messageType) {
		case TextOutputCallback.INFORMATION:
			dialogMessageType = IMessageProvider.INFORMATION;
			break;
		case TextOutputCallback.WARNING:
			dialogMessageType = IMessageProvider.WARNING;
			break;
		case TextOutputCallback.ERROR:
			dialogMessageType = IMessageProvider.ERROR;
			break;
		}

		setMessage("\n", dialogMessageType);
		setMessage(callback.getMessage(), dialogMessageType);
	}

	@Override
	public void internalHandle() {
	}
}
