package com.zeng.tieba.controller;

import com.api.service.RedisService;
import com.zeng.tieba.entity.SysUser;
import com.zeng.tieba.pojo.ResultVo;
import com.zeng.tieba.service.UserService;
import com.zeng.tieba.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.Date;

@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    @Resource
    private RedisService redisService;

    @RequestMapping("/sys/login")
    public ResultVo login(@RequestParam("userName") String userName,
                          @RequestParam("password") String password){
        ResultVo resultVo;

        SysUser sysUser = userService.getUserByName(userName);
        if(sysUser != null && sysUser.getPassword().equals(password)){
            //token创建，并将其存入Redis
            String token = UUIDUtils.createUUID();
            if(redisService.addToken(token, sysUser.getUserId())){
                sysUser.setLastToken(new Timestamp(new Date().getTime()));
                if(userService.updateUserToken(sysUser)){
                    //token创建时间成功存入数据库
                    resultVo = new ResultVo("200", "登录成功", token);
                }
                else{
                    redisService.deleteToken(token);
                    resultVo = new ResultVo("400", "登录失败");
                }
            }
            else{
                resultVo = new ResultVo("400", "登录失败");
            }
        }
        else{
            resultVo = new ResultVo("400", "密码错误");
        }
        return resultVo;
    }
}
