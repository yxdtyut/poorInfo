package com.mizhi.yxd.service.impl;

import com.mizhi.yxd.entity.SubUser;
import com.mizhi.yxd.mapper.StudentMapper;
import com.mizhi.yxd.request.StudentRequest;
import com.mizhi.yxd.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yangxudong
 * @description:
 * @date 2020/12/20 15:30
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<SubUser> findByCondition(StudentRequest studentRequest) {
        return studentMapper.findByCondition(studentRequest);
    }

    @Override
    public int findCountByCondition(StudentRequest studentRequest) {
        return studentMapper.findCountByCondition(studentRequest);
    }
}
