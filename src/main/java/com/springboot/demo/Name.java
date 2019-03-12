package com.springboot.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by yuntian on 2019/3/8.
 */
@Configuration
@PropertySource("classpath:application1.properties")
public class Name {

    @Value("${my.name}")
    private String name;

    @Value("${my.age}")
    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
