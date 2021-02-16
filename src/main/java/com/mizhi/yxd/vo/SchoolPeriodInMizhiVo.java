package com.mizhi.yxd.vo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

/**
 * @author yangxudong
 * @description:
 * @date 2021/2/12 19:14
 */
@Data
public class SchoolPeriodInMizhiVo {
    @Excel(name = "学校全称", width = 15)
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
    @Excel(name = "总计(金额)", width = 15)
    private Double totalMoney = 0.0;

   public void finishTotal() {
       finishCountTotal();
       finishMoneyTotal();
   }

    private void finishMoneyTotal() {
        this.totalMoney = this.kindergartenMoney + this.primarySchoolMoney + this.juniorHighSchoolMoney + this.highSchoolMoney + this.juniorProfessionMoney;
    }

    private void finishCountTotal() {
        this.totalCount = this.kindergartenCount + this.primarySchoolCount + this.juniorHighSchoolCount + this.highSchoolCount + this.juniorProfessionCount;
    }
}
