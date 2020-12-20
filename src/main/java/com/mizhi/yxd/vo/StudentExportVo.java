package com.mizhi.yxd.vo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.mizhi.yxd.entity.SubUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

/**
 * @author yangxudong
 * @description:
 * @date 2020/12/20 23:36
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentExportVo {
    @Excel(name = "学校全称", width = 15)
    private String school;

    @Excel(name = "年级", width = 15)
    private String grade;

    @Excel(name = "班级", width = 15)
    private String clazz;

    @Excel(name = "姓名", width = 15)
    private String studentName;

    @Excel(name = "身份证号码", width = 25)
    private String idCard;

    @Excel(name = "性别", width = 15)
    private String sex;

    @Excel(name = "学籍号", width = 15)
    private String studentNumber;

    @Excel(name = "是否享受校服", width = 15)
    private String schoolUniforms;

    @Excel(name = "型号", width = 15)
    private String model;

    @Excel(name = "是否享受作业本", width = 15)
    private String homework;

    @Excel(name = "是否享受学具", width = 15)
    private String studyTool;

    @Excel(name = "备注", width = 30)
    private String remark;

    public void validate() {
        SubUser subUser = new SubUser();
        BeanUtils.copyProperties(this, subUser);
        subUser.validate();
    }
}
