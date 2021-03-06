//package com.icteam.loyalty.application.handler;
//
//import javax.inject.Named;
//
//import org.eclipse.e4.core.di.annotations.Execute;
//import org.eclipse.e4.ui.model.application.ui.advanced.MPerspective;
//import org.eclipse.e4.ui.model.application.ui.basic.MWindow;
//import org.eclipse.e4.ui.workbench.modeling.EModelService;
//import org.eclipse.e4.ui.workbench.modeling.EPartService;
//
//public class PerspectiveSwitchHandler {
//
//	@Execute
//	public void switchPerspective(MWindow window,
//			EPartService partService,
//			EModelService modelService,
//			@Named("perspective_parameter") String perspectiveId) {
//		// use parameter to find perspectives
//		final List<MPerspective> perspectives = modelService.findElements(window,
//				perspectiveId, MPerspective.class, null);
//
//		// switch to perspective with the ID if found
//		if (!perspectives.isEmpty()) {
//			partService.switchPerspective(perspectives.get(0));
//		}
//	}
//}