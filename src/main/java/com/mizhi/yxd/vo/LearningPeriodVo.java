package com.mizhi.yxd.vo;

import lombok.Data;

/**
 * @author yangxudong
 * @description:
 * @date 2021/2/12 19:14
 */
@Data
public class LearningPeriodVo {
    private String village;
    private int kindergarten;
    private int primarySchool;
    private int juniorHighSchool;
    private int highSchool;
    private int juniorProfession;
    private int highProfession;
    private int undergraduate;
    private int graduate;
    private int specialEducation;
    private int total;

   public void finishTotal() {
       this.total = this.kindergarten + this.primarySchool + this.juniorHighSchool + this.highSchool + this.juniorProfession
               + this.highProfession + this.undergraduate + this.graduate + this.specialEducation;
   }
}
