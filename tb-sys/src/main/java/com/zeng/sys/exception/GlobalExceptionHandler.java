package com.zeng.sys.exception;

import com.zeng.sys.pojo.ResultVo;
import feign.FeignException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Feign调用异常
     * @param e
     * @return
     */
    @ExceptionHandler(FeignException.class)
    public ResultVo handleException(Exception e) {
        return new ResultVo("500", "系统繁忙,请稍后再试");
    }

}
