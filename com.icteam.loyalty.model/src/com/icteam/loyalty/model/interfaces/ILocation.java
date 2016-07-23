package com.icteam.loyalty.model.interfaces;

public interface ILocation extends IGeoLocation {

    String getAddress();

    String getCivicNumber();

    String getCity();

    String getLocality();

    String getZipCode();

    String getProvCode();

    String getCountry();
}
