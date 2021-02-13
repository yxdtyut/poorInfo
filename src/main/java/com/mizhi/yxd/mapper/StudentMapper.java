package com.mizhi.yxd.mapper;

import com.mizhi.yxd.entity.SubUser;
import com.mizhi.yxd.request.StudentRequest;
import com.mizhi.yxd.vo.UpdatePoorVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

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

    int deleteStudentById(@Param("id") String id);

    int deleteByPoorIds(@Param("list") List<String> data);

    void updateByField(@Param("poor") UpdatePoorVo updatePoorVo);

    void insertBatch(@Param("list") List<SubUser> users);

    List<SubUser> findByConditionWithPage(@Param("student")StudentRequest studentRequest, @Param("map") Map<String,Object> map);
}
