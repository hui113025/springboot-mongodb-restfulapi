package com.ruhang.statistics.service;

import com.ruhang.statistics.orm.UserLectureScore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhenghui on 2017/4/13.
 */
@Service
public class UserLectureScoreService {
    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 新增
     * @param userLectureScore
     */
    public void insert(UserLectureScore userLectureScore){
        mongoTemplate.insert(userLectureScore);
    }

    /**
     * 批量新增
     * @param userLectureScores
     */
    public void insertAll(List<UserLectureScore> userLectureScores) {
        mongoTemplate.insertAll(userLectureScores);
    }

    /**
     * 删除,按主键id, 如果主键的值为null,删除会失败
     * @param id
     */
    public void removeById(String id){
        UserLectureScore userLectureScore = new UserLectureScore();
        userLectureScore.setId(id);
        mongoTemplate.remove(userLectureScore);
    }

}
