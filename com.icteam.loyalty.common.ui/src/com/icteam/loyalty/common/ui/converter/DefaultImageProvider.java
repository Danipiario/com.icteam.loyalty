package com.icteam.loyalty.common.ui.converter;

import javax.inject.Inject;

import org.eclipse.e4.core.di.annotations.Creatable;
import org.eclipse.swt.graphics.Image;

import com.icteam.loyalty.common.interfaces.IImageDTO;
import com.icteam.loyalty.common.ui.interfaces.IImageProvider;
import com.icteam.loyalty.common.ui.service.IconService;

@Creatable
public class DefaultImageProvider implements IImageProvider {

	@Inject
	IconService iconService;

	@Override
	public Image getColumnImage(Object element, int columnIndex) {
		if (element == null) {
			return null;
		}

		final String imageName = ((IImageDTO) element).getImageName();

		return iconService.getIcon(imageName);
	}

}
