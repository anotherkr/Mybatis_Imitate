package com.yhz.mybatis.po;

import java.util.Date;

/**
 * @author yanhuanzhan
 * @date 2023/3/8 - 11:21
 */
public class User {
    private Long id;
    private String userId;          // 用户ID
    private String userHead;        // 头像
    private String userName;        // 头像

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserHead() {
        return userHead;
    }

    public void setUserHead(String userHead) {
        this.userHead = userHead;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", userHead='" + userHead + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
