package com.mizhi.yxd.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @Author : yangxudong
 * @Description :   登陆的vo
 * @Date : 下午5:32 2018/5/29
 */
@Data
public class LoginVo {
    @NotNull(message = "登陆名不能为空")
    private String userId;
    @NotNull(message = "密码不能为空")
    private String password;
}
