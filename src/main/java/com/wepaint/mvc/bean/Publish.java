package com.wepaint.mvc.bean;

import java.util.Date;

public class Publish {
    private Integer publishID;
    private String publishName;
    private Integer userID;
    private String userName;
    private Integer collectNum;
    private Integer likeNum;
    private Date publishTime;
    private String jsonData;
    private String imgPath = "static/img/default.jpg";

    public Publish() {
    }

    public Publish(Integer publishID, String publishName, Integer userID, String userName, Integer collectNum, Integer likeNum, String jsonData, Date publishTime, String imgPath) {
        this.publishID = publishID;
        this.publishName = publishName;
        this.userID = userID;
        this.userName = userName;
        this.collectNum = collectNum;
        this.likeNum = likeNum;
        this.jsonData = jsonData;
        this.publishTime = publishTime;
        this.imgPath = imgPath;
    }

    public Integer getPublishID() {
        return publishID;
    }

    public void setPublishID(Integer publishID) {
        this.publishID = publishID;
    }

    public String getPublishName() {
        return publishName;
    }

    public void setPaintName(String publishtName) {
        this.publishName = publishName;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getCollectNum() {
        return collectNum;
    }

    public void setCollectNum(Integer collectNum) {
        this.collectNum = collectNum;
    }

    public Integer getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(Integer likeNum) {
        this.likeNum = likeNum;
    }

    public String getJsonData() {
        return jsonData;
    }

    public void setJsonData(String jsonData) {
        this.jsonData = jsonData;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    @Override
    public String toString() {
        return "Publish{" +
                "publishID=" + publishID +
                ", publishName='" + publishName + '\'' +
                ", userID=" + userID +
                ", userName='" + userName + '\'' +
                ", collectNum=" + collectNum +
                ", likeNum=" + likeNum +
                ", jsonData='" + jsonData + '\'' +
                ", publishTime=" + publishTime +
                ", imgPath='" + imgPath + '\'' +
                '}';
    }
}
