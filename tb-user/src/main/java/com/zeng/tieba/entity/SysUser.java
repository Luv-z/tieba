package com.zeng.tieba.entity;

import java.sql.Timestamp;
import java.util.Date;

public class SysUser {

    private String userId;
    private String userName;
    private String password;
    private String userRole;
    private String email;
    private Timestamp lastToken;

    public SysUser(){}

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Timestamp getLastToken() {
        return lastToken;
    }

    public void setLastToken(Timestamp lastToken) {
        this.lastToken = lastToken;
    }
}
