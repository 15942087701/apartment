package com.jk.model;

import lombok.Data;

@Data
public class Contact {

    private Integer zid;  //id
    private String zname;  //联系人
    private Integer phone;  //联系电话
    private String Identity;  //身份证号码
    private String urgentname;  //紧急联系人
    private Integer urgentphone;  //紧急联系人电话


}
