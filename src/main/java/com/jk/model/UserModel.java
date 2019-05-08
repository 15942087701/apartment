package com.jk.model;

import lombok.Data;

import java.util.Date;

@Data
public class UserModel {
    private Integer userId;
    private String  userName;
    private String  userPassWord;
    private Integer userIdentity;
    private String userPhone;
    private String accounts;
    private Date endTime;
}
