package com.wepaint.mvc.bean;

public class UserHavePaint {
    private Integer haveID;
    private Integer userID;
    private Integer paintID;

    public UserHavePaint() {
    }

    public UserHavePaint(Integer haveID, Integer userID, Integer paintID) {
        this.haveID = haveID;
        this.userID = userID;
        this.paintID = paintID;
    }

    public Integer getHaveID() {
        return haveID;
    }

    public void setHaveID(Integer haveID) {
        this.haveID = haveID;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public Integer getPaintID() {
        return paintID;
    }

    public void setPaintID(Integer paintID) {
        this.paintID = paintID;
    }

    @Override
    public String toString() {
        return "UserHavePaint{" +
                "haveID=" + haveID +
                ", userID=" + userID +
                ", paintID=" + paintID +
                '}';
    }
}
