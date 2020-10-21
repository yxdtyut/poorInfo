package com.mizhi.yxd.exception;

import com.mizhi.yxd.result.CodeMsg;
import lombok.Getter;

/**
 * @author yangxudong
 * @description:
 * @date 2020/10/19 22:04
 */
@Getter
public class GlobleException extends RuntimeException {
    private CodeMsg cm;

    public GlobleException(CodeMsg cm) {
        super(cm.getMsg());
        this.cm = cm;
    }

    public GlobleException(String message) {
        super(message);
    }
}
