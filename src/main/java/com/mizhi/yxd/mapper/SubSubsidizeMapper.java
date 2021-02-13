package com.mizhi.yxd.mapper;

import com.mizhi.yxd.entity.SubSubsidize;
import com.mizhi.yxd.entity.SubSubsidizeExample;
import com.mizhi.yxd.entity.SubsidizeAndPoor;
import com.mizhi.yxd.request.PoorRequest;
import com.mizhi.yxd.vo.UpdatePoorVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface SubSubsidizeMapper {
    int countByExample(SubSubsidizeExample example);

    int deleteByExample(SubSubsidizeExample example);

    int deleteByPrimaryKey(String poorId);

    int insert(SubSubsidize record);

    int insertSelective(SubSubsidize record);

    List<SubSubsidize> selectByExample(SubSubsidizeExample example);

    SubSubsidize selectByPrimaryKey(String poorId);

    int updateByExampleSelective(@Param("record") SubSubsidize record, @Param("example") SubSubsidizeExample example);

    int updateByExample(@Param("record") SubSubsidize record, @Param("example") SubSubsidizeExample example);

    int updateByPrimaryKeySelective(SubSubsidize record);

    int updateByPrimaryKey(SubSubsidize record);

    List<SubsidizeAndPoor> findByCondition(@Param("poor") PoorRequest poorRequest);

    int findCountByCondition(@Param("poor") PoorRequest poorRequest);

    int deleteByPoorIds(@Param("list") List<String> data);

    void updateByField(@Param("poor") UpdatePoorVo updatePoorVo);

    void createSubsidizeBatch(@Param("list") List<SubSubsidize> subSubsidizes);

    List<SubsidizeAndPoor> findByConditionWithPage(@Param("poor")PoorRequest poorRequest,@Param("map") Map<String,Object> map);
}