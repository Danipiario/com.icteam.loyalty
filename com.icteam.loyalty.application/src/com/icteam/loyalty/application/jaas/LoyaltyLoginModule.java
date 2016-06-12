package com.icteam.loyalty.application.jaas;

import java.util.Map;

import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.callback.TextOutputCallback;
import javax.security.auth.login.LoginException;

import com.icteam.loyalty.application.Messages;

public class LoyaltyLoginModule implements javax.security.auth.spi.LoginModule {

	private CallbackHandler callbackHandler;
	private boolean loggedIn = true;
	private Subject subject;
	// private OperatorEMFModel operatorEMFModel;

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

		nameCallback.getName();
		if (passwordCallback.getPassword() != null) {
			String.valueOf(passwordCallback.getPassword());
		}

		// AuthEMFService authService;
		// ServiceTracker<AuthEMFService, AuthEMFService> serviceTracker = null;
		// try {
		// serviceTracker = new
		// ServiceTracker<>(FrameworkUtil.getBundle(getClass()).getBundleContext(),
		// AuthEMFService.class, null);
		// serviceTracker.open();
		// authService = serviceTracker.waitForService(1000);
		//
		// final OperatorEMFTemplate operatorTemplate =
		// AuthTemplateFactory.eINSTANCE.createOperatorEMFTemplate();
		// operatorTemplate.setLogin(username);
		// operatorTemplate.setPassword(password);
		// operatorTemplate.setStatus(ModelUtil.valueOf(Status.class,
		// ModelInterfacesPackage.Literals.STATUS__ATTIVO.getName()));
		//
		// operatorEMFModel = authService.login(operatorTemplate);
		//
		// operatorEMFModel =
		// ChangePasswordCallbackHandler.checkChangePassword(operatorEMFModel,
		// authService);
		//
		// loggedIn = operatorEMFModel != null;
		// } catch (final InterruptedException e) {
		// e.printStackTrace();
		// } finally {
		// serviceTracker.close();
		// }

		return loggedIn;
	}

	@Override
	public boolean commit() {
		// subject.getPrincipals().add(operatorEMFModel);
		// subject.getPrivateCredentials().addAll(operatorEMFModel.getOperatorGroupList());
		//
		// RWT.getUISession().setLocale(operatorEMFModel.getLanguage().getLocale());

		return loggedIn;
	}

	@Override
	public boolean abort() {
		loggedIn = false;
		subject = null;
		// operatorEMFModel = null;

		return true;
	}

	@Override
	public boolean logout() {
		loggedIn = false;
		subject = null;
		// operatorEMFModel = null;

		return true;
	}
}
