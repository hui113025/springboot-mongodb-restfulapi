package com.ruhang.statistics.service;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.ruhang.statistics.orm.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

/**
 * Created by zhenghui on 2017/4/11.
 */
@Service
public abstract class UserRepositoryImpl implements UserRepository{
    @Autowired
    private UserRepository userRepository;

    @Override
    public User findById(String id) {
        return userRepository.findById(id);
    }

    @Override
    public Page<User> findByAgeGreaterThan(int age, Pageable pageable) {
        return userRepository.findByAgeGreaterThan(age,pageable);
    }

    @Override
    public Page<User> findByNameLike(String name, Pageable pageable) {
        return userRepository.findByNameLike(name,pageable);
    }

    @Override
    public Page<User> findByAgeLessThan(int age, Pageable pageable) {
        return userRepository.findByAgeLessThan(age,pageable);
    }

    @Override
    public Page<User> findByAgeBetween(int from, int to, Pageable pageable) {
        return userRepository.findByAgeBetween(from, to,pageable);
    }

    @Override
    public Page<User> findByIdNotNull(Pageable pageable) {
        return userRepository.findByIdNotNull(pageable);
    }

    public Page<User> findByAllByCondition() {

        PageRequest pageRequest = new PageRequest(0,10);
        Query query = new Query();
        Criteria criteria = new Criteria();
        //查询
        criteria.and("age").is(10);

        //模糊查询
//        criteria.and("name").regex(".*?"+"郑辉"+".*");

//        List<Sort.Order> orders = new ArrayList<Sort.Order>();
//        orders.add(new Sort.Order(Direction.DESC, "age"));
//        Sort sort = new Sort(orders);
//        if (null != sort) {
//            query.with(sort);
//        }

        query.addCriteria(criteria);
        query.with(pageRequest);
        BasicDBObject condition= new BasicDBObject();//最后在将查询结果放到一个查询对象中去
        BasicDBList condList = new BasicDBList();//存放查询条件的集合
        BasicDBObject searchQuery = new BasicDBObject();//条件查询的对象
        searchQuery.put("age",10);
        condList.add(searchQuery);
        condition.put("$and", condList);//多条件查询使用and
        return null;
    }
}
