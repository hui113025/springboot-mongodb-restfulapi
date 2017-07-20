package com.ruhang.statistics.orm;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhenghui on 2017/4/10.
 * 用户埋点记录
 */
@Document(collection ="user_visit")
public class UserVisit implements Serializable {
    @Id
    private String id;
    private Integer userId;
    private String refererUrl;
    private String currentUrl;
    private Date visitTime;
    private Date stayTime;
    private String ip;
    private String gid;

    public UserVisit() {
        super();
    }

    public UserVisit(String id, Integer userId, String gid) {
        this.id = id;
        this.userId = userId;
        this.gid = gid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getRefererUrl() {
        return refererUrl;
    }

    public void setRefererUrl(String refererUrl) {
        this.refererUrl = refererUrl;
    }

    public String getCurrentUrl() {
        return currentUrl;
    }

    public void setCurrentUrl(String currentUrl) {
        this.currentUrl = currentUrl;
    }

    public Date getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(Date visitTime) {
        this.visitTime = visitTime;
    }

    public Date getStayTime() {
        return stayTime;
    }

    public void setStayTime(Date stayTime) {
        this.stayTime = stayTime;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getGid() {
        return gid;
    }

    public void setGid(String gid) {
        this.gid = gid;
    }

    @Override
    public String toString() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", id);
        map.put("userId", userId);
        map.put("gid", gid);
        return map.toString();
    }
}
