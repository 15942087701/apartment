package com.jk.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
public class LoginUser implements Serializable {

    private Integer userId;

    private String accounts;

    private String userName;

    private String userPassWord;

    private String userPhone;

    private String phoneName;

    private String emailName;

    private String code;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date endTime;
}
