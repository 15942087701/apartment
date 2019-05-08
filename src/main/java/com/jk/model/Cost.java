package com.jk.model;

import lombok.Data;

@Data
public class Cost {

    private Integer duid;//id
    private String water_meter;
    private String electric_meter;
    private String gas_meter;
}
