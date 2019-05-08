package com.jk.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class Contractzuke {

    private Integer zcid;   //id
    private String zname;   //租客姓名
    private String contractroom;   //房源地址
    private String contractroomnumber;  //房号
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date starttime;   //开始时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date endtime;   //截至时间
    private Integer status;   //状态
    private Integer zid;   //租客id
    private Integer cid;   //合同id
    private Integer duid;  //费用id
}
