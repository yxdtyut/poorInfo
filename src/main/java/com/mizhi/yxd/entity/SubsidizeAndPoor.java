package com.mizhi.yxd.entity;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author yangxudong
 * @description:
 * @date 2020/12/20 9:45
 */
@Data
public class SubsidizeAndPoor{
    private String id;

    private String province;

    private String county;

    private String village;

    private String cun;

    private String name;

    private String idCard;

    private String buildCard;

    private String sixFifteen;

    private String headOfHouseNum;

    private String headOfHouseName;

    private String headOfHouseTel;

    private String school;

    private String studyLevel;

    private String grade;

    private String clazz;

    private String studentNumber;

    private String studyWay;

    private String ifDisability;

    private String disabilityNumber;

    private String notInSchoolReason;

    private String poorType;

    private String ifVillage;

    private String ifCounty;

    private String ifProvince;

    private String thisEnjoy;

    private String account;

    private String subsidizeProject;

    private BigDecimal subsidizeMoney;

    private BigDecimal nutrimealMoney;
}
