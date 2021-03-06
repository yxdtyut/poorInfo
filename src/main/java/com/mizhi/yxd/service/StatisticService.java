package com.mizhi.yxd.service;

import com.mizhi.yxd.vo.LearningPeriodInMizhiVo;
import com.mizhi.yxd.vo.LearningPeriodVo;
import com.mizhi.yxd.vo.LearningPeriodWithSubsidizeVo;
import com.mizhi.yxd.vo.StatisticQueryVo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yangxudong
 * @description:
 * @date 2021/2/12 19:13
 */
public interface StatisticService {

    List<LearningPeriodVo> learningPeriod(StatisticQueryVo statisticQueryVo);

    List<LearningPeriodInMizhiVo> learningPeriodInMizhi(StatisticQueryVo statisticQueryVo);

    List<LearningPeriodInMizhiVo> schoolPeriodInMizhi(StatisticQueryVo statisticQueryVo);

    List<LearningPeriodInMizhiVo> schoolPeriodInMizhiNotBuildCard(StatisticQueryVo statisticQueryVo);

    List<LearningPeriodWithSubsidizeVo> learningPeriodWithSubsidize(StatisticQueryVo statisticQueryVo);
}
