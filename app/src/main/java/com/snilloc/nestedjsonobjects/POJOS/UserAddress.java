package com.snilloc.nestedjsonobjects.POJOS;

import com.google.gson.annotations.SerializedName;

public class UserAddress {
    private String street;

    private String suite;

    private String city;

    @SerializedName("zipcode")
    private String zipCode;

    private UserAddressGeoLocation geo;

    public String getStreet() {
        return street;
    }

    public String getSuite() {
        return suite;
    }

    public String getCity() {
        return city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public UserAddressGeoLocation getGeo() {
        return geo;
    }
}
