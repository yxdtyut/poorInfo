package com.mizhi.yxd.mapper;

import com.mizhi.yxd.entity.SubPoor;
import com.mizhi.yxd.entity.SubPoorExample;
import com.mizhi.yxd.request.PoorRequest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SubPoorMapper {
    int countByExample(SubPoorExample example);

    int deleteByExample(SubPoorExample example);

    int deleteByPrimaryKey(String id);

    int insert(SubPoor record);

    int insertSelective(SubPoor record);

    List<SubPoor> selectByExample(SubPoorExample example);

    SubPoor selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SubPoor record, @Param("example") SubPoorExample example);

    int updateByExample(@Param("record") SubPoor record, @Param("example") SubPoorExample example);

    int updateByPrimaryKeySelective(SubPoor record);

    int updateByPrimaryKey(SubPoor record);

    void insertBatch(@Param("list") List<SubPoor> poors);

    List<SubPoor> selectByCondition(@Param("poor") PoorRequest poorRequest);

    int findCountByCondition(@Param("poor")PoorRequest  poorRequest);
}