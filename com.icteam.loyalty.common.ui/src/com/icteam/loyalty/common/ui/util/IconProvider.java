package com.icteam.loyalty.common.ui.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.widgets.Display;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ServiceScope;

import com.icteam.loyalty.common.ui.service.IconService;

@Component(scope = ServiceScope.SINGLETON, immediate = true)
public class IconProvider implements IconService {

	private final Logger logger = Log.getLogger(IconProvider.class);

	private static final int MISSING_IMAGE_SIZE = 10;

	private Map<String, ImageData> icons;

	@Activate
	public void activate() {
		icons = new HashMap<>();
	}

	@Override
	public synchronized void addIcon(File iconFile) {
		String iconName = iconFile.getName();

		if (icons.containsKey(iconName)) {
			logger.warn("Duplicated icon #{0} not loaded", iconName);
		} else {
			try (FileInputStream stream = new FileInputStream(iconFile)) {
				ImageData imageData = new ImageData(stream);
				icons.put(iconName, imageData);
			} catch (IOException e) {
				logger.warn("error adding icon #" + iconName, e);
			}
		}
	}

	@Override
	public synchronized void removeIcon(String iconName) {
		icons.remove(iconName);
	}

	@Override
	public synchronized Image getIcon(String iconName) {
		ImageData imageData = icons.get(iconName);

		if (imageData != null) {
			return new Image(Display.getCurrent(), imageData);
		}

		return new Image(Display.getCurrent(), MISSING_IMAGE_SIZE, MISSING_IMAGE_SIZE);
	}
}
