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
    private Integer kindergarten = 0;
    private Integer primarySchool = 0;
    private Integer juniorHighSchool = 0;
    private Integer highSchool = 0;
    private Integer juniorProfession = 0;
    private Integer highProfession = 0;
    private Integer undergraduate = 0;
    private Integer graduate = 0;
    private Integer specialEducation = 0;
    private Integer total = 0;

   public void finishTotal() {
       this.total = this.kindergarten + this.primarySchool + this.juniorHighSchool + this.highSchool + this.juniorProfession
               + this.highProfession + this.undergraduate + this.graduate + this.specialEducation;
   }
}
