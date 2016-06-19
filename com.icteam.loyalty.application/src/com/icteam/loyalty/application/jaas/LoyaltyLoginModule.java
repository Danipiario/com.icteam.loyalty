package com.icteam.loyalty.application.jaas;

import java.util.Map;

import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.callback.TextOutputCallback;
import javax.security.auth.login.LoginException;

import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

import com.icteam.loyalty.application.Messages;
import com.icteam.loyalty.common.dto.OperatorDTO;
import com.icteam.loyalty.common.dto.OperatorLoginDTO;
import com.icteam.loyalty.common.service.AuthService;

public class LoyaltyLoginModule implements javax.security.auth.spi.LoginModule {

	private CallbackHandler callbackHandler;
	private boolean loggedIn = true;
	private Subject subject;
	private OperatorDTO operatorDTO;

	public LoyaltyLoginModule() {
	}

	@Override
	public void initialize(Subject subject, CallbackHandler callbackHandler, Map<String, ?> sharedState,
			Map<String, ?> options) {
		this.subject = subject;
		this.callbackHandler = callbackHandler;

	}

	@Override
	public boolean login() throws LoginException {
		final Callback label = new TextOutputCallback(TextOutputCallback.INFORMATION, Messages.get().need_login);
		final NameCallback nameCallback = new NameCallback(Messages.get().login);
		final PasswordCallback passwordCallback = new PasswordCallback(Messages.get().password, false);
		try {
			callbackHandler.handle(new Callback[] { label, nameCallback, passwordCallback });
		} catch (final ThreadDeath death) {
			final LoginException loginException = new LoginException();
			loginException.initCause(death);
			throw loginException;
		} catch (final Exception exception) {
			final LoginException loginException = new LoginException();
			loginException.initCause(exception);
			throw loginException;
		}

		final String username = nameCallback.getName();
		String password = null;

		if (passwordCallback.getPassword() != null) {
			password = String.valueOf(passwordCallback.getPassword());
		}

		AuthService authService;
		ServiceTracker<AuthService, AuthService> serviceTracker = null;
		try {
			serviceTracker = new ServiceTracker<>(FrameworkUtil.getBundle(getClass()).getBundleContext(),
					AuthService.class, null);
			serviceTracker.open();
			authService = serviceTracker.waitForService(1000);

			final OperatorLoginDTO operatorTemplate = new OperatorLoginDTO();
			operatorTemplate.login = username;
			operatorTemplate.password = password;

			operatorDTO = authService.login(operatorTemplate);

			// operatorModel =
			// ChangePasswordCallbackHandler.checkChangePassword(operatorModel,
			// authService);

			loggedIn = operatorDTO != null;
		} catch (final InterruptedException e) {
			e.printStackTrace();
		} finally {
			if (serviceTracker != null) {
				serviceTracker.close();
			}
		}

		return loggedIn;
	}

	@Override
	public boolean commit() {
		subject.getPrincipals().add(operatorDTO);
		// subject.getPrivateCredentials().addAll(operatorModel.getOperatorGroupList());
		//
		// RWT.getUISession().setLocale(operatorModel.getLanguage().getLocale());

		return loggedIn;
	}

	@Override
	public boolean abort() {
		loggedIn = false;
		subject = null;
		operatorDTO = null;

		return true;
	}

	@Override
	public boolean logout() {
		loggedIn = false;
		subject = null;
		operatorDTO = null;

		return true;
	}
}
