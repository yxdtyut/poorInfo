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
    private static Map<String, String> learningPeriodInMizhiMap = Maps.newHashMap();
    private static Map<String, String> learningPeriodWithSubsidizeMap = Maps.newHashMap();
    static {
        learningPeriodMap.put("学前", "kindergarten");
        learningPeriodMap.put("小学", "primarySchool");
        learningPeriodMap.put("初中", "juniorHighSchool");
        learningPeriodMap.put("普高", "highSchool");
        learningPeriodMap.put("中职", "juniorProfession");
        learningPeriodMap.put("高职", "highProfession");
        learningPeriodMap.put("本科", "undergraduate");
        learningPeriodMap.put("研究生", "graduate");
        learningPeriodMap.put("博士", "doctor");
        learningPeriodMap.put("特殊教育", "specialEducation");

        learningPeriodInMizhiMap.put("学前人数", "kindergartenCount");
        learningPeriodInMizhiMap.put("小学人数", "primarySchoolCount");
        learningPeriodInMizhiMap.put("初中人数", "juniorHighSchoolCount");
        learningPeriodInMizhiMap.put("普高人数", "highSchoolCount");
        learningPeriodInMizhiMap.put("中职人数", "juniorProfessionCount");

        learningPeriodWithSubsidizeMap.put("学前人数", "kindergartenCount");
        learningPeriodWithSubsidizeMap.put("小学人数", "primarySchoolCount");
        learningPeriodWithSubsidizeMap.put("初中人数", "juniorHighSchoolCount");
        learningPeriodWithSubsidizeMap.put("普高人数", "highSchoolCount");
        learningPeriodWithSubsidizeMap.put("中职人数", "juniorProfessionCount");
        learningPeriodWithSubsidizeMap.put("高职人数", "highProfessionCount");
        learningPeriodWithSubsidizeMap.put("本科人数", "undergraduateCount");
        learningPeriodWithSubsidizeMap.put("研究生人数", "graduateCount");
        learningPeriodWithSubsidizeMap.put("特殊教育人数", "specialEducationCount");
        learningPeriodWithSubsidizeMap.put("博士人数", "doctorCount");

        learningPeriodInMizhiMap.put("学前资助金", "kindergartenMoney");
        learningPeriodInMizhiMap.put("小学资助金", "primarySchoolMoney");
        learningPeriodInMizhiMap.put("初中资助金", "juniorHighSchoolMoney");
        learningPeriodInMizhiMap.put("普高资助金", "highSchoolMoney");
        learningPeriodInMizhiMap.put("中职资助金", "juniorProfessionMoney");

        learningPeriodWithSubsidizeMap.put("学前资助金", "kindergartenMoney");
        learningPeriodWithSubsidizeMap.put("小学资助金", "primarySchoolMoney");
        learningPeriodWithSubsidizeMap.put("初中资助金", "juniorHighSchoolMoney");
        learningPeriodWithSubsidizeMap.put("普高资助金", "highSchoolMoney");
        learningPeriodWithSubsidizeMap.put("中职资助金", "juniorProfessionMoney");
        learningPeriodWithSubsidizeMap.put("高职资助金", "highProfessionMoney");
        learningPeriodWithSubsidizeMap.put("本科资助金", "undergraduateMoney");
        learningPeriodWithSubsidizeMap.put("研究生资助金", "graduateMoney");
        learningPeriodWithSubsidizeMap.put("特殊教育资助金", "specialEducationMoney");
        learningPeriodWithSubsidizeMap.put("博士资助金", "doctorMoney");
    }

    public static String learningPeriod(String key) {
        return learningPeriodMap.get(key);
    }

    public static String learningPeriodInMizhi(String key) {
        return learningPeriodInMizhiMap.get(key);
    }

    public static String learningPeriodWithSubsidize(String key) {
        return learningPeriodWithSubsidizeMap.get(key);
    }
}
