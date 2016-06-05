package com.icteam.loyalty.application.internal;

import java.security.AccessController;

import javax.security.auth.Subject;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IPerspectiveDescriptor;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPreferenceConstants;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PerspectiveAdapter;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;
import org.eclipse.ui.application.IWorkbenchConfigurer;
import org.eclipse.ui.application.IWorkbenchWindowConfigurer;
import org.eclipse.ui.application.WorkbenchAdvisor;
import org.eclipse.ui.application.WorkbenchWindowAdvisor;
import org.eclipse.ui.internal.IPreferenceConstants;
import org.eclipse.ui.internal.WorkbenchPlugin;
import org.eclipse.ui.services.IEvaluationService;

public class LoyaltyWorkbenchAdvisor extends WorkbenchAdvisor {

	//	DefaultStatusHandler defaultStatusHandler = new DefaultStatusHandler();

	boolean impersonate = false;

	public LoyaltyWorkbenchAdvisor() {
		super();

		//		impersonate = UIUtils.isImpersonate();
	}

	@Override
	public WorkbenchWindowAdvisor createWorkbenchWindowAdvisor(IWorkbenchWindowConfigurer configurer) {
		return new ApplicationWorkbenchWindowAdvisor(configurer);
	}

	@Override
	public void initialize(IWorkbenchConfigurer configurer) {
		super.initialize(configurer);

		configurer.setSaveAndRestore(!impersonate);
	}

	@Override
	public String getInitialWindowPerspectiveId() {
		final Subject subject = Subject.getSubject(AccessController.getContext());

		if (subject != null) {
			//			final List<Perspective> perspectives = new ArrayList<>();
			//
			//			for (final Object credential : subject.getPrivateCredentials()) {
			//				if (credential instanceof IPerspectiveProvider) {
			//					perspectives.add(((IPerspectiveProvider) credential).getDefaultPerspective());
			//				}
			//			}
			//
			//			Collections.sort(perspectives);
			//
			//			if (!perspectives.isEmpty()) {
			//				return perspectives.get(0).getId();
			//			}
		}

		return null;
	}

	//	@Override
	//	public synchronized AbstractStatusHandler getWorkbenchErrorHandler() {
	//		try {
	//			return StatusHandlerRegistry.getDefault().getHandlerDescriptor(DefaultStatusHandler.ID).getStatusHandler();
	//		} catch (final CoreException e) {
	//			e.printStackTrace();
	//			return super.getWorkbenchErrorHandler();
	//		}
	//	}

	class ApplicationActionBarAdvisor extends ActionBarAdvisor {
		public ApplicationActionBarAdvisor(IActionBarConfigurer configurer) {
			super(configurer);
		}

		@Override
		protected void fillMenuBar(IMenuManager menuBar) {
			super.fillMenuBar(menuBar);

			// menuBar.add(new ExitAction());
		}

		@Override
		protected void makeActions(IWorkbenchWindow window) {
			register(ActionFactory.RESET_PERSPECTIVE.create(window));

			super.makeActions(window);
		}
	}

	class ApplicationWorkbenchWindowAdvisor extends WorkbenchWindowAdvisor {
		public ApplicationWorkbenchWindowAdvisor(IWorkbenchWindowConfigurer configurer) {
			super(configurer);
		}

		@Override
		public ActionBarAdvisor createActionBarAdvisor(IActionBarConfigurer configurer) {
			return new ApplicationActionBarAdvisor(configurer);
		}

		@Override
		public void preWindowOpen() {
			final IWorkbenchWindowConfigurer configurer = getWindowConfigurer();

			configurer.setShowFastViewBars(true);
			configurer.setShellStyle(SWT.NO_TRIM);
			configurer.setShowCoolBar(false);
			configurer.setShowMenuBar(true);
			configurer.setShowStatusLine(true);
			configurer.setShowProgressIndicator(false);
			configurer.setShowPerspectiveBar(true);
			configurer.setTitle("Loyalty");

			configurer.getWindow().addPerspectiveListener(new ReEvaluationPerspectiveListener());

			IPreferenceStore preferenceStore = PlatformUI.getPreferenceStore();
			preferenceStore.setValue(IWorkbenchPreferenceConstants.SHOW_TEXT_ON_PERSPECTIVE_BAR, false);
			preferenceStore.setValue(IWorkbenchPreferenceConstants.DOCK_PERSPECTIVE_BAR, IWorkbenchPreferenceConstants.LEFT);

			preferenceStore = WorkbenchPlugin.getDefault().getPreferenceStore();
			preferenceStore.setValue(IPreferenceConstants.RUN_IN_BACKGROUND, true);
		}

		@Override
		public void postWindowCreate() {
			final Shell shell = getWindowConfigurer().getWindow().getShell();
			shell.setMaximized(true);

			//			getWindowConfigurer().getWindow().getPartService().addPartListener(new PartListenerActivateEMFEditor());
		}
	}

	class ReEvaluationPerspectiveListener extends PerspectiveAdapter {
		@Override
		public void perspectiveActivated(IWorkbenchPage page, IPerspectiveDescriptor perspective) {
			forceReevaluation();
		}

		@Override
		public void perspectiveClosed(IWorkbenchPage page, IPerspectiveDescriptor perspective) {
			forceReevaluation();
		}

		protected void forceReevaluation() {
			final IWorkbench workbench = PlatformUI.getWorkbench();
			if (workbench != null) {
				final IEvaluationService evaluationService = PlatformUI.getWorkbench().getService(IEvaluationService.class);

				evaluationService.requestEvaluation("org.eclipse.ui.workbenchWindow.isPerspectiveOpen");
				evaluationService.requestEvaluation("activeWorkbenchWindow.activePerspective");
			}
		}
	}
}
