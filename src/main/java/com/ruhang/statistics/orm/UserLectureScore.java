package com.ruhang.statistics.orm;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by zhenghui on 2017/4/14.
 * 用户视频评分
 */
@Document(collection ="user_lecture_score")
public class UserLectureScore implements Serializable {
    @Id
    private String id;
    private Integer userId;
    private Integer courseId;
    private Integer lectureId;
    private Integer clarity; //视频清晰度
    private Integer wittySpeech;//演讲风趣
    private Boolean isFluency;//是否流畅1流畅0不流畅
    private String suggest;
    private String ip;
    private String gid;
    private Date ctime;

    public UserLectureScore() {
        super();
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

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getLectureId() {
        return lectureId;
    }

    public void setLectureId(Integer lectureId) {
        this.lectureId = lectureId;
    }

    public Integer getClarity() {
        return clarity;
    }

    public void setClarity(Integer clarity) {
        this.clarity = clarity;
    }

    public Integer getWittySpeech() {
        return wittySpeech;
    }

    public void setWittySpeech(Integer wittySpeech) {
        this.wittySpeech = wittySpeech;
    }

    public Boolean getFluency() {
        return isFluency;
    }

    public void setFluency(Boolean fluency) {
        isFluency = fluency;
    }

    public String getSuggest() {
        return suggest;
    }

    public void setSuggest(String suggest) {
        this.suggest = suggest;
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

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }
}
