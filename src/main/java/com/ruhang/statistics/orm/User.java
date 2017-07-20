package com.ruhang.statistics.orm;

import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhenghui on 2017/4/10.
 */
public class User implements Serializable {
    @Id
    private String id;
    private String name;
    private Integer age;

    public User() {
        super();
    }

    public User(String id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("id", id);
        map.put("name", name);
        map.put("age", String.valueOf(age));
        return map.toString();
    }
}
