package com.mizhi.yxd.service;

import com.mizhi.yxd.vo.LearningPeriodVo;
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
}
