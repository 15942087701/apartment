package com.jk.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class JobModel {
    private Integer jobid;
    private String jobname;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date jobdate;
}
