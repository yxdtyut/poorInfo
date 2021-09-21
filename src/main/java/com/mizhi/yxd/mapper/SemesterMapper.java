package com.mizhi.yxd.mapper;

import com.mizhi.yxd.entity.Semester;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface SemesterMapper {
    List<Semester> querySemesterWithPage(@Param("map") Map<String, Object> map);

    int findCount();

    void updateSemester(@Param("semester") Semester semester);

    String queryLockedByName(@Param("name") String name);

    int findCountByCondition(@Param("name") String name);
}
