package com.mizhi.yxd.vo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

/**
 * @author yangxudong
 * @description:
 * @date 2021/2/12 19:14
 */
@Data
public class LearningPeriodWithSubsidizeVo {
    @Excel(name = "乡镇", width = 15)
    private String village;

    @Excel(name = "学前(人数)", width = 15)
    private Integer kindergartenCount = 0;
    @Excel(name = "小学(人数)", width = 15)
    private Integer primarySchoolCount = 0;
    @Excel(name = "初中(人数)", width = 15)
    private Integer juniorHighSchoolCount = 0;
    @Excel(name = "普高(人数)", width = 15)
    private Integer highSchoolCount = 0;
    @Excel(name = "中职(人数)", width = 15)
    private Integer juniorProfessionCount = 0;
    @Excel(name = "高职(人数)", width = 15)
    private Integer highProfessionCount = 0;
    @Excel(name = "本科(人数)", width = 15)
    private Integer undergraduateCount = 0;
    @Excel(name = "研究生(人数)", width = 15)
    private Integer graduateCount = 0;
    @Excel(name = "特殊教育(人数)", width = 15)
    private Integer specialEducationCount = 0;
    @Excel(name = "博士(人数)", width = 15)
    private Integer doctorCount = 0;
    @Excel(name = "总计(人数)", width = 15)
    private Integer totalCount = 0;

    @Excel(name = "学前(金额)", width = 15)
    private Double kindergartenMoney = 0.0;
    @Excel(name = "小学(金额)", width = 15)
    private Double primarySchoolMoney = 0.0;
    @Excel(name = "初中(金额)", width = 15)
    private Double juniorHighSchoolMoney = 0.0;
    @Excel(name = "普高(金额)", width = 15)
    private Double highSchoolMoney = 0.0;
    @Excel(name = "中职(金额)", width = 15)
    private Double juniorProfessionMoney = 0.0;
    @Excel(name = "高职(金额)", width = 15)
    private Integer highProfessionMoney = 0;
    @Excel(name = "本科(金额)", width = 15)
    private Integer undergraduateMoney = 0;
    @Excel(name = "研究生(金额)", width = 15)
    private Integer graduateMoney = 0;
    @Excel(name = "特殊教育(金额)", width = 15)
    private Integer specialEducationMoney = 0;
    @Excel(name = "博士(金额)", width = 15)
    private Integer doctorMoney = 0;
    @Excel(name = "总计(金额)", width = 15)
    private Double totalMoney = 0.0;

   public void finishTotal() {
       finishCountTotal();
       finishMoneyTotal();
   }

    private void finishMoneyTotal() {
        this.totalMoney = this.kindergartenMoney + this.primarySchoolMoney + this.juniorHighSchoolMoney + this.highSchoolMoney + this.juniorProfessionMoney
        + this.highProfessionMoney + this.undergraduateMoney + this.graduateMoney + this.specialEducationMoney + this.doctorMoney;
    }

    private void finishCountTotal() {
        this.totalCount = this.kindergartenCount + this.primarySchoolCount + this.juniorHighSchoolCount + this.highSchoolCount + this.juniorProfessionCount
        + this.highProfessionCount + this.undergraduateCount + this.graduateCount + this.specialEducationCount + this.doctorCount;
    }
}
