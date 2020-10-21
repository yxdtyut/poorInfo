package com.mizhi.yxd.exception;

import com.alibaba.fastjson.JSON;
import com.mizhi.yxd.result.CodeMsg;
import com.mizhi.yxd.result.Result;
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
public class GlobleExceptionHandler {
    @ExceptionHandler(value = GlobleException.class)
    public Result handleGlobelException(GlobleException ex) {
        log.error("catch GlobelException, ex:{}", JSON.toJSONString(ex.getMessage()));
        CodeMsg cm = ((GlobleException) ex).getCm();
        return Result.error(cm);
    }

    @ExceptionHandler(value = Exception.class)
    public Result handleException(Exception ex) {
        log.error("catch Exception, ex:{}", JSON.toJSONString(ex.getMessage()));
        return Result.error(CodeMsg.SERVER_ERROR);
    }
}
