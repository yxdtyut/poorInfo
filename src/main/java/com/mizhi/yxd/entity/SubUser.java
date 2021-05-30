package com.mizhi.yxd.entity;

import com.mizhi.yxd.exception.GlobleException;
import com.mizhi.yxd.result.CodeMsg;
import com.mizhi.yxd.tools.ValidateUtils;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

/**
 * @author yangxudong
 * @description:
 * @date 2020/12/20 15:02
 */
@Data
public class SubUser {
    private String id;
    private String school;
    private String grade;
    private String clazz;
    private String studentName;
    private String idCard;
    private String sex;
    private String studentNumber;
    private String schoolUniforms;
    private String model;
    private String homework;
    private String studyTool;
    private String buildCard;
    private String remark;

    public void validate() {
        String errorMsg = "信息输入有误，姓名:" + studentName + ",身份证:" + idCard;
        if (StringUtils.isEmpty(studentName) || StringUtils.isEmpty(idCard)) {
            throw new GlobleException(CodeMsg.NAME_IDCARD_NULL);
        }
        if (StringUtils.isNotEmpty(schoolUniforms) && (!"是".equals(schoolUniforms) && !"否".equals(schoolUniforms))) {
            throw new GlobleException(CodeMsg.IMPORT_VALIDATE_ERROR.setMsg(errorMsg + "，原因:是否享受校服字段只能写是或者否"));
        }

        if (!ValidateUtils.checkIdCard(idCard)) {
            throw new GlobleException(CodeMsg.IMPORT_VALIDATE_ERROR.setMsg(errorMsg + "，身份证信息有误!"));
        }

        if (StringUtils.isNotEmpty(homework) && (!"是".equals(homework) && !"否".equals(homework))) {
            throw new GlobleException(CodeMsg.IMPORT_VALIDATE_ERROR.setMsg(errorMsg + "，原因:是否享受作业本字段只能写是或者否"));
        }

        if (StringUtils.isNotEmpty(studyTool) && (!"是".equals(studyTool) && !"否".equals(studyTool))) {
            throw new GlobleException(CodeMsg.IMPORT_VALIDATE_ERROR.setMsg(errorMsg + "，原因:是否享受学具只能写是或者否"));
        }

        if (StringUtils.isNotEmpty(buildCard) && (!"是".equals(buildCard) && !"否".equals(buildCard))) {
            throw new GlobleException(CodeMsg.IMPORT_VALIDATE_ERROR.setMsg(errorMsg + "，原因:是否脱贫家庭只能写是或者否"));
        }

        if (StringUtils.isNotEmpty(sex) && (!"男".equals(sex) && !"女".equals(sex))) {
            throw new GlobleException(CodeMsg.IMPORT_VALIDATE_ERROR.setMsg(errorMsg + "，原因:性别只能写男或者女"));
        }
    }
}
