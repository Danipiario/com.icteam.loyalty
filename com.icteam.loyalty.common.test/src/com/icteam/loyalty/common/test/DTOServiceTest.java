package com.icteam.loyalty.common.test;

import java.util.Dictionary;
import java.util.Hashtable;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.ServiceRegistration;
import org.osgi.util.tracker.ServiceTracker;

import com.icteam.loyalty.common.api.DTOBuilder;
import com.icteam.loyalty.common.api.DTOService;

/**
 *
 */

public class DTOServiceTest {

    private static final BundleContext context = FrameworkUtil.getBundle(DTOServiceTest.class).getBundleContext();

    private static ServiceTracker< ? , ? > serviceTracker = new ServiceTracker<>(context, DTOService.class, null);

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

    @Test(expected = AssertionError.class)
    public void nullParametersToDTO() throws InterruptedException {
        getService().toDTO(null, null);
    }

    @Test(expected = AssertionError.class)
    public void nullParametersToObject() throws InterruptedException {
        getService().toObject(null, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void noBuilder() throws InterruptedException {
        getService().toDTO(new Object(), TestDTO.class);
    }

    @Test
    public void builderRegistered() throws InterruptedException {
        DTOBuilder<TestDTO, String> testBuilder = new TestDTOBuilder();

        Dictionary<String, String> properties = new Hashtable<>();
        properties.put(DTOBuilder.PROPERTY_DTO_CLASS_NAME, TestDTO.class.getSimpleName());
        properties.put(DTOBuilder.PROPERTY_OBJECT_CLASS_NAME, String.class.getSimpleName());

        FrameworkUtil.getBundle(getClass()).getBundleContext().registerService(DTOBuilder.class, testBuilder, properties);

        Assert.assertNotNull(getService().toDTO("", TestDTO.class));
    }

    @Test(expected = IllegalArgumentException.class)
    public void builderDeregistered() throws InterruptedException {
        DTOBuilder<TestDTO, String> testBuilder = new TestDTOBuilder();

        Dictionary<String, String> properties = new Hashtable<>();
        properties.put(DTOBuilder.PROPERTY_DTO_CLASS_NAME, TestDTO.class.getSimpleName());
        properties.put(DTOBuilder.PROPERTY_OBJECT_CLASS_NAME, String.class.getSimpleName());

        ServiceRegistration< ? > serviceRegistration = FrameworkUtil.getBundle(getClass()).getBundleContext()
                .registerService(DTOBuilder.class.getName(), testBuilder, properties);

        Assert.assertNotNull(getService().toDTO("", TestDTO.class));

        serviceRegistration.unregister();

        getService().toDTO("", TestDTO.class);
    }
}
