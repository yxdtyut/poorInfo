package com.mizhi.yxd.vo;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

/**
 * @author yangxudong
 * @description:
 * @date 2021/2/16 17:34
 */
@Data
public class PwdVo {
    private String account;
    private String oldPassword;
    private String password;
    private String confirmPassword;

    public Boolean judgePasswordSame() {
        if (StringUtils.isEmpty(password) || StringUtils.isEmpty(confirmPassword)) {
            return false;
        }
        if (!password.equals(confirmPassword)) {
            return false;
        }
        return true;
    }
}
