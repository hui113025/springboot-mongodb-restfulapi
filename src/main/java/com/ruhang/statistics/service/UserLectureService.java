package com.ruhang.statistics.service;

import com.ruhang.statistics.orm.UserLecture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhenghui on 2017/4/13.
 */
@Service
public class UserLectureService {
    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 新增
     * @param userLecture
     */
    public void insert(UserLecture userLecture){
        mongoTemplate.insert(userLecture);
    }

    /**
     * 批量新增
     * @param userLectures
     */
    public void insertAll(List<UserLecture> userLectures) {
        mongoTemplate.insertAll(userLectures);
    }

    /**
     * 删除,按主键id, 如果主键的值为null,删除会失败
     * @param id
     */
    public void removeById(String id){
        UserLecture userVisit = new UserLecture();
        userVisit.setId(id);
        mongoTemplate.remove(userVisit);
    }

}
