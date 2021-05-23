package com.mobiquity.dto;

import lombok.Data;

import java.util.List;

@Data
public class OpeningHours {
    private Integer dayOfWeek;
    private List<Hours> hours;
}
