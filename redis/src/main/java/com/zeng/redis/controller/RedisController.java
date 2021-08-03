package com.zeng.redis.controller;

import com.zeng.redis.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisController {

    @Autowired
    private RedisUtils redisUtils;

    //过期时间1天
    private final long EXPIRATION = 3600 * 24L;

    @RequestMapping("/redis/addToken")
    public boolean addToken(@RequestParam("token") String token, @RequestParam("userId") String userId){
        return redisUtils.set(token, userId, EXPIRATION);
    }

    @RequestMapping("/redis/deleteToken")
    public long deleteToken(@RequestParam("token") String token){
        return redisUtils.delete(token);
    }

    @RequestMapping("/redis/getToken")
    public String getToken(@RequestParam("token") String token){
        return redisUtils.getString(token);
    }

    @RequestMapping("/redis/hasToken")
    public boolean hasToken(@RequestParam("token") String token){
        return redisUtils.hasKey(token);
    }

    @RequestMapping("/redis/getExpire")
    public long getExpire(@RequestParam("token") String token){
        return redisUtils.getExpire(token);
    }
}
