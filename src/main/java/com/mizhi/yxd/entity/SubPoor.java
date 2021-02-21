package com.mizhi.yxd.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubPoor {
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

    private String headOfHouseIdCard;

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

    private String semester;

    public SubPoor(String province, String county, String village, String cun, String name, String idCard, String buildCard, String sixFifteen, String headOfHouseNum, String headOfHouseName, String headOfHouseIdCard, String headOfHouseTel, String school, String studyLevel, String grade, String clazz, String studentNumber, String studyWay, String ifDisability, String disabilityNumber, String notInSchoolReason, String poorType, String ifVillage, String ifCounty, String ifProvince, String thisEnjoy, String account, String semester) {
        this.province = province;
        this.county = county;
        this.village = village;
        this.cun = cun;
        this.name = name;
        this.idCard = idCard;
        this.buildCard = buildCard;
        this.sixFifteen = sixFifteen;
        this.headOfHouseNum = headOfHouseNum;
        this.headOfHouseName = headOfHouseName;
        this.headOfHouseIdCard = headOfHouseIdCard;
        this.headOfHouseTel = headOfHouseTel;
        this.school = school;
        this.studyLevel = studyLevel;
        this.grade = grade;
        this.clazz = clazz;
        this.studentNumber = studentNumber;
        this.studyWay = studyWay;
        this.ifDisability = ifDisability;
        this.disabilityNumber = disabilityNumber;
        this.notInSchoolReason = notInSchoolReason;
        this.poorType = poorType;
        this.ifVillage = ifVillage;
        this.ifCounty = ifCounty;
        this.ifProvince = ifProvince;
        this.thisEnjoy = thisEnjoy;
        this.account = account;
        this.semester = semester;
    }
}