package com.ruhang.statistics.service;

import com.ruhang.statistics.orm.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 *Created by zhenghui on 2017/4/10.
 *Pageable(PageRequest对象) 页码在mongodb中是从0开始的
 *根据实体类中的属性进行模糊查询带分页，同时指定返回的键（数据库中的key,实体类中的属性）：
 *当我们进行带分页的模糊查询时，不想返回数据库中的所有字段，只是返回一部分字段。例如：只返回User中的id和name，不返回age.
 *若想指定返回的键，我们需要在UserRepository中添加方法，同时使用注解@Query。
 *查询的条件(value)，？0这个是占位符，对应着方法中参数中的第一个参数，如果对应的是第二个参数则为？1。
 *fields是我们指定的返回字段，其中id是自动返回的，不用我们指定，bson中{'name':1}的1代表true，也就是代表返回的意思。
 *
 */
public interface UserRepository extends MongoRepository<User, Long> {

    /**
     * 根据ID查询
     * 方法名的规则为：find + By + 属性名（首字母大写）
     * 如：根据姓名查询
     * @param id
     * @return
     */
    @Query(value="{'id':?0}",fields="{'name':1}")
    User findById(String id);

    /**
     * 模糊查询
     * 在UserRepository仓库中定义方法
     * 模糊查询定义方法名的规则为：find + By + 属性名（首字母大写） + Like
     * 如：根据姓名进行模糊查询User
     * @param name
     * @param pageable
     * @return
     */
    @Query(value="{'name':?0}",fields="{'name':1}")
    Page<User> findByNameLike(String name,Pageable pageable);

    /**
     * GreaterThan(大于)
     * @param age
     * @param pageable
     * @return
     */
    @Query(value="{'age':{'$gt':?0}}",fields="{'name':1}")
    Page<User> findByAgeGreaterThan(int age, Pageable pageable) ;

    /**
     * LessThan（小于）
     * @param age
     * @param pageable
     * @return
     */
    @Query(value="{'age':{'$lt':?0}}",fields="{'name':1}")
    Page<User> findByAgeLessThan(int age, Pageable pageable) ;

    /**
     * Between（在...之间）
     * 参数必须有Pageable，否则异常不能启动
     * @param from
     * @param to
     * @param pageable
     * @return
     */
    @Query(value="{'age':{'$gt':?0,'$lt':?1}}",fields="{'name':1,'age':1}")
    Page<User> findByAgeBetween(int from, int to,Pageable pageable);

    /**
     * Not（不包含）
     * 方法名的定义规则为：find + By + 属性名（首字母大写） + NotNull。
     * @param pageable
     * @return
     */
    @Query(value="{'age':{'$ne':null}}")
    Page<User> findByIdNotNull(Pageable pageable);

//    Page<User> findByAllByCondition();

}
