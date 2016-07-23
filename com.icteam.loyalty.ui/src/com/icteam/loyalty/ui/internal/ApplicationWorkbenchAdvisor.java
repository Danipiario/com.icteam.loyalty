package com.icteam.loyalty.ui.internal;

import java.security.AccessController;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.security.auth.Subject;

import org.eclipse.core.runtime.CoreException;
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
import org.eclipse.ui.internal.statushandlers.StatusHandlerRegistry;
import org.eclipse.ui.services.IEvaluationService;
import org.eclipse.ui.statushandlers.AbstractStatusHandler;

import com.icteam.loyalty.model.interfaces.IPerspectiveProvider;
import com.icteam.loyalty.model.interfaces.Perspective;
import com.icteam.loyalty.ui.handler.DefaultStatusHandler;
import com.icteam.loyalty.ui.listener.PartListenerActivateEMFEditor;
import com.icteam.loyalty.ui.util.UIUtils;

public class ApplicationWorkbenchAdvisor extends WorkbenchAdvisor {

    DefaultStatusHandler defaultStatusHandler = new DefaultStatusHandler();

    boolean impersonate = false;

    public ApplicationWorkbenchAdvisor() {
        super();

        impersonate = UIUtils.isImpersonate();
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
        Subject subject = Subject.getSubject(AccessController.getContext());

        if (subject != null) {
            List<Perspective> perspectives = new ArrayList<>();

            for (Object credential : subject.getPrivateCredentials()) {
                if (credential instanceof IPerspectiveProvider) {
                    perspectives.add(((IPerspectiveProvider) credential).getDefaultPerspective());
                }
            }

            Collections.sort(perspectives);

            if (!perspectives.isEmpty()) {
                return perspectives.get(0).getId();
            }
        }

        return null;
    }

    @Override
    public synchronized AbstractStatusHandler getWorkbenchErrorHandler() {
        try {
            return StatusHandlerRegistry.getDefault().getHandlerDescriptor(DefaultStatusHandler.ID).getStatusHandler();
        } catch (CoreException e) {
            e.printStackTrace();
            return super.getWorkbenchErrorHandler();
        }
    }

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
            IWorkbenchWindowConfigurer configurer = getWindowConfigurer();

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
            Shell shell = getWindowConfigurer().getWindow().getShell();
            shell.setMaximized(true);

            getWindowConfigurer().getWindow().getPartService().addPartListener(new PartListenerActivateEMFEditor());
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
            IWorkbench workbench = PlatformUI.getWorkbench();
            if (workbench != null) {
                IEvaluationService evaluationService = (IEvaluationService) PlatformUI.getWorkbench().getService(IEvaluationService.class);

                evaluationService.requestEvaluation("org.eclipse.ui.workbenchWindow.isPerspectiveOpen");
                evaluationService.requestEvaluation("activeWorkbenchWindow.activePerspective");
            }
        }
    }
}
