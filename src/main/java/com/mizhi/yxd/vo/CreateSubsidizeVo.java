package com.mizhi.yxd.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author yangxudong
 * @description:
 * @date 2020/12/15 22:13
 */
@Data
public class CreateSubsidizeVo {
    private String poorId;
    private String username;
    private String idcard;
    private String province;
    private String county;
    private String village;
    private String cun;

    private String subsidizeProject;

    private BigDecimal subsidizeMoney;

    private BigDecimal nutrimealMoney;
}
