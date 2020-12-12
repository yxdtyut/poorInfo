package com.mizhi.yxd.tools;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author yangxudong
 * @description:
 * @date 2020/11/1 13:48
 */
public class ValidateUtils {
    public static boolean checkIdCard(String text) {
        Pattern patternSfzhm1 = Pattern
                .compile("^[1-9]\\d{7}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}$");
        Pattern patternSfzhm2 = Pattern
                .compile("^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}([0-9]|X)$");
        Matcher matcherSfzhm1 = patternSfzhm1.matcher(text);
        Matcher matcherSfzhm2 = patternSfzhm2.matcher(text);
        if(!matcherSfzhm1.find() && !matcherSfzhm2.find())
            return false;
        else return true;
    }
}
