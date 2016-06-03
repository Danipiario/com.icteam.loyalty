package com.icteam.loyalty.common.test;

import org.junit.Assert;
import org.junit.Test;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

import com.icteam.loyalty.common.api.Upper;

/**
 * 
 */

public class CommonTest {

	private final BundleContext context = FrameworkUtil.getBundle(this.getClass()).getBundleContext();

	<T> T getService(Class<T> clazz) throws InterruptedException {
		ServiceTracker<T, T> st = new ServiceTracker<>(context, clazz, null);
		st.open();
		return st.waitForService(1000);
	}

	/*
	 * 
	 */
	@Test
	public void testCommon() throws Exception {
		Assert.assertNotNull(context);
	}

	@Test
	public void testUpper() throws InterruptedException {
		Assert.assertNotNull(getService(Upper.class));
	}
}