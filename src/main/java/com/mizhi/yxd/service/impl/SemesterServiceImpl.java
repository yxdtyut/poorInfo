package com.mizhi.yxd.service.impl;

import com.mizhi.yxd.entity.Semester;
import com.mizhi.yxd.mapper.SemesterMapper;
import com.mizhi.yxd.service.SemesterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author yangxudong
 * @description:
 * @date 2021/9/21 13:42
 */
@Service
public class SemesterServiceImpl implements SemesterService {
    @Autowired
    SemesterMapper semesterMapper;

    @Override
    public List<Semester> querySemesterWithPage(Map<String, Object> map) {
        return semesterMapper.querySemesterWithPage(map);
    }

    @Override
    public int findCount() {
        return semesterMapper.findCount();
    }

    @Override
    public void updateSemester(Semester semester) {
        semesterMapper.updateSemester(semester);
    }

    @Override
    public String queryLockedByName(String name) {
        return semesterMapper.queryLockedByName(name);
    }

    @Override
    public boolean contains(String name) {
        return semesterMapper.findCountByCondition(name) > 0? true: false;
    }
}
