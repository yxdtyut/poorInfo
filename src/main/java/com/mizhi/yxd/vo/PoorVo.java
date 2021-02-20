package com.mizhi.yxd.vo;

import cn.hutool.core.bean.BeanUtil;
import com.mizhi.yxd.entity.SubPoor;
import lombok.Data;

/**
 * @author yangxudong
 * @description:
 * @date 2020/10/27 23:15
 */
@Data
public class PoorVo {
    private String id;

    private String province;

    private String county;

    private String village;

    private String cun;

    private String name;

    private String idCard;

    private String buildCard;

    private String betweenSixFifteen;

    private String headOfHouseNum;

    private String headOfHouseName;

    private String headOfHouseIdCard;

    private String headOfHouseTel;

    private String school;

    private String studyLevel;

    private String grade;

    private String clazz;

    private String studentNumber;

    private String studyWay;

    private String disabilityOrNot;

    private String disabilityNumber;

    private String notInSchoolReason;

    private String poorType;

    private String ifVillage;

    private String ifCounty;

    private String ifProvince;

    private String thisEnjoy;

    private String account;

    public static PoorVo transferFrom(SubPoor subPoor) {
        PoorVo poor = new PoorVo();
        BeanUtil.copyProperties(subPoor, poor);
        return poor;
    }
}
