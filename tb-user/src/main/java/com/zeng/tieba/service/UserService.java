package com.zeng.tieba.service;

import com.zeng.tieba.entity.SysUser;

import java.sql.Timestamp;

public interface UserService {

    SysUser getUserById(String userId);

    SysUser getUserByName(String userName);

    boolean addNewUser(SysUser sysUser);

    boolean updateUserPassword(SysUser sysUser);

    boolean updateUserToken(SysUser sysUser);
}
