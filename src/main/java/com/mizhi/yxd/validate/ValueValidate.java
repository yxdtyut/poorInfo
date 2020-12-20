package com.mizhi.yxd.validate;

import com.mizhi.yxd.exception.GlobleException;
import com.mizhi.yxd.result.CodeMsg;
import com.mizhi.yxd.tools.ValidateUtils;
import com.mizhi.yxd.vo.UpdatePoorVo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yangxudong
 * @description:
 * @date 2020/12/12 14:30
 */
public class ValueValidate {
    public static Map<String, String> map = new HashMap<>();
    public static List<String> subsidizeList = new ArrayList<>();

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
        map.put("subsidizeProject","subsidize_project");
        map.put("subsidizeMoney","subsidize_money");
        map.put("nutrimealMoney","nutrimeal_money");

        subsidizeList.add("subsidize_project");
        subsidizeList.add("subsidize_money");
        subsidizeList.add("nutrimeal_money");
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

        if ("subsidizeMoney".equals(feild) && !value.matches("([1-9]\\d*\\.?\\d*)|(0\\.\\d*[1-9])")) {
            throw new GlobleException(CodeMsg.DECIMAL_NOT_RIGHT_ERROR);
        }

        if ("nutrimealMoney".equals(feild) && !value.matches("([1-9]\\d*\\.?\\d*)|(0\\.\\d*[1-9])")) {
            throw new GlobleException(CodeMsg.DECIMAL_NOT_RIGHT_ERROR);
        }
    }

    public static boolean ifSubsidize(UpdatePoorVo poolVo) {
        return subsidizeList.contains(poolVo.getField());
    }
}
