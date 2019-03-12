package com.springboot.demo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * Created by Donghua.Chen on 2018/6/7.
 */
@ApiModel("用户")
public class User implements Serializable {

    private static final long serialVersionUID = 8655851615465363473L;

    @ApiModelProperty(name = "id" ,value = "1", example = "用户")
    private Long id;
    @ApiModelProperty(name = "用户民",value = "kaka",example = "用户名称")
    private String username;
    @ApiModelProperty(name = "用户密码",value = "123456",example = "密码")
    private String password;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
