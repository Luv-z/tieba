package com.zemg.gateway.filter;

import com.api.service.RedisService;
import com.api.service.UserService;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.Date;

@Component
public class TokenFilter implements GatewayFilter, Ordered {

    @Resource
    private RedisService redisService;

    @Resource
    private UserService userService;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        String requestPath = request.getPath().toString();

        //忽略登录和注册
        if(requestPath.contains("/sys/login") || requestPath.contains("/user/register")){
            return chain.filter(exchange);
        }
        String token = exchange.getRequest().getHeaders().getFirst("Authorization");
        //token不能为空
        if(token != null && !token.isEmpty()){
            String userId = redisService.getToken(token);
            //获取到userId
            if(userId != null && !userId.isEmpty()){
                Timestamp nowTime = new Timestamp(new Date().getTime());
                //判断token是否过期
                if(nowTime.getTime() - userService.getUserLastTokenById(userId).getTime() <= redisService.getExpire(token)){
                    return chain.filter(exchange);
                }
            }
        }
        exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
        return exchange.getResponse().setComplete();
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
