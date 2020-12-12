package com.mizhi.yxd.validate;

import com.mizhi.yxd.exception.GlobleException;
import com.mizhi.yxd.result.CodeMsg;
import com.mizhi.yxd.tools.ValidateUtils;
import com.mizhi.yxd.vo.UpdatePoorVo;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yangxudong
 * @description:
 * @date 2020/12/12 14:30
 */
public class ValueValidate {
    public static Map<String, String> map = new HashMap<>();

    static {
        map.put("id","id");
        map.put("province","province");
        map.put("county","county");
        map.put("village","village");
        map.put("cun","cun");
        map.put("idCard","id_card");
        map.put("sixFifteen","six_fifteen");
        map.put("headOfHouseNum","head_of_house_num");
        map.put("headOfHouseName","head_of_house_name");
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

        if ("ifDisability".equals(feild) && (!"是".equals(value) && !"否".equals(value))) {
            throw new GlobleException(CodeMsg.DISABILITY_NOT_RIGHT);
        }

        if ("thisEnjoy".equals(feild) && (!"是".equals(value) && !"否".equals(value))) {
            throw new GlobleException(CodeMsg.ENJOY_NOT_RIGHT);
        }
    }
}
