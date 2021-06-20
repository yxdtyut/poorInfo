package com.mizhi.yxd.validate;

import com.mizhi.yxd.exception.GlobleException;
import com.mizhi.yxd.result.CodeMsg;
import com.mizhi.yxd.tools.StatisticUtil;
import com.mizhi.yxd.tools.ValidateUtils;
import com.mizhi.yxd.vo.UpdatePoorVo;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

/**
 * @author yangxudong
 * @description:
 * @date 2020/12/12 14:30
 */
public class ValueValidate {
    public static Map<String, String> map = new HashMap<>();
    public static Map<String, String> studentMap = new HashMap<>();
    public static List<String> subsidizeList = new ArrayList<>();

    static {
        map.put("id","id");
        map.put("name","name");
        map.put("province","province");
        map.put("county","county");
        map.put("village","village");
        map.put("cun","cun");
        map.put("idCard","id_card");
        map.put("buildCard","build_card");
        map.put("sixFifteen","six_fifteen");
        map.put("headOfHouseNum","head_of_house_num");
        map.put("headOfHouseName","head_of_house_name");
        map.put("headOfHouseIdCard","head_of_house_id_card");
        map.put("headOfHouseTel","head_of_house_tel");
        map.put("school","school");
        map.put("studyLevel","study_level");
        map.put("grade","grade");
        map.put("clazz","clazz");
        map.put("studentNumber","student_number");
        map.put("studyWay","study_way");
        map.put("ifDisability","if_disability");
        map.put("disabilityNumber","disability_number");
        map.put("notInSchoolReason","not_in_school_reason");
        map.put("poorType","poor_type");
        map.put("ifVillage","if_village");
        map.put("ifCounty","if_county");
        map.put("ifProvince","if_province");
        map.put("thisEnjoy","this_enjoy");
        map.put("account","account");
        map.put("subsidizeProject","subsidize_project");
        map.put("subsidizeMoney","subsidize_money");
        map.put("nutrimealMoney","nutrimeal_money");

        subsidizeList.add("subsidize_project");
        subsidizeList.add("subsidize_money");
        subsidizeList.add("nutrimeal_money");

        studentMap.put("id", "id");
        studentMap.put("school", "school");
        studentMap.put("grade", "grade");
        studentMap.put("clazz", "clazz");
        studentMap.put("studentName", "student_name");
        studentMap.put("idCard", "id_card");
        studentMap.put("sex", "sex");
        studentMap.put("studentNumber", "student_number");
        studentMap.put("schoolUniforms", "school_uniforms");
        studentMap.put("model", "model");
        studentMap.put("homework", "homework");
        studentMap.put("studyTool", "study_tool");
        studentMap.put("buildCard", "build_card");
        studentMap.put("remark", "remark");
    }

    public static void validate(UpdatePoorVo poolVo) {

        String feild = poolVo.getField();
        String value = poolVo.getValue().trim();
        if ("sixFifteen".equals(feild) && (!"是".equals(value) && !"否".equals(value))) {
            throw new GlobleException(CodeMsg.SIX_FIFTEEN_NOT_RIGHT);
        }

        if ("idCard".equals(feild) && !ValidateUtils.checkIdCard(value)) {
            throw new GlobleException(CodeMsg.IDCARD_NOT_RIGHT);
        }

        if ("buildCard".equals(feild) && (!"是".equals(value) && !"否".equals(value))) {
            throw new GlobleException(CodeMsg.DUILD_CARD_NOT_RIGHT);
        }

        if ("headOfHouseIdCard".equals(feild) && !ValidateUtils.checkIdCard(value)) {
            throw new GlobleException(CodeMsg.HEAD_OF_IDCARD_NOT_RIGHT);
        }

        if ("ifDisability".equals(feild) && (!"是".equals(value) && !"否".equals(value))) {
            throw new GlobleException(CodeMsg.DISABILITY_NOT_RIGHT);
        }

        if ("thisEnjoy".equals(feild) && (!"是".equals(value) && !"否".equals(value))) {
            throw new GlobleException(CodeMsg.ENJOY_NOT_RIGHT);
        }

        if ("subsidizeMoney".equals(feild) && !value.matches("([1-9]\\d*\\.?\\d*)|(0\\.\\d*[1-9])")) {
            throw new GlobleException(CodeMsg.DECIMAL_NOT_RIGHT_ERROR);
        }

        if ("nutrimealMoney".equals(feild) && !value.matches("([1-9]\\d*\\.?\\d*)|(0\\.\\d*[1-9])")) {
            throw new GlobleException(CodeMsg.DECIMAL_NOT_RIGHT_ERROR);
        }

        Set<String> learningPeriodSet = StatisticUtil.unmodifyLearningPeriodMap.keySet();
        if ("studyLevel".equals(feild) && !learningPeriodSet.contains(value)) {
            throw new GlobleException(CodeMsg.STUDY_LEVEL_NOT_RIGHT);
        }
    }

    public static void validateStudent(UpdatePoorVo poolVo) {
        String feild = poolVo.getField();
        String value = poolVo.getValue().trim();
        if ("schoolUniforms".equals(feild) && (!"是".equals(value) && !"否".equals(value))) {
            throw new GlobleException(CodeMsg.SCHOOLUNIFORMS_NOT_RIGHT);
        }

        if ("idCard".equals(feild) && !ValidateUtils.checkIdCard(value)) {
            throw new GlobleException(CodeMsg.IDCARD_NOT_RIGHT);
        }

        if ("sex".equals(feild) && (!"女".equals(value) && !"男".equals(value))) {
            throw new GlobleException(CodeMsg.SEX_NOT_RIGHT);
        }

        if ("homework".equals(feild) && (!"是".equals(value) && !"否".equals(value))) {
            throw new GlobleException(CodeMsg.HOMEWORK_NOT_RIGHT);
        }

        if ("studyTool".equals(feild) && (!"是".equals(value) && !"否".equals(value))) {
            throw new GlobleException(CodeMsg.STUDY_TOOL_NOT_RIGHT);
        }

        if ("buildCard".equals(feild) && (!"是".equals(value) && !"否".equals(value))) {
            throw new GlobleException(CodeMsg.DUILD_CARD_NOT_RIGHT);
        }
    }

    public static boolean ifSubsidize(UpdatePoorVo poolVo) {
        return subsidizeList.contains(poolVo.getField());
    }
}
