package com.wepaint.mvc.bean;

public class Abandon {
    private Integer abandonID;
    private Integer userID;
    private Integer paintID;

    public Abandon() {
    }

    public Abandon(Integer abandonID, Integer userID, Integer paintID) {
        this.abandonID = abandonID;
        this.userID = userID;
        this.paintID = paintID;
    }

    public Integer getAbandonID() {
        return abandonID;
    }

    public void setAbandonID(Integer abandonID) {
        this.abandonID = abandonID;
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
        return "UserAbandonPaint{" +
                "abandonID=" + abandonID +
                ", userID=" + userID +
                ", paintID=" + paintID +
                '}';
    }
}
