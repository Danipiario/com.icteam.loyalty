package com.icteam.loyalty.common.provider;

import java.util.List;

import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.StringUtils;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleEvent;
import org.osgi.util.tracker.BundleTracker;
import org.osgi.util.tracker.ServiceTracker;

import com.icteam.loyalty.common.api.EnumService;
import com.icteam.loyalty.common.interfaces.IEnum;

public class EnumTracker extends BundleTracker<Bundle> {

    EnumService enumService;

    private final ServiceTracker<EnumService, EnumService> serviceTracker;

    public EnumTracker(BundleContext context) {
        super(context, Bundle.UNINSTALLED | Bundle.ACTIVE, null);

        serviceTracker = new ServiceTracker<>(context, EnumService.class, null);
        serviceTracker.open();
    }

    @Override
    public Bundle addingBundle(Bundle bundle, BundleEvent event) {
        String extension = bundle.getHeaders().get("Enum-Extension");

        if (extension != null) {
            addEnumExtension(bundle, extension);
        }

        return super.addingBundle(bundle, event);
    }

    @Override
    public void close() {
        super.close();

        serviceTracker.close();
    }

    private void addEnumExtension(final Bundle bundle, final String extension) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String[] enhancedEnumClasses = StringUtils.stripAll(StringUtils.split(extension, ","));

                for (String enhancedEnumClass : enhancedEnumClasses) {
                    try {
                        Class< ? extends Enum< ? >> enumClass = (Class< ? extends Enum< ? >>) bundle.loadClass(enhancedEnumClass);
                        List<Class< ? >> interfaces = ClassUtils.getAllInterfaces(enumClass);

                        for (Class< ? > interface_ : interfaces) {
                            if (IEnum.class.isAssignableFrom(interface_)) {
                                Class< ? extends IEnum> a = (Class< ? extends IEnum>) interface_;
                                serviceTracker.waitForService(1000).addEnum(a, enumClass);
                            }
                        }
                    } catch (ClassNotFoundException | InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}