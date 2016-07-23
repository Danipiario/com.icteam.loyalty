package com.icteam.loyalty.model;

import java.math.BigDecimal;

import com.icteam.loyalty.model.interfaces.IGeoLocation;

public class SimpleGeoLocation implements IGeoLocation {

    private final BigDecimal latitude;
    private final BigDecimal longitude;

    public SimpleGeoLocation(BigDecimal latitude, BigDecimal longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    @Override
    public BigDecimal getLatitude() {
        return latitude;
    }

    @Override
    public BigDecimal getLongitude() {
        return longitude;
    }

    @Override
    public String toString() {
        return "SimpleGeoLocation [latitude=" + latitude + ", longitude=" + longitude + "]";
    }

}
