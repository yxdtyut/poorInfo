package com.mizhi.yxd.mapper;

import com.mizhi.yxd.vo.LearningPeriodInMizhiRsp;
import com.mizhi.yxd.vo.LearningPeriodRsp;
import com.mizhi.yxd.vo.StatisticQueryVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author yangxudong
 * @description:
 * @date 2021/2/12 19:21
 */
@Mapper
public interface StatisticMapper {
    List<LearningPeriodRsp> learningPeriod(@Param("vo") StatisticQueryVo statisticQueryVo);

    List<LearningPeriodInMizhiRsp> lerningPeriodInMizhi(@Param("vo") StatisticQueryVo statisticQueryVo);

    List<LearningPeriodInMizhiRsp> schoolPeriodInMizhi(@Param("vo")StatisticQueryVo statisticQueryVo);

    List<LearningPeriodInMizhiRsp> schoolPeriodInMizhiNotBuildCard(@Param("vo")StatisticQueryVo statisticQueryVo);

    List<LearningPeriodInMizhiRsp> learningPeriodWithSubsidize(@Param("vo") StatisticQueryVo statisticQueryVo);
}
