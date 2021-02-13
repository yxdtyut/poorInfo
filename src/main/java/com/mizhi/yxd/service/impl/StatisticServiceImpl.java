package com.mizhi.yxd.service.impl;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.mizhi.yxd.mapper.StatisticMapper;
import com.mizhi.yxd.service.StatisticService;
import com.mizhi.yxd.tools.StatisticUtil;
import com.mizhi.yxd.vo.LearningPeriodRsp;
import com.mizhi.yxd.vo.LearningPeriodVo;
import com.mizhi.yxd.vo.StatisticQueryVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author yangxudong
 * @description:
 * @date 2021/2/12 19:21
 */
@Service
@Slf4j
public class StatisticServiceImpl implements StatisticService {

    @Autowired
    private StatisticMapper statisticMapper;

    @Override
    public List<LearningPeriodVo> learningPeriod(StatisticQueryVo statisticQueryVo) {
        List<LearningPeriodRsp> learningPeriodRsps = statisticMapper.learningPeriod(statisticQueryVo);
        Multimap<String, LearningPeriodRsp> multimap = ArrayListMultimap.create();
        learningPeriodRsps.stream().forEach(periodRsp -> {
            multimap.put(periodRsp.getVillage(), periodRsp);
        });
        Map<String, Collection<LearningPeriodRsp>> learningPeriodRspMaps = multimap.asMap();
        List<LearningPeriodVo> learningPeriodVos = Lists.newArrayList();
        for (Map.Entry<String, Collection<LearningPeriodRsp>> entry : learningPeriodRspMaps.entrySet()) {
            String village = entry.getKey();
            LearningPeriodVo learningPeriodVo = judgeVillageExist(learningPeriodVos, village);
            Collection<LearningPeriodRsp> periodRsps = entry.getValue();
            periodRsps.stream().forEach(learningPeriodRsp -> {
                String studyLevel = StatisticUtil.learningPeriod(learningPeriodRsp.getStudyLevel());
                assignmentToLearningPeriod(studyLevel,learningPeriodRsp.getStatisticCount() ,learningPeriodVo);
            });
            learningPeriodVos.add(learningPeriodVo);
        }
        // 创建总计
        LearningPeriodVo learningPeriodVo = new LearningPeriodVo();
        learningPeriodVo.setVillage("总计");
        Map<String, Integer> studyLevelWithCount = learningPeriodRsps.stream().collect(Collectors.groupingBy(LearningPeriodRsp::getStudyLevel, Collectors.summingInt(LearningPeriodRsp::getStatisticCount)));
        studyLevelWithCount.forEach((studyLevel,count) -> {
            String studyLevelProperty = StatisticUtil.learningPeriod(studyLevel);
            assignmentToLearningPeriod(studyLevelProperty, count, learningPeriodVo);
        });
        learningPeriodVos.add(learningPeriodVo);
        // 设置横向total
        learningPeriodVos.stream().forEach(LearningPeriodVo::finishTotal);
        return learningPeriodVos;
    }

    private void assignmentToLearningPeriod(String studyLevel, int count, LearningPeriodVo learningPeriodVo) {
        Class clazz = learningPeriodVo.getClass();
        try {
            Method method = clazz.getMethod("set" + studyLevel.toUpperCase().substring(0, 1)+ studyLevel.substring(1), int.class);
            method.setAccessible(true);
            method.invoke(learningPeriodVo, count);
        } catch (NoSuchMethodException e) {
            log.error("assignment can't find method, studyLevel:{}", studyLevel);
        } catch (IllegalAccessException e) {
            log.error("assignment IllegalAccessException:{}", e.getMessage());
        } catch (InvocationTargetException e) {
            log.error("assignment InvocationTargetException:{}", e.getMessage());
        }

    }

    private LearningPeriodVo judgeVillageExist(List<LearningPeriodVo> learningPeriodVos, String village) {
        for (LearningPeriodVo learningPeriodVo : learningPeriodVos) {
            if (StringUtils.isNotEmpty(learningPeriodVo.getVillage()) && learningPeriodVo.getVillage().equals(village)) {
                return learningPeriodVo;
            }
        }
        LearningPeriodVo learningPeriodVo = new LearningPeriodVo();
        learningPeriodVo.setVillage(village);
        return learningPeriodVo;
    }
}
