package com.zeng.tieba.controller;

import com.zeng.tieba.entity.SysUser;
import com.zeng.tieba.pojo.ResultVo;
import com.zeng.tieba.service.UserService;
import com.zeng.tieba.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.Date;
import java.util.regex.Pattern;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/user/getUserById")
    public ResultVo getUserById(@RequestParam("userId") String userId){
        ResultVo resultVo;
        SysUser sysUser = userService.getUserById(userId);
        if(sysUser != null){
            resultVo = new ResultVo("200", "查询成功", sysUser);
        }
        else{
            resultVo = new ResultVo("400", "查询失败");
        }
        return resultVo;
    }

    @RequestMapping("/user/getUserLastTokenById")
    public Timestamp getUserLastTokenById(@RequestParam("userId") String userId){
        return userService.getUserById(userId).getLastToken();
    }

    @RequestMapping("/user/updateUserPassword")
    public ResultVo updateUserPassword(@RequestParam(value = "userId") String userId,
                                       @RequestParam(value = "oldPassword") String oldPassword,
                                       @RequestParam(value = "newPassword") String newPassword){
        ResultVo resultVo;
        SysUser sysUser = userService.getUserById(userId);
        if(sysUser.getPassword().equals(oldPassword)){
            sysUser.setPassword(newPassword);
            if(userService.updateUserPassword(sysUser)){
                resultVo = new ResultVo("200", "修改成功");
            }
            else{
                resultVo = new ResultVo("400", "修改失败");
            }
        }
        else{
            resultVo = new ResultVo("400", "密码错误");
        }
        return resultVo;
    }

    @RequestMapping("/user/updateUserToken")
    public boolean updateUserToken(@RequestParam(value = "userId") String userId){
        SysUser sysUser = userService.getUserById(userId);
        sysUser.setLastToken(new Timestamp(new Date().getTime()));
        return userService.updateUserToken(sysUser);
    }

    @RequestMapping("/user/register")
    public ResultVo addNewUser(@RequestParam("userName") String userName,
                               @RequestParam("password") String password,
                               @RequestParam("userRole") String userRole,
                               @RequestParam("email") String email){
        ResultVo resultVo;

        //判断用户名是否重复
        if(userService.getUserByName(userName) != null){
            resultVo = new ResultVo("400", "注册失败，用户名已存在！");
            return resultVo;
        }

        //判断邮箱格式是否正确
        if ((email != null) && (!email.isEmpty())) {
             if(!Pattern.matches("^(\\w+([-.][A-Za-z0-9]+)*){3,18}@\\w+([-.][A-Za-z0-9]+)*\\.\\w+([-.][A-Za-z0-9]+)*$", email)){
                 resultVo = new ResultVo("400", "注册失败，邮箱格式错误！");
                 return resultVo;
             }
        }
        else {
            resultVo = new ResultVo("400", "注册失败，邮箱不能为空！");
            return resultVo;
        }

        SysUser sysUser = new SysUser();
        sysUser.setUserId(UUIDUtils.createUUID());
        sysUser.setUserName(userName);
        sysUser.setPassword(password);
        sysUser.setUserRole(userRole);
        sysUser.setEmail(email);
        if(userService.addNewUser(sysUser)){
            resultVo = new ResultVo("200", "注册成功", sysUser);
        }
        else{
            resultVo = new ResultVo("400", "注册失败");
        }
        return resultVo;
    }


}
