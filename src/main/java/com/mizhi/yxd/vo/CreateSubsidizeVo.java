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
    private String semester;
    private String studyLevel;
    private String school;
    private String buildCard;
    private String county;
    private String village;
    private String cun;
    private String thisEnjoy;
    private String subsidizeProject;

    private BigDecimal subsidizeMoney;

    private BigDecimal nutrimealMoney;
}
