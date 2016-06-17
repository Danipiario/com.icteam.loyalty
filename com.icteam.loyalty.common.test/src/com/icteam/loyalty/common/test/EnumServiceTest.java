package com.icteam.loyalty.common.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

import com.icteam.loyalty.common.api.interfaces.IAlfa;
import com.icteam.loyalty.common.api.interfaces.IEnum;
import com.icteam.loyalty.common.api.service.EnumService;

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

	/*
	 *
	 */
	@Test
	public void contextNotNull() throws Exception {
		Assert.assertNotNull(context);

	}

	@Test
	public void serviceNotNull() throws InterruptedException {
		Assert.assertNotNull(getService(EnumService.class));
	}

	@Test
	public void valuesOfIAlfa() throws InterruptedException {
		final List<? extends IEnum> values = getService(EnumService.class).values(IAlfa.class);
		System.out.println(values);
		Assert.assertNotNull(values);
	}
}
