package com.icteam.loyalty.ui.converter;

import org.eclipse.swt.graphics.Image;
import org.eclipse.wb.swt.SWTResourceManager;

import com.icteam.loyalty.model.interfaces.IImageDtoModel;
import com.icteam.loyalty.ui.interfaces.IImageProvider;

public class DefaultImageProvider implements IImageProvider {

    @Override
    public Image getColumnImage(Object element, int columnIndex) {
        if (element == null) {
            return null;
        }

        String imagePath = ((IImageDtoModel) element).getImagePath();

        return SWTResourceManager.getImage(element.getClass(), imagePath);
    }

}
