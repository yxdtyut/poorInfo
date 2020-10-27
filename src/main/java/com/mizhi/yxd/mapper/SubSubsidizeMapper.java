package com.mizhi.yxd.mapper;

import com.mizhi.yxd.entity.SubSubsidize;
import com.mizhi.yxd.entity.SubSubsidizeExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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
}