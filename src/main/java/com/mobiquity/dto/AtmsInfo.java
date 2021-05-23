package com.mobiquity.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AtmsInfo {
    private Address address;
    private Integer distance;
    private List<OpeningHours> openingHours;
    private String functionality;
    private String type;
}
