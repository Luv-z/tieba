package com.zeng.tieba.mapper;

import com.zeng.tieba.entity.SysUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;

@Mapper
@Repository
public interface UserMapper {

    SysUser getUserById(@Param("userId") String userId);

    int addNewUser(@Param("sysUser") SysUser sysUser);

    SysUser getUserByName(@Param("userName") String userName);

    int updateUserPassword(@Param("sysUser") SysUser sysUser);

    int updateUserToken(@Param("sysUser") SysUser sysUser);
}
