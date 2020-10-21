package com.mizhi.yxd.result;

import lombok.Getter;

/**
 * @Author : yangxudong
 * @Description :   错误码
 * @Date : 下午3:04 2018/5/29
 */
@Getter
public class CodeMsg {
    /**通用模块.*/
    public static final CodeMsg SUCCESS = new CodeMsg(200, "成功");
    public static final CodeMsg SERVER_ERROR = new CodeMsg(500, "服务异常");

    /**用户模块.5001xx*/
    public static final CodeMsg USER_OR_PWD_NOT_RIGHT = new CodeMsg(500100, "用户或密码不正确");
    public static final CodeMsg USER_ALREADY_REGIST = new CodeMsg(500101, "用户已经被注册");

    private Integer code;
    private String msg;

    private CodeMsg(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private CodeMsg() {
    }


}
