package com.mizhi.yxd.vo;

import lombok.Data;

/**
 * @author yangxudong
 * @description:
 * @date 2021/2/12 19:14
 */
@Data
public class LearningPeriodInMizhiVo {
    private String village;
    private String kindergarten;
    private String primarySchool;
    private String juniorHighSchool;
    private String highSchool;
    private String juniorProfession;
    private String total;

    private Integer kindergartenCount = 0;
    private Integer primarySchoolCount = 0;
    private Integer juniorHighSchoolCount = 0;
    private Integer highSchoolCount = 0;
    private Integer juniorProfessionCount = 0;
    private Integer totalCount = 0;

    private Double kindergartenMoney = 0.0;
    private Double primarySchoolMoney = 0.0;
    private Double juniorHighSchoolMoney = 0.0;
    private Double highSchoolMoney = 0.0;
    private Double juniorProfessionMoney = 0.0;
    private Double totalMoney = 0.0;

   public void finishTotal() {
       finishCountTotal();
       finishMoneyTotal();
       this.kindergarten = "人数:" + this.kindergartenCount + "-资助金:" + this.kindergartenMoney + "元";
       this.primarySchool = "人数:" + this.primarySchoolCount + "-资助金:" + this.primarySchoolMoney + "元";
       this.juniorHighSchool = "人数:" + this.juniorHighSchoolCount + "-资助金:" + this.juniorHighSchoolMoney + "元";
       this.highSchool = "人数:" + this.highSchoolCount + "-资助金:" + this.highSchoolMoney + "元";
       this.juniorProfession = "人数:" + this.juniorProfessionCount + "-资助金:" + this.juniorProfessionMoney + "元";
       this.total = "人数:" + this.totalCount + "-资助金:" + this.totalMoney + "元";
   }

    private void finishMoneyTotal() {
        this.totalMoney = this.kindergartenMoney + this.primarySchoolMoney + this.juniorHighSchoolMoney + this.highSchoolMoney + this.juniorProfessionMoney;
    }

    private void finishCountTotal() {
        this.totalCount = this.kindergartenCount + this.primarySchoolCount + this.juniorHighSchoolCount + this.highSchoolCount + this.juniorProfessionCount;
    }
}
