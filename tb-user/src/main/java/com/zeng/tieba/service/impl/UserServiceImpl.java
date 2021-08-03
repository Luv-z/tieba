package com.zeng.tieba.service.impl;

import com.zeng.tieba.mapper.UserMapper;
import com.zeng.tieba.entity.SysUser;
import com.zeng.tieba.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public SysUser getUserById(String userId) {
        return userMapper.getUserById(userId);
    }

    @Override
    public SysUser getUserByName(String userName) {
        return userMapper.getUserByName(userName);
    }

    @Override
    public boolean addNewUser(SysUser sysUser) {
        if(userMapper.addNewUser(sysUser) == 1){
            return true;
        }
        return false;
    }

    @Override
    public boolean updateUserPassword(SysUser sysUser) {
        if(userMapper.updateUserPassword(sysUser) == 1){
            return true;
        }
        return false;
    }

    @Override
    public boolean updateUserToken(SysUser sysUser) {
        if(userMapper.updateUserToken(sysUser) == 1){
            return true;
        }
        return false;
    }
}
