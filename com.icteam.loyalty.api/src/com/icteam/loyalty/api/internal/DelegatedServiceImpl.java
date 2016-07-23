package com.icteam.loyalty.api.internal;

import org.osgi.framework.Constants;
import org.osgi.framework.Filter;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.util.tracker.ServiceTracker;

import com.icteam.loyalty.api.DelegatedService;
import com.icteam.loyalty.api.interfaces.IDelegant;
import com.icteam.loyalty.api.interfaces.IDelegated;

public class DelegatedServiceImpl implements DelegatedService {

    @Override
    public <T extends IDelegated, S extends IDelegant> T getDelegated(S delegant, Class<T> delegatedServiceClass) {
        Filter filter = null;
        ServiceTracker<T, T> serviceTracker = null;

        try {
            filter = FrameworkUtil.createFilter("(&("
                    + Constants.OBJECTCLASS
                    + "="
                    + delegatedServiceClass.getName()
                    + ")(delegatedId="
                    + delegant.getDelegatedId()
                    + "))");

            serviceTracker = new ServiceTracker<>(FrameworkUtil.getBundle(getClass()).getBundleContext(), filter, null);

            serviceTracker.open();
            T delegatedService = serviceTracker.waitForService(1000l);

            return delegatedService;
        } catch (InvalidSyntaxException | InterruptedException e) {
            e.printStackTrace();

            // nothing to do
            return null;
        } finally {
            if (serviceTracker != null) {
                serviceTracker.close();
            }
        }
    }

}
