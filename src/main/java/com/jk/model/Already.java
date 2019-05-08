package com.jk.model;

import lombok.Data;

@Data
public class Already {

    private Integer roomId;
    private String roomName;
    private String roomPrice;
    private Integer roomFangShi;
    private String roomDate;
    private String roomText;
    private Integer waitId;


    public Integer getWaitId() {
        return waitId;
    }

    public void setWaitId(Integer waitId) {
        this.waitId = waitId;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(String roomPrice) {
        this.roomPrice = roomPrice;
    }

    public Integer getRoomFangShi() {
        return roomFangShi;
    }

    public void setRoomFangShi(Integer roomFangShi) {
        this.roomFangShi = roomFangShi;
    }

    public String getRoomDate() {
        return roomDate;
    }

    public void setRoomDate(String roomDate) {
        this.roomDate = roomDate;
    }

    public String getRoomText() {
        return roomText;
    }

    public void setRoomText(String roomText) {
        this.roomText = roomText;
    }
}
