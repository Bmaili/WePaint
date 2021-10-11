package com.wepaint.mvc.bean;

import java.util.Date;

public class Paint {
    private Integer id;
    private String name;
    private Integer userID;
    private String jsonData;
    private Date createTime;
    private Date lastTime;
    private String imgPath = "static/img/default.jpg";

    public Paint() {
    }

    public Paint(Integer id, String name, Integer userID, String jsonData, Date createTime, Date lastTime, String imgPath) {
        this.id = id;
        this.name = name;
        this.userID = userID;
        this.jsonData = jsonData;
        this.createTime = createTime;
        this.lastTime = lastTime;
        this.imgPath = imgPath;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getJsonData() {
        return jsonData;
    }

    public void setJsonData(String jsonData) {
        this.jsonData = jsonData;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastTime() {
        return lastTime;
    }

    public void setLastTime(Date lastTime) {
        this.lastTime = lastTime;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    @Override
    public String toString() {
        return "Paint{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", userID='" + userID + '\'' +
                ", jsonData='" + jsonData + '\'' +
                ", createTime=" + createTime +
                ", lastTime=" + lastTime +
                ", imgPath='" + imgPath + '\'' +
                '}';
    }
}
