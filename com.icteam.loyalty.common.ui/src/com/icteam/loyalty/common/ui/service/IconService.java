package com.icteam.loyalty.common.ui.service;

import java.io.File;

import org.eclipse.swt.graphics.Image;

public interface IconService {

	Image getIcon(String iconName);

	void addIcon(File iconFile);

	void removeIcon(String iconName);

}
