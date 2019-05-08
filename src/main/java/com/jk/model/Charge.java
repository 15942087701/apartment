package com.jk.model;

import lombok.Data;

@Data
public class Charge {

    private Integer room_id;
    private String room_number;
    private String room_payer;
    private Integer room_price;
    private Integer type;
    private String date;
    private Integer middleOne;
    private String middleTwo;
    private String endDate;
    private Integer waitId;


}
