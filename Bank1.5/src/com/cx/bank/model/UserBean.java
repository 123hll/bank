package com.cx.bank.model;

/**
 * 封装用户信息
 */
public class UserBean {

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    private String username;//定义用户的姓名

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String password;//定义用户的密码
}
