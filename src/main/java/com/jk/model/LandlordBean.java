package com.jk.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class LandlordBean {
    private Integer id;

    private String name;

    private String address;

    private String startTime;

    private String endTime;

    private Integer state;


}
