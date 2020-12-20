package com.mizhi.yxd.service;

import com.mizhi.yxd.entity.SubUser;
import com.mizhi.yxd.request.StudentRequest;

import java.util.List;

/**
 * @author yangxudong
 * @description:
 * @date 2020/12/20 15:29
 */
public interface StudentService {
    List<SubUser> findByCondition(StudentRequest studentRequest);

    int findCountByCondition(StudentRequest studentRequest);
}
