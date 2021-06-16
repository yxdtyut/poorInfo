package com.mizhi.yxd.tools;

import java.util.LinkedList;
import java.util.List;

/**
 * @author yangxudong
 * @description:
 * @date 2021/6/16 22:07
 */
public class SemesterUtil {
    private static List<String> semesterList = new LinkedList<>();

    static {
        semesterList.add("2021春");
        semesterList.add("2021秋");
        semesterList.add("2022春");
        semesterList.add("2022秋");
        semesterList.add("2023春");
        semesterList.add("2023秋");
        semesterList.add("2024春");
        semesterList.add("2024秋");
        semesterList.add("2025春");
        semesterList.add("2025秋");
        semesterList.add("2026春");
        semesterList.add("2026秋");
        semesterList.add("2027春");
        semesterList.add("2027秋");
        semesterList.add("2028春");
        semesterList.add("2028秋");
        semesterList.add("2029春");
        semesterList.add("2029秋");
        semesterList.add("2030春");
        semesterList.add("2030秋");
        semesterList.add("2031春");
        semesterList.add("2031秋");
        semesterList.add("2032春");
        semesterList.add("2032秋");
        semesterList.add("2033春");
        semesterList.add("2033秋");
        semesterList.add("2034春");
        semesterList.add("2034秋");
        semesterList.add("2035春");
        semesterList.add("2035秋");
    }

    public static boolean ifContain(String message) {
        return semesterList.contains(message);
    }
}
