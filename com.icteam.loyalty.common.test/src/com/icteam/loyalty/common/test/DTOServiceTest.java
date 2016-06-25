package com.icteam.loyalty.common.test;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

import com.icteam.loyalty.common.service.DTOBuilder;
import com.icteam.loyalty.common.service.DTOService;

/**
 *
 */

public class DTOServiceTest {

	private static final BundleContext context = FrameworkUtil.getBundle(DTOServiceTest.class).getBundleContext();

	private static ServiceTracker<?, ?> serviceTracker = new ServiceTracker<>(context, DTOService.class, null);

	class TestDTOBuilder implements DTOBuilder<TestDTO, String> {

		@Override
		public String buildObject(TestDTO dto) {
			return "";
		}

		@Override
		public TestDTO buildDTO(String object) {
			return new TestDTO();
		}
	};

	DTOService getService() throws InterruptedException {
		return (DTOService) serviceTracker.waitForService(1000);
	}

	@BeforeClass
	public static void init() {
		serviceTracker.open();
	}

	@AfterClass
	public static void tearDown() {
		serviceTracker.close();
	}

	@Test
	public void contextNotNull() throws Exception {
		Assert.assertNotNull(context);
	}

	@Test
	public void serviceNotNull() throws InterruptedException {
		Assert.assertNotNull(getService());
	}

}
