package com.ruhang.statistics.service;

import com.ruhang.statistics.orm.UserLectureRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhenghui on 2017/4/13.
 */
@Service
public class UserLectureRecordService {
    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 新增
     * @param userLectureRecord
     */
    public void insert(UserLectureRecord userLectureRecord){
        mongoTemplate.insert(userLectureRecord);
    }

    /**
     * 批量新增
     * @param userLectureRecords
     */
    public void insertAll(List<UserLectureRecord> userLectureRecords) {
        mongoTemplate.insertAll(userLectureRecords);
    }

    /**
     * 删除,按主键id, 如果主键的值为null,删除会失败
     * @param id
     */
    public void removeById(String id){
        UserLectureRecord userLectureRecord = new UserLectureRecord();
        userLectureRecord.setId(id);
        mongoTemplate.remove(userLectureRecord);
    }

}
