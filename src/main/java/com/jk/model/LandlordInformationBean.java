package com.jk.model;

import lombok.Data;

@Data
public class LandlordInformationBean {
    private Integer id;
    private String name;
    private String phone;
    private String id_number;
    private String emergency_contact;
    private String emergency_contact_information;
    private Integer landlord_id;
}
