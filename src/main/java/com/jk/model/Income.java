package com.jk.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class Income {
    private Integer billid;  //账单id
    private String billown;  //账单所属
    private Integer zijin;  //资金流向
    private Integer billAmount;  //账单金额
    private Integer shiAmount;  //应付金额
    private String receivepayment;  //付款/收款方
    private Integer billtype;  //账单类型
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date expectedtime;  //预计付款时间
    private Integer pid;  //支付id

    private Integer payid;  //支付方式id
    private Integer paytype;  //支付方式
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date paytime;  //支付时间
    private String remarks;  //备注

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date minDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date maxDate;
}
