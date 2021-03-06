package com.mizhi.yxd.mapper;

import com.mizhi.yxd.entity.SubPoor;
import com.mizhi.yxd.entity.SubPoorExample;
import com.mizhi.yxd.request.PoorRequest;
import com.mizhi.yxd.vo.UpdatePoorVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface SubPoorMapper {
    int deleteByPrimaryKey(String id);

    void insertBatch(@Param("list") List<SubPoor> poors);

    List<SubPoor> selectByCondition(@Param("poor") PoorRequest poorRequest);

    int findCountByCondition(@Param("poor") PoorRequest poorRequest);

    void updateByField(@Param("poor") UpdatePoorVo updatePoorVo);

    int deleteByPoorIds(@Param("list") List<String> data);

    void insertPoorInfo(@Param("item") SubPoor subPoor);

    List<SubPoor> selectByConditionWithPage(@Param("poor") PoorRequest poorRequest, @Param("map") Map<String, Object> map);
}