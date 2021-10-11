package com.wepaint.mvc.bean;

public class UserCollectPaint {
    private Integer collectID;
    private Integer userID;
    private Integer publishID;

    public UserCollectPaint() {
    }

    public UserCollectPaint(Integer collectID, Integer userID, Integer publishID) {
        this.collectID = collectID;
        this.userID = userID;
        this.publishID = publishID;
    }

    public Integer getCollectID() {
        return collectID;
    }

    public void setCollectID(Integer collectID) {
        this.collectID = collectID;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public Integer getPublishID() {
        return publishID;
    }

    public void setPublishID(Integer publishID) {
        this.publishID = publishID;
    }

    @Override
    public String toString() {
        return "UserCollectPaint{" +
                "collectID=" + collectID +
                ", userID=" + userID +
                ", publishID=" + publishID +
                '}';
    }
}
