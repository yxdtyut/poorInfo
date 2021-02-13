package com.mizhi.yxd.tools;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * @author yangxudong
 * @description:
 * @date 2021/2/12 19:48
 */
public class StatisticUtil {
    private static Map<String, String> learningPeriodMap = Maps.newHashMap();
    static {
        learningPeriodMap.put("学前", "kindergarten");
        learningPeriodMap.put("小学", "primarySchool");
        learningPeriodMap.put("初中", "juniorHighSchool");
        learningPeriodMap.put("普高", "highSchool");
        learningPeriodMap.put("中职", "juniorProfession");
        learningPeriodMap.put("高职", "highProfession");
        learningPeriodMap.put("本科", "undergraduate");
        learningPeriodMap.put("研究生", "graduate");
        learningPeriodMap.put("特殊教育", "specialEducation");
    }

    public static String learningPeriod(String key) {
        return learningPeriodMap.get(key);
    }
}
