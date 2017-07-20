package com.ruhang.statistics.service;

import com.ruhang.statistics.orm.UserLectureHandout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhenghui on 2017/4/13.
 */
@Service
public class UserLectureHandoutService {
    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 新增
     * @param userLectureHandout
     */
    public void insert(UserLectureHandout userLectureHandout){
        mongoTemplate.insert(userLectureHandout);
    }

    /**
     * 批量新增
     * @param userLectureHandouts
     */
    public void insertAll(List<UserLectureHandout> userLectureHandouts) {
        mongoTemplate.insertAll(userLectureHandouts);
    }

    /**
     * 删除,按主键id, 如果主键的值为null,删除会失败
     * @param id
     */
    public void removeById(String id){
        UserLectureHandout userLectureHandout = new UserLectureHandout();
        userLectureHandout.setId(id);
        mongoTemplate.remove(userLectureHandout);
    }

}
