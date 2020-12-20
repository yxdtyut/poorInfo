package com.mizhi.yxd.vo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yangxudong
 * @description:
 * @date 2020/12/20 14:50
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubsidizeExportVo {
    @Excel(name = "省市", width = 15)
    private String province;

    @Excel(name = "区县", width = 15)
    private String county;

    @Excel(name = "乡镇", width = 15)
    private String village;

    @Excel(name = "村组（社区）", width = 15)
    private String cun;

    @Excel(name = "姓名", width = 15)
    private String name;

    @Excel(name = "身份证号码", width = 20)
    private String idCard;

    @Excel(name = "是否6-15周岁", width = 15)
    private String sixFifteen;

    @Excel(name = "户编号", width = 15)
    private String headOfHouseNum;

    @Excel(name = "户主姓名", width = 15)
    private String headOfHouseName;

    @Excel(name = "联系电话", width = 15)
    private String headOfHouseTel;

    @Excel(name = "学校全称", width = 15)
    private String school;

    @Excel(name = "学段", width = 15)
    private String studyLevel;

    @Excel(name = "年级", width = 15)
    private String grade;

    @Excel(name = "班级", width = 15)
    private String clazz;

    @Excel(name = "学籍号", width = 20)
    private String studentNumber;

    @Excel(name = "就读方式", width = 15)
    private String studyWay;

    @Excel(name = "是否残疾生", width = 15)
    private String ifDisability;

    @Excel(name = "残疾生证号", width = 15)
    private String disabilityNumber;

    @Excel(name = "不在校原因", width = 15)
    private String notInSchoolReason;

    @Excel(name = "贫困类型", width = 15)
    private String poorType;

    @Excel(name = "镇内/镇外", width = 15)
    private String ifVillage;

    @Excel(name = "县内/县外", width = 15)
    private String ifCounty;

    @Excel(name = "省内/省外", width = 15)
    private String ifProvince;

    @Excel(name = "本学期是否享受米脂资助", width = 15)
    private String thisEnjoy;

    @Excel(name = "资助项目", width = 15)
    private String subsidizeProject;

    @Excel(name = "资助金额", width = 15)
    private String subsidizeMoney;

    @Excel(name = "营养餐金额", width = 15)
    private String nutrimealMoney;
}
