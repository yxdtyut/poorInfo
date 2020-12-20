package com.mizhi.yxd.service;

import com.mizhi.yxd.entity.SubUser;
import com.mizhi.yxd.request.StudentRequest;
import com.mizhi.yxd.vo.UpdatePoorVo;

import java.util.List;

/**
 * @author yangxudong
 * @description:
 * @date 2020/12/20 15:29
 */
public interface StudentService {
    List<SubUser> findByCondition(StudentRequest studentRequest);

    int findCountByCondition(StudentRequest studentRequest);

    void insertPoorInfo(SubUser subUser);

    void checkIdcardExist(List<SubUser> subUsers);

    int deleteStudentById(String id);

    int deleteByPoorIds(List<String> data);

    void updateByField(UpdatePoorVo updatePoorVo);

    void insertBatch(List<SubUser> users);
}
