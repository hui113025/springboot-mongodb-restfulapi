package com.ruhang.statistics.service;

import com.ruhang.statistics.orm.User;
import com.ruhang.statistics.orm.UserVisit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhenghui on 2017/4/13.
 */
@Service
public class UserVisitService {
    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 新增
     * @param userVisit
     */
    public void insert(UserVisit userVisit){
        mongoTemplate.insert(userVisit);
    }

    /**
     * 批量新增
     * @param userVisits
     */
    public void insertAll(List<UserVisit> userVisits) {
        mongoTemplate.insertAll(userVisits);
    }

    /**
     * 删除,按主键id, 如果主键的值为null,删除会失败
     * @param id
     */
    public void removeById(String id){
        UserVisit userVisit = new UserVisit(id, null, null);
        mongoTemplate.remove(userVisit);
    }
    /**
     * 按条件删除
     * @param userVisit
     */
    public void remove(UserVisit userVisit) {
        Criteria criteria = Criteria.where("age").gt(userVisit.getGid());
        Query query = new Query(criteria);
        mongoTemplate.remove(query, User.class);
    }

    /**
     * 删除全部
     */
    public void removeAll() {
        mongoTemplate.dropCollection(UserVisit.class);
    }

    /**
     * 按主键修改,
     * 如果文档中没有相关key 会新增 使用$set修改器
     * @param userVisit
     */
    public void updateById(UserVisit userVisit) {
        Criteria criteria = Criteria.where("id").is(userVisit.getId());
        Query query = new Query(criteria);
        Update update = Update.update("age", userVisit.getUserId()).set("userId", userVisit.getUserId());
        mongoTemplate.updateFirst(query, update, User.class);
    }

    /**
     * 修改多条
     * @param criteriaDTO
     * @param userVisit
     */
    public void update(UserVisit criteriaDTO, UserVisit userVisit) {
        Criteria criteria = Criteria.where("age").gt(criteriaDTO.getUserId());;
        Query query = new Query(criteria);
        Update update = Update.update("userId", userVisit.getUserId()).set("userId", userVisit.getUserId());
        mongoTemplate.updateMulti(query, update, User.class);
    }

    /**
     * 根据主键查询
     * @param id
     * @return
     */
    public UserVisit findById(String id) {
        return mongoTemplate.findById(id, UserVisit.class);
    }

    /**
     * 查询全部
     * @return
     */
    public List<UserVisit> findAll() {
        return mongoTemplate.findAll(UserVisit.class);
    }

    /**
     * 按条件查询, 分页
     * @param criteriaDTO
     * @param skip
     * @param limit
     * @return
     */
    public List<User> find(UserVisit criteriaDTO, int skip, int limit) {
        Query query = getQuery(criteriaDTO);
        query.skip(skip);
        query.limit(limit);
        return mongoTemplate.find(query, User.class);
    }

    /**
     *
     * @param criteriaDTO
     * @return
     */
    private Query getQuery(UserVisit criteriaDTO) {
        if (criteriaDTO == null) {
            criteriaDTO = new UserVisit();
        }
        Query query = new Query();
        if (criteriaDTO.getId() != null) {
            Criteria criteria = Criteria.where("id").is(criteriaDTO.getId());
            query.addCriteria(criteria);
        }

        return query;
    }


}
