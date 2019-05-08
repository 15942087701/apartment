package com.jk.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class BillInfor {

    private Integer billid;  //id
    private String billown;  //账单所属
    private Integer zijin;  //资金流向
    private Integer billAmount;  //账单金额
    private Integer shiAmount;  //应付金额
    private String receivepayment;  //付款/收款方
    private Integer billtype;  //账单类型
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date expectedtime;  //预计付款时间
}
