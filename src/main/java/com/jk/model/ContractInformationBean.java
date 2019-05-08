package com.jk.model;

import lombok.Data;

@Data
public class ContractInformationBean {
    private Integer id;
    private String start_end_time;
    private String the_rent;
    private String the_deposit;
    private String decorate;
    private String free;
    private String payment_method;
}
