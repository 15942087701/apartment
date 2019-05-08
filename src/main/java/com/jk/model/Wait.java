package com.jk.model;

import lombok.Data;

@Data
public class Wait {

    private Integer waitId;
    private String waitNumber;
    private Integer waitPrice;
    private String fangDong;
    private Integer type;
    private String date;
    private Integer middleOne;
    private String middleTwo;
    private Integer status;


    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getWaitId() {
        return waitId;
    }

    public void setWaitId(Integer waitId) {
        this.waitId = waitId;
    }

    public String getWaitNumber() {
        return waitNumber;
    }

    public void setWaitNumber(String waitNumber) {
        this.waitNumber = waitNumber;
    }

    public Integer getWaitPrice() {
        return waitPrice;
    }

    public void setWaitPrice(Integer waitPrice) {
        this.waitPrice = waitPrice;
    }

    public String getFangDong() {
        return fangDong;
    }

    public void setFangDong(String fangDong) {
        this.fangDong = fangDong;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getMiddleOne() {
        return middleOne;
    }

    public void setMiddleOne(Integer middleOne) {
        this.middleOne = middleOne;
    }

    public String getMiddleTwo() {
        return middleTwo;
    }

    public void setMiddleTwo(String middleTwo) {
        this.middleTwo = middleTwo;
    }
}
