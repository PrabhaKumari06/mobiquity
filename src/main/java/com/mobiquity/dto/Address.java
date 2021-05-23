package com.mobiquity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Address {
    private GeoLocation geoLocation;
    private String city;
    @JsonProperty("postalcode")
    private String postalCode;
    @JsonProperty("housenumber")
    private String houseNumber;
    private String street;
}
