package com.icteam.loyalty.application;

import org.osgi.framework.FrameworkUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.icteam.loyalty.common.api.EnumService;
import com.icteam.loyalty.common.interfaces.IEnum;

import osgi.enroute.configurer.api.RequireConfigurerExtender;
import osgi.enroute.google.angular.capabilities.RequireAngularWebResource;
import osgi.enroute.rest.api.REST;
import osgi.enroute.twitter.bootstrap.capabilities.RequireBootstrapWebResource;
import osgi.enroute.webserver.capabilities.RequireWebServerExtender;

@RequireAngularWebResource(resource = { "angular.js", "angular-resource.js", "angular-route.js" }, priority = 1000)
@RequireBootstrapWebResource(resource = "css/bootstrap.css")
@RequireWebServerExtender
@RequireConfigurerExtender
@Component(name = "com.icteam.loyalty")
public class LoyaltyApplication implements REST {

    @Reference
    private EnumService enumService;

    public String getValues(String enumClass) throws ClassNotFoundException {
        return enumService.values((Class< ? extends IEnum>) FrameworkUtil.getBundle(getClass()).loadClass(enumClass)).toString();
    }

}
