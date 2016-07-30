package com.icteam.loyalty.common.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

import com.icteam.loyalty.common.interfaces.IEnum;
import com.icteam.loyalty.common.interfaces.IStatus;
import com.icteam.loyalty.common.service.EnumService;

/**
 *
 */

public class EnumServiceTest {

	private final BundleContext context = FrameworkUtil.getBundle(this.getClass()).getBundleContext();

	<T> T getService(Class<T> clazz) throws InterruptedException {
		final ServiceTracker<T, T> st = new ServiceTracker<>(context, clazz, null);
		st.open();
		return st.waitForService(1000);
	}

	@Test
	public void contextNotNull() throws Exception {
		Assert.assertNotNull(context);

	}

	@Test
	public void serviceNotNull() throws InterruptedException {
		Assert.assertNotNull(getService(EnumService.class));
	}

	@Test
	public void valuesOfIStatus() throws InterruptedException {
		final List<? extends IEnum> values = getService(EnumService.class).values(IStatus.class);
		System.out.println(values);
		Assert.assertNotNull(values);
	}
}
