package com.icteam.loyalty.application.jaas;

import java.util.Map;

import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.callback.TextOutputCallback;
import javax.security.auth.login.LoginException;

import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

import com.icteam.loyalty.application.internal.Messages;
import com.icteam.loyalty.common.dto.OperatorDTO;
import com.icteam.loyalty.common.dto.OperatorLoginDTO;
import com.icteam.loyalty.common.service.AuthService;
import com.icteam.loyalty.common.service.DTOService;

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

		ServiceTracker<AuthService, AuthService> authServiceTracker = null;
		ServiceTracker<DTOService, DTOService> dtoServiceTracker = null;
		try {
			BundleContext bundleContext = FrameworkUtil.getBundle(getClass()).getBundleContext();
			authServiceTracker = new ServiceTracker<>(bundleContext, AuthService.class.getName(), null);
			authServiceTracker.open();

			AuthService authService = authServiceTracker.waitForService(1000);

			if (authService != null) {
				dtoServiceTracker = new ServiceTracker<>(bundleContext, DTOService.class, null);
				dtoServiceTracker.open();

				DTOService dtoService = dtoServiceTracker.waitForService(1000);
				if (dtoService != null) {

					final OperatorLoginDTO operatorTemplate = dtoService.newDTO(OperatorLoginDTO.class, true);
					operatorTemplate.setLogin(username);
					operatorTemplate.setPassword(password);

					operatorDTO = authService.login(operatorTemplate);

					// operatorModel =
					// ChangePasswordCallbackHandler.checkChangePassword(operatorModel,
					// authService);
				}
			}

			loggedIn = operatorDTO != null;
		} catch (final InterruptedException e) {
			e.printStackTrace();
		} finally {
			if (authServiceTracker != null) {
				authServiceTracker.close();
			}
			if (dtoServiceTracker != null) {
				dtoServiceTracker.close();
			}
		}

		return loggedIn;
	}

	@Override
	public boolean commit() {
		subject.getPrincipals().add(operatorDTO);
		// subject.getPrivateCredentials().addAll(operatorDTO.getGroups());

		// RWT.getUISession().setLocale(operatorDTO.getLanguage().getLocale());

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
