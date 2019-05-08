package com.jk.model;

import lombok.Data;

@Data
public class Contract {

    private Integer cid;//id
    private String contractroom;//房源地址
    private String start_end_time; //起始时间
    private Integer rent;//租金
    private Integer deposit;//押金
    private String paymethod;//房租支付方式
}
