/*******************************************************************************
 * Copyright (c) 2012 Joseph Carroll and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Joseph Carroll <jdsalingerjr@gmail.com> - initial API and implementation
 ******************************************************************************/
package org.eclipse.e4.ui.workbench.perspectiveswitcher.tools;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;

import org.eclipse.core.commands.ParameterizedCommand;
import org.eclipse.e4.core.commands.ECommandService;
import org.eclipse.e4.core.commands.EHandlerService;
import org.eclipse.e4.core.di.extensions.Preference;
import org.eclipse.e4.core.services.log.Logger;
import org.eclipse.e4.ui.model.application.ui.MElementContainer;
import org.eclipse.e4.ui.model.application.ui.SideValue;
import org.eclipse.e4.ui.model.application.ui.advanced.MPerspective;
import org.eclipse.e4.ui.model.application.ui.advanced.MPerspectiveStack;
import org.eclipse.e4.ui.model.application.ui.basic.MTrimBar;
import org.eclipse.e4.ui.model.application.ui.basic.MWindow;
import org.eclipse.e4.ui.model.application.ui.menu.MToolControl;
import org.eclipse.e4.ui.workbench.IResourceUtilities;
import org.eclipse.e4.ui.workbench.UIEvents;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.e4.ui.workbench.perspectiveswitcher.E4WorkbenchMessages;
import org.eclipse.e4.ui.workbench.perspectiveswitcher.commands.E4WorkbenchCommandConstants;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.accessibility.AccessibleEvent;
import org.eclipse.swt.accessibility.AccessibleListener;
import org.eclipse.swt.events.MenuEvent;
import org.eclipse.swt.events.MenuListener;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;

import com.icteam.loyalty.common.ui.service.IconService;

public class PerspectiveSwitcherSwtTrim implements IPerspectiveSwitcherControl {

	@Inject
	private Logger logger;

	@Inject
	private EModelService modelService;

	@Inject
	private EPartService partService;

	@Inject
	private ECommandService commandService;

	@Inject
	private EHandlerService handlerService;

	@Inject
	private IResourceUtilities<?> resourceUtilities;

	@Inject
	private MWindow window;

	@Inject
	private IconService iconService;

	@Inject
	EPerspectiveSwitcher perspectiveSwitcher;

	// TODO: set instance property for the previously active perspective
	// keep the order for all open perspectives

	//
	Composite composite;
	ToolBar toolBar;

	//
	@Inject
	@Preference(value = E4PerspectiveSwitcherPreferences.SHOW_TEXT, nodePath = E4PerspectiveSwitcherPreferences.ROOT_PREFERENCES_NODE)
	private boolean showShortcutText;
	static String _null = ""; //$NON-NLS-1$

	//
	static RGB defaultContainerCurveColor = new RGB(0, 0, 0);
	Image openPerspectiveImage;
	Color internalCrvColor;

	// CSS Styles
	Color containerCurveColor;

	@PreDestroy
	void cleanUp() {
		if (perspectiveSwitcher != null) {
			perspectiveSwitcher.setControlProvider(null);
		}
		perspectiveSwitcher = null;

		disposeToolBarImages();
		dispose();
	}

	@PostConstruct
	void createControl(Composite parent, MToolControl control) {
		perspectiveSwitcher.setControlProvider(this);
		composite = new Composite(parent, SWT.None);

		int align = SWT.HORIZONTAL;

		final MElementContainer<?> trimControl = control.getParent();
		if (trimControl instanceof MTrimBar) {
			if (((MTrimBar) trimControl).getSide().equals(SideValue.LEFT)
					|| ((MTrimBar) trimControl).getSide().equals(SideValue.RIGHT)) {
				align = SWT.VERTICAL;
			}
		}

		final RowLayout rowLayout = new RowLayout(align);
		rowLayout.marginLeft = rowLayout.marginRight = 4;
		rowLayout.marginTop = 4;
		rowLayout.marginBottom = 4;
		composite.setLayout(rowLayout);

		// composite.addListener(SWT.Paint, new TypedListener((PaintListener)
		// event -> paintContainer(event)));

		composite.addDisposeListener(event -> dispose());

		toolBar = new ToolBar(composite, SWT.FLAT | SWT.WRAP | SWT.RIGHT | align);

		toolBar.addMenuDetectListener(event -> {
			final ToolBar tb = (ToolBar) event.widget;
			Point p = new Point(event.x, event.y);

			p = toolBar.getDisplay().map(null, toolBar, p);
			final ToolItem item = tb.getItem(p);
			if (item != null && item.getData() != null) {
				openMenuFor(item, (MPerspective) item.getData());
			} else if (item == null) {
				logger.debug("No item found");
			} else {
				logger.debug("Perspective not associated with item");
			}
		});

		toolBar.addDisposeListener(event -> disposeToolBarImages());

		// TODO: Implement accessibility features & I10n
		toolBar.getAccessible().addAccessibleListener(new AccessibleListener() {

			@Override
			public void getName(AccessibleEvent e) {

			}

			@Override
			public void getKeyboardShortcut(AccessibleEvent e) {

			}

			@Override
			public void getHelp(AccessibleEvent e) {

			}

			@Override
			public void getDescription(AccessibleEvent e) {

			}
		});

		final ToolItem perspectiveDialog = new ToolItem(toolBar, SWT.PUSH);
		perspectiveDialog.setImage(getOpenPerspectiveImage());
		perspectiveDialog.setToolTipText(E4WorkbenchMessages.get().openSelectPerspectiveWindow);
		perspectiveDialog.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent event) {
				openPerspectiveDialog();
			}
		});

		// The separator
		new ToolItem(toolBar, SWT.SEPARATOR);

		// The perspectives currently open
		final List<MPerspectiveStack> appPerspectiveStacks = E4Util.getMatchingChildren(window,
				MPerspectiveStack.class);
		if (appPerspectiveStacks.size() > 0) {
			for (final MPerspectiveStack stack : appPerspectiveStacks) {
				for (final MPerspective perspective : stack.getChildren()) {
					if (perspective.isToBeRendered()) {
						addPerspectiveShortcut(perspective);
					}
				}
			}
		}
	}

	/*
	 * void paintContainer(PaintEvent event) { final GC gc = event.gc;
	 * gc.setAdvanced(true); if (gc.getAdvanced()) { gc.setAntialias(SWT.ON); }
	 *
	 * final Point size = composite.getSize(); final int h = size.y; final int[]
	 * simpleCurve = new int[] { 0, h - 1, 1, h - 1, 2, h - 2, 2, 1, 3, 0 };
	 *
	 * gc.setForeground(getContainerCurveColor(event));
	 * gc.drawPolyline(simpleCurve);
	 *
	 * final Rectangle bounds = ((Control) event.widget).getBounds(); bounds.x =
	 * bounds.y = 0; final Region r = new Region(); r.add(bounds);
	 *
	 * final int[] simpleCurveClose = new int[simpleCurve.length + 4];
	 * System.arraycopy(simpleCurve, 0, simpleCurveClose, 0,
	 * simpleCurve.length); int index = simpleCurve.length;
	 * simpleCurveClose[index++] = bounds.width; simpleCurveClose[index++] = 0;
	 * simpleCurveClose[index++] = bounds.width; simpleCurveClose[index++] =
	 * bounds.height;
	 *
	 * r.subtract(simpleCurveClose);
	 *
	 * final Region clipping = new Region(); gc.getClipping(clipping);
	 * r.intersect(clipping); gc.setClipping(r);
	 *
	 * clipping.dispose(); r.dispose(); }
	 */
	void openMenuFor(ToolItem item, MPerspective perspective) {
		final Menu menu = new Menu(toolBar);
		menu.setData(perspective);

		if (E4Util.isSelectedElement(perspective)) {
			addSaveAsMenuItem(menu);
			addResetMenuItem(menu);
		}

		if (perspective.isVisible()) {
			addCloseMenuItem(menu);
		}

		new MenuItem(menu, SWT.SEPARATOR);

		addShowTextMenuItem(menu);

		final Rectangle bounds = item.getBounds();
		final Point point = toolBar.toDisplay(bounds.x, bounds.y + bounds.height);
		menu.setLocation(point);
		menu.setVisible(true);
		menu.addMenuListener(new MenuListener() {

			@Override
			public void menuShown(MenuEvent e) {
				// do nothing
			}

			@Override
			public void menuHidden(MenuEvent e) {
				toolBar.getDisplay().asyncExec(() -> menu.dispose());
			}
		});
	}

	void openPerspectiveDialog() {
		final ParameterizedCommand command = commandService
				.createCommand(E4WorkbenchCommandConstants.PERSPECTIVES_SHOW_PERSPECTIVE, Collections.EMPTY_MAP);
		handlerService.executeHandler(command);
	}

	@Override
	public void addPerspectiveShortcut(MPerspective perspective) {
		final ToolItem shortcut = new ToolItem(toolBar, SWT.RADIO);
		shortcut.setData(perspective);

		final ImageDescriptor descriptor = getIconFor(perspective.getIconURI());

		if (descriptor != null) {
			final Image icon = descriptor.createImage();
			shortcut.setImage(icon);
		}

		if (descriptor == null || showShortcutText) {
			final String label = perspective.getLocalizedLabel();
			shortcut.setText(label != null ? label : _null);
			shortcut.setToolTipText(perspective.getLocalizedTooltip());
		} else {
			shortcut.setText(_null);
			shortcut.setToolTipText(perspective.getLocalizedLabel());
		}

		shortcut.setSelection(E4Util.isSelectedElement(perspective));

		shortcut.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent event) {
				final MPerspective perspective = (MPerspective) event.widget.getData();
				E4Util.setWindowSelectedElement(perspective);
			}
		});

		// update the layout ???

	}

	@Override
	public void removePerspectiveShortcut(MPerspective perspective) {
		final ToolItem item = getToolItemFor(perspective);
		if (item == null || item.isDisposed()) {
			return;
		}

		Image icon = item.getImage();
		if (icon != null) {
			item.setImage(null);
			icon.dispose();
			icon = null;
		}

		item.dispose();

		// update the layout

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.e4.ui.workbench.perspectiveswitcher.tools.
	 * IPerspectiveSwitcherControl
	 * #setSelectedElement(org.eclipse.e4.ui.model.application
	 * .ui.advanced.MPerspective)
	 */
	@Override
	public void setSelectedElement(MPerspective perspective) {
		for (final ToolItem item : toolBar.getItems()) {
			item.setSelection(item.getData() == perspective);
		}
	}

	@Override
	public void updateAttributeFor(MPerspective perspective, String attName, Object newValue) {
		final ToolItem item = getToolItemFor(perspective);

		if (showShortcutText && UIEvents.UILabel.LABEL.equals(attName)) {
			final String newName = (String) newValue;
			item.setText(newName != null ? newName : _null);
		} else if (UIEvents.UILabel.TOOLTIP.equals(attName)) {
			final String newTip = (String) newValue;
			item.setToolTipText(newTip);
		} else if (UIEvents.UILabel.ICONURI.equals(attName)) {
			final ImageDescriptor descriptor = getIconFor((String) newValue);
			Image newIcon = null;
			Image oldIcon = item.getImage();

			if (descriptor != null) {
				newIcon = descriptor.createImage();
			}
			item.setImage(newIcon);

			if (oldIcon != null) {
				oldIcon.dispose();
				oldIcon = null;
			}

			if (!showShortcutText) {
				String label = null;
				if (item.getData() instanceof MPerspective) {
					label = ((MPerspective) item.getData()).getLocalizedLabel();
				} else {
					label = item.getText();
				}

				item.setText(item.getImage() == null ? label : _null);
			}
		}
	}

	@Inject
	void setShowText(
			@Preference(value = E4PerspectiveSwitcherPreferences.SHOW_TEXT, nodePath = E4PerspectiveSwitcherPreferences.ROOT_PREFERENCES_NODE) boolean showShortcutText) {
		this.showShortcutText = showShortcutText;

		if (toolBar == null || toolBar.isDisposed()) {
			return;
		}

		for (final ToolItem item : toolBar.getItems()) {
			if (!(item.getData() instanceof MPerspective)) {
				continue;
			}

			final MPerspective perspective = (MPerspective) item.getData();
			if (item.getImage() == null || this.showShortcutText) {
				final String label = perspective.getLocalizedLabel();
				item.setText(label != null ? label : _null);
				item.setToolTipText(perspective.getLocalizedTooltip());
			} else {
				item.setText(_null);
				item.setToolTipText(perspective.getLocalizedLabel());
			}
		}

		// update the layout

	}

	ToolItem getToolItemFor(MPerspective perspective) {
		if (toolBar == null || toolBar.isDisposed()) {
			return null;
		}

		ToolItem toolItem = null;
		// Items 0 & 1 in the toolbar are never perspectives
		for (int i = 2; i < toolBar.getItems().length && toolItem == null; i++) {
			if (toolBar.getItem(i).getData() == perspective) {
				toolItem = toolBar.getItem(i);
			}
		}

		return toolItem;
	}

	ImageDescriptor getIconFor(String iconURI) {
		ImageDescriptor descriptor = null;
		try {
			final URI uri = URI.createURI(iconURI);
			descriptor = (ImageDescriptor) resourceUtilities.imageDescriptorFromURI(uri);
		} catch (final RuntimeException ex) {
			logger.debug(ex, "icon uri=" + iconURI);
		}
		return descriptor;
	}

	/**
	 * Returns the open perspective image TODO: Evaluate whether this needs to
	 * ported into an Eclipse4 friendly version.
	 *
	 * @return the image
	 */
	Image getOpenPerspectiveImage() {
		return iconService.getIcon("new_persp.gif");
	}

	Color getContainerCurveColor(PaintEvent event) {
		Color curveColor = containerCurveColor;
		if (curveColor == null) {
			curveColor = internalCrvColor != null ? internalCrvColor
					: new Color(event.display, defaultContainerCurveColor);
		}

		return curveColor;
	}

	private void dispose() {
		if (internalCrvColor != null) {
			internalCrvColor.dispose();
			internalCrvColor = null;
		}
	}

	private void disposeToolBarImages() {
		if (toolBar == null || toolBar.isDisposed()) {
			return;
		}

		for (final ToolItem item : toolBar.getItems()) {
			Image icon = item.getImage();
			if (icon != null) {
				item.setImage(null);
				icon.dispose();
				icon = null;
			}
		}
	}

	// ///////////////////////////////////////////////////////////////
	// Menu Items
	// ///////////////////////////////////////////////////////////////

	private void addSaveAsMenuItem(Menu menu) {
		final MenuItem menuItem = new MenuItem(menu, SWT.Activate);
		menuItem.setText(E4WorkbenchCommandConstants.PERSPECTIVES_SAVE_AS$_NAME);

		// TODO: Integrate into help system

		menuItem.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent event) {
				final ParameterizedCommand command = commandService
						.createCommand(E4WorkbenchCommandConstants.PERSPECTIVES_SAVE_AS, Collections.EMPTY_MAP);
				handlerService.executeHandler(command);
			}
		});
	}

	private void addResetMenuItem(Menu menu) {
		final MenuItem menuItem = new MenuItem(menu, SWT.Activate);
		menuItem.setText(E4WorkbenchCommandConstants.PERSPECTIVES_RESET$_NAME);

		// TODO: Integrate into help system

		menuItem.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent event) {
				final ParameterizedCommand command = commandService
						.createCommand(E4WorkbenchCommandConstants.PERSPECTIVES_RESET, Collections.EMPTY_MAP);
				handlerService.executeHandler(command);
			}
		});
	}

	private void addCloseMenuItem(Menu menu) {
		final MenuItem menuItem = new MenuItem(menu, SWT.Activate);
		menuItem.setText(E4WorkbenchCommandConstants.PERSPECTIVES_CLOSE$_NAME);

		// TODO: Integrate into help system

		menuItem.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent event) {
				final ParameterizedCommand command = commandService
						.createCommand(E4WorkbenchCommandConstants.PERSPECTIVES_CLOSE, Collections.EMPTY_MAP);
				handlerService.executeHandler(command);
			}
		});
	}

	private void addShowTextMenuItem(Menu menu) {
		final MenuItem menuItem = new MenuItem(menu, SWT.Activate | SWT.CHECK);
		menuItem.setText(E4WorkbenchCommandConstants.PERSPECTIVES_SHOW_TEXT$_NAME);
		menuItem.setSelection(showShortcutText);

		// TODO: Integrate into help system

		menuItem.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent event) {
				final Map<String, Object> parameters = new HashMap<>(3);
				final ParameterizedCommand command = commandService
						.createCommand(E4WorkbenchCommandConstants.PERSPECTIVES_SHOW_TEXT, parameters);
				handlerService.executeHandler(command);
			}
		});
	}

}
