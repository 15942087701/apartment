package com.jk.model;

import lombok.Data;

@Data
public class CostSettlemenBean {
    private Integer id;
    private String water_meter;
    private String electric_meter;
    private String gas_meter;
    private String property;
}
