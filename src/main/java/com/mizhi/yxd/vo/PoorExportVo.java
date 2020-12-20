package com.mizhi.yxd.vo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.mizhi.yxd.exception.GlobleException;
import com.mizhi.yxd.result.CodeMsg;
import com.mizhi.yxd.tools.ValidateUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

/**
 * @program: subsidize
 * @description:
 * @author: yangxudong
 * @create: 2020-10-03 18:52
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PoorExportVo {
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

    public void validate() {
        String errorMsg = "信息输入有误，姓名:" + name + ",身份证:" + idCard;
        if (StringUtils.isEmpty(name) || StringUtils.isEmpty(idCard)) {
            throw new GlobleException(CodeMsg.NAME_IDCARD_NULL);
        }
        if (StringUtils.isNotEmpty(sixFifteen)  && (!"是".equals(sixFifteen) && !"否".equals(sixFifteen))) {
            throw new GlobleException(CodeMsg.IMPORT_VALIDATE_ERROR.setMsg(errorMsg + "，原因:是否5-15周岁字段只能写是或者否"));
        }

        if (!ValidateUtils.checkIdCard(idCard)) {
            throw new GlobleException(CodeMsg.IMPORT_VALIDATE_ERROR.setMsg(errorMsg + "，身份证信息有误!"));
        }

        if (StringUtils.isNotEmpty(ifDisability) && (!"是".equals(ifDisability) && !"否".equals(ifDisability))) {
            throw new GlobleException(CodeMsg.IMPORT_VALIDATE_ERROR.setMsg(errorMsg + "，原因:是否残疾生字段只能写是或者否"));
        }

        if (StringUtils.isNotEmpty(thisEnjoy) && (!"是".equals(thisEnjoy) && !"否".equals(thisEnjoy))) {
            throw new GlobleException(CodeMsg.IMPORT_VALIDATE_ERROR.setMsg(errorMsg + "，原因:本学期是否享受米脂资助只能写是或者否"));
        }
    }
}
