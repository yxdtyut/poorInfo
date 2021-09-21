package com.mizhi.yxd.service;

import com.mizhi.yxd.entity.Semester;

import java.util.List;
import java.util.Map;

/**
 * @author yangxudong
 * @description:
 * @date 2021/9/21 13:42
 */
public interface SemesterService {

    List<Semester> querySemesterWithPage(Map<String,Object> map);

    int findCount();

    void updateSemester(Semester semester);

    String queryLockedByName(String name);

    boolean contains(String name);
}
