package com.icteam.loyalty.application.jaas;

import java.io.IOException;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.operation.ModalContext;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public abstract class AbstractLoginDialog extends TitleAreaDialog implements CallbackHandler {

	private static final long serialVersionUID = 5119118901261806978L;

	boolean processCallbacks = false;
	boolean isCancelled = false;
	Callback[] callbackArray;

	protected final Callback[] getCallbacks() {
		return this.callbackArray;
	}

	public abstract void internalHandle();

	protected boolean checkInput() {
		return true;
	}

	public boolean isCancelled() {
		return isCancelled;
	}

	protected AbstractLoginDialog(Shell parentShell) {
		super(parentShell);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * javax.security.auth.callback.CallbackHandler#handle(javax.security.auth
	 * .callback.Callback[])
	 */
	@Override
	public void handle(final Callback[] callbacks) throws IOException {
		this.callbackArray = callbacks;
		final Display display = Display.getDefault();
		display.syncExec(() -> {
			isCancelled = false;
			setBlockOnOpen(false);
			open();
			@SuppressWarnings("synthetic-access")
			final
			Button okButton = getButton(IDialogConstants.OK_ID);
			okButton.setText("Login");
		});
		try {
			ModalContext.setAllowReadAndDispatch(true); // Works for now.
			ModalContext.run(monitor -> {
				// Wait here until OK or cancel is pressed, then let it rip. The event
				// listener
				// is responsible for closing the dialog (in the loginSucceeded
				// event).
				while (!processCallbacks) {
					try {
						Thread.sleep(100);
					} catch (final Exception e) {
						// do nothing
					}
				}
				processCallbacks = false;
				// Call the adapter to handle the callbacks
				if (!isCancelled()) {
					internalHandle();
				}
			}, true, new NullProgressMonitor(), Display.getDefault());
		} catch (final Exception e) {
			final IOException ioe = new IOException();
			ioe.initCause(e);
			throw ioe;
		}
	}

	@Override
	protected void okPressed() {
		if (checkInput()) {
			processCallbacks = true;

			super.okPressed();
		}
	}

	@Override
	protected void cancelPressed() {
		isCancelled = true;
		processCallbacks = true;

		super.cancelPressed();
	}

}
