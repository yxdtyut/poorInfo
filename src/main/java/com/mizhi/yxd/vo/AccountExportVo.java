package com.mizhi.yxd.vo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.mizhi.yxd.exception.GlobleException;
import com.mizhi.yxd.result.CodeMsg;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

/**
 * @author yangxudong
 * @description:
 * @date 2021/1/10 18:43
 */
@Data
public class AccountExportVo {
    @Excel(name = "登录名称", width = 15)
    private String account;

    @Excel(name = "初始密码", width = 15)
    private String psw;

    @Excel(name = "用户名称", width = 15)
    private String name;

    @Excel(name = "角色", width = 15)
    private Integer role = 1;

    public void validate() {
        if (StringUtils.isEmpty(account)) {
            throw new GlobleException(CodeMsg.ACCOUNT_IS_NULL);
        }
        if (StringUtils.isEmpty(psw)) {
            throw new GlobleException(CodeMsg.PSW_IS_NULL);
        }
        if (StringUtils.isEmpty(name)) {
            throw new GlobleException(CodeMsg.NAME_IS_NULL);
        }
    }
}
