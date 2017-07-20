package com.ruhang.statistics.orm;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by zhenghui on 2017/4/14.
 * 用户视频观看记录
 */
@Document(collection ="user_lecture")
public class UserLecture implements Serializable {
    @Id
    private String id;
    private Integer userId;
    private Integer courseId;
    private Integer lectureId;
    private Integer stayTime;//停留时间，单位分钟
    private Integer lastProgress;//上次进度
    private Integer progress;//进度
    private Date ctime;

    public UserLecture() {
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

    public Integer getStayTime() {
        return stayTime;
    }

    public void setStayTime(Integer stayTime) {
        this.stayTime = stayTime;
    }

    public Integer getLastProgress() {
        return lastProgress;
    }

    public void setLastProgress(Integer lastProgress) {
        this.lastProgress = lastProgress;
    }

    public Integer getProgress() {
        return progress;
    }

    public void setProgress(Integer progress) {
        this.progress = progress;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }
}
