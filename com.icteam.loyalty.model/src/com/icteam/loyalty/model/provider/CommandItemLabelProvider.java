package com.icteam.loyalty.model.provider;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.widgets.Display;

import com.icteam.loyalty.model.interfaces.Action;

public class CommandItemLabelProvider implements IItemLabelProvider {
    private final ResourceLocator resourceLocator;
    private final EStructuralFeature feature;

    public CommandItemLabelProvider(EStructuralFeature feature, ResourceLocator resourceLocator) {
        this.feature = feature;
        this.resourceLocator = resourceLocator;
    }

    @Override
    public String getText(Object object) {
        return this.resourceLocator.getString("_UI_" + ((EClass) feature.eContainer()).getName() + "_" + feature.getName() + "_feature");
    }

    @Override
    public Object getImage(Object object) {
        Action action = (Action) object;

        if (action.getIconPath() != null) {
            URL url = (URL) resourceLocator.getImage(action.getIconPath());
            Display display = Display.getCurrent();

            try (InputStream stream = url.openStream()) {
                ImageData data = new ImageData(stream);
                // if (data.transparentPixel > 0) {
                // return new Image(display, data, data.getTransparencyMask());
                // }
                return new Image(display, data);
            } catch (IOException e) {
            }
        }

        return null;
    }
}