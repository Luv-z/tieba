package com.zeng.sys;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.api.*")
@EnableDiscoveryClient
@MapperScan("com.zeng.sys.mapper")
public class TieApplication {

    public static void main(String[] args) {
        SpringApplication.run(TieApplication.class, args);
    }
}
