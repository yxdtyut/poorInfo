package com.zhengyuan.liunao.exception;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author yangxudong
 * @description:
 * @date 2020/10/19 22:07
 */
@Slf4j
@ControllerAdvice
@ResponseBody
public class GlobelExceptionHandler {
    @ExceptionHandler(value = GlobelException.class)
    public String handleGlobelException(GlobelException ex) {
        log.error("catch GlobelException, ex:{}", JSON.toJSONString(ex.getMessage()));
        return "fail";
    }

    @ExceptionHandler(value = Exception.class)
    public String handleException(Exception ex) {
        log.error("catch Exception, ex:{}", JSON.toJSONString(ex.getMessage()));
        return "fail";
    }
}
