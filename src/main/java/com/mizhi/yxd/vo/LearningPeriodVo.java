package com.mizhi.yxd.vo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

/**
 * @author yangxudong
 * @description:
 * @date 2021/2/12 19:14
 */
@Data
public class LearningPeriodVo {
    @Excel(name = "乡镇", width = 15)
    private String village;

    @Excel(name = "学前", width = 15)
    private Integer kindergarten = 0;

    @Excel(name = "小学", width = 15)
    private Integer primarySchool = 0;

    @Excel(name = "初中", width = 15)
    private Integer juniorHighSchool = 0;

    @Excel(name = "普高", width = 15)
    private Integer highSchool = 0;

    @Excel(name = "中职", width = 15)
    private Integer juniorProfession = 0;

    @Excel(name = "高职", width = 15)
    private Integer highProfession = 0;

    @Excel(name = "本科", width = 15)
    private Integer undergraduate = 0;

    @Excel(name = "研究生", width = 15)
    private Integer graduate = 0;

    @Excel(name = "特殊教育", width = 15)
    private Integer specialEducation = 0;

    @Excel(name = "总计", width = 15)
    private Integer total = 0;

   public void finishTotal() {
       this.total = this.kindergarten + this.primarySchool + this.juniorHighSchool + this.highSchool + this.juniorProfession
               + this.highProfession + this.undergraduate + this.graduate + this.specialEducation;
   }
}
