package com.jk.model;

import lombok.Data;

@Data
public class HousingInformationBean {
    private Integer id;
    private String housing_location;
    private String floor_area;
    private String housing_family;
    private String housing_conditions;
    private Integer landlord_id;
}
