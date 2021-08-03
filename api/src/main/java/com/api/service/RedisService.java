package com.api.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "redis-service")
public interface RedisService {

    @RequestMapping("/redis/addToken")
    public boolean addToken(@RequestParam("token") String token, @RequestParam("userId") String userId);

    @RequestMapping("/redis/deleteToken")
    public long deleteToken(@RequestParam("token") String token);

    @RequestMapping("/redis/getToken")
    public String getToken(@RequestParam("token") String token);

    @RequestMapping("/redis/hasToken")
    public boolean hasToken(@RequestParam("token") String token);

    @RequestMapping("/redis/getExpire")
    public long getExpire(@RequestParam("token") String token);
}