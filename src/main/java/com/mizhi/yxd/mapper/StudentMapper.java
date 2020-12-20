package com.mizhi.yxd.mapper;

import com.mizhi.yxd.entity.SubUser;
import com.mizhi.yxd.request.StudentRequest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author yangxudong
 * @description:
 * @date 2020/12/20 15:32
 */
@Mapper
public interface StudentMapper {
    List<SubUser> findByCondition(@Param("student") StudentRequest studentRequest);

    int findCountByCondition(@Param("student") StudentRequest studentRequest);

    void insertStudentInfo(@Param("user") SubUser subUser);

    List<SubUser> quaryAll();
}
