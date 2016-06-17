package com.icteam.loyalty.common.internal.provider;

import java.util.HashMap;
import java.util.Map;

import org.osgi.dto.DTO;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.ServiceScope;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

import com.icteam.loyalty.common.api.DTOBuilder;
import com.icteam.loyalty.common.api.DTOService;

@Component(service = DTOService.class, immediate = true, scope = ServiceScope.SINGLETON)
public class DTOProvider
        implements DTOService, ServiceTrackerCustomizer<DTOBuilder< ? extends DTO, ? extends Object>, DTOBuilder< ? extends DTO, ? extends Object>> {

    private ServiceTracker<DTOBuilder< ? extends DTO, ? extends Object>, DTOBuilder< ? extends DTO, ? extends Object>> serviceTracker;
    private BundleContext context;

    private final Map<String, Map<String, ServiceReference< ? extends DTOBuilder< ? extends DTO, ? extends Object>>>> builderMaps = new HashMap<>();

    @Override
    public DTOBuilder< ? extends DTO, ? extends Object> addingService(ServiceReference<DTOBuilder< ? extends DTO, ? extends Object>> reference) {
        Map<String, ServiceReference< ? extends DTOBuilder< ? extends DTO, ? extends Object>>> dtoBuilderMap = getDTOBuilderMap(reference);

        String objectClass = (String) reference.getProperty(DTOBuilder.PROPERTY_OBJECT_CLASS_NAME);

        dtoBuilderMap.put(objectClass, reference);

        return context.getService(reference);
    }

    private Map<String, ServiceReference< ? extends DTOBuilder< ? extends DTO, ? extends Object>>> getDTOBuilderMap(
            ServiceReference<DTOBuilder< ? extends DTO, ? extends Object>> reference) {

        return getDTOBuilderMap((String) reference.getProperty(DTOBuilder.PROPERTY_DTO_CLASS_NAME));
    }

    private Map<String, ServiceReference< ? extends DTOBuilder< ? extends DTO, ? extends Object>>> getDTOBuilderMap(String dtoClassName) {
        Map<String, ServiceReference< ? extends DTOBuilder< ? extends DTO, ? extends Object>>> dtoBuilderMap = builderMaps.get(dtoClassName);

        if (dtoBuilderMap == null) {
            builderMaps.put(dtoClassName, dtoBuilderMap = new HashMap<>());
        }

        return dtoBuilderMap;
    }

    @Override
    public void modifiedService(ServiceReference<DTOBuilder< ? extends DTO, ? extends Object>> reference,
            DTOBuilder< ? extends DTO, ? extends Object> service) {
        // nothing to do
    }

    @Override
    public void removedService(ServiceReference<DTOBuilder< ? extends DTO, ? extends Object>> reference,
            DTOBuilder< ? extends DTO, ? extends Object> service) {
        Map<String, ServiceReference< ? extends DTOBuilder< ? extends DTO, ? extends Object>>> dtoBuilderMap = getDTOBuilderMap(reference);

        String objectClass = (String) reference.getProperty(DTOBuilder.PROPERTY_OBJECT_CLASS_NAME);

        dtoBuilderMap.remove(objectClass);
    }

    @Activate
    public void activate(BundleContext context) {
        this.context = context;

        serviceTracker = new ServiceTracker<>(context, DTOBuilder.class.getName(), this);
        serviceTracker.open();
    }

    @Deactivate
    public void deactivate() {
        serviceTracker.close();

        builderMaps.clear();
    }

    @Override
    public <D extends DTO, O extends Object> D toDTO(O object, Class<D> dtoClass) {
        assert object != null;
        assert dtoClass != null;

        String dtoClassName = dtoClass.getSimpleName();
        String objectClassName = object.getClass().getSimpleName();

        ServiceReference< ? extends DTOBuilder<D, O>> reference = getReference(dtoClassName, objectClassName);

        return context.getService(reference).buildDTO(object);
    }

    @Override
    public <D extends DTO, O extends Object> O toObject(D dto, Class<O> objectClass) {
        assert dto != null;
        assert objectClass != null;

        String dtoClassName = dto.getClass().getSimpleName();
        String objectClassName = objectClass.getSimpleName();

        ServiceReference< ? extends DTOBuilder<D, O>> reference = getReference(dtoClassName, objectClassName);

        return context.getService(reference).buildObject(dto);
    }

    private <O, D extends DTO> ServiceReference< ? extends DTOBuilder<D, O>> getReference(String dtoClassName, String objectClassName) {
        Map<String, ServiceReference< ? extends DTOBuilder< ? extends DTO, ? extends Object>>> dtoBuilderMap = getDTOBuilderMap(dtoClassName);
        ServiceReference< ? extends DTOBuilder<D, O>> reference = (ServiceReference< ? extends DTOBuilder<D, O>>) dtoBuilderMap.get(objectClassName);

        if (reference == null) {
            throw new IllegalArgumentException("no builder found for dtoClass " + dtoClassName + " and objectClass " + objectClassName);
        }

        return reference;
    }

}
