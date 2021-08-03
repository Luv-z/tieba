package com.api.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Timestamp;

@FeignClient(name = "user-service")
public interface UserService {

    @RequestMapping("/user/updateUserToken")
    public boolean updateUserToken(@RequestParam(value = "userId") String userId);

    @RequestMapping("/user/getUserLastTokenById")
    public Timestamp getUserLastTokenById(@RequestParam("userId") String userId);
}
