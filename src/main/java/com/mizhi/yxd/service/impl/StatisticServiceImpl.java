package com.mizhi.yxd.service.impl;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.mizhi.yxd.mapper.StatisticMapper;
import com.mizhi.yxd.service.StatisticService;
import com.mizhi.yxd.tools.StatisticUtil;
import com.mizhi.yxd.vo.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
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
        List<LearningPeriodVo> learningPeriodVos = learningPeriodGeneral(learningPeriodRsps);
        return learningPeriodVos;
    }

    private List<LearningPeriodVo> learningPeriodGeneral(List<LearningPeriodRsp> learningPeriodRsps) {
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

    @Override
    public List<LearningPeriodInMizhiVo> learningPeriodInMizhi(StatisticQueryVo statisticQueryVo) {
        List<LearningPeriodInMizhiRsp> learningPeriodInMizhiRsps = statisticMapper.lerningPeriodInMizhi(statisticQueryVo);
        List<LearningPeriodInMizhiVo> learningPeriodInMizhiVos = getLearningPeriodInMizhiVos(learningPeriodInMizhiRsps);
        return learningPeriodInMizhiVos;
    }

    @Override
    public List<LearningPeriodInMizhiVo> schoolPeriodInMizhi(StatisticQueryVo statisticQueryVo) {
        List<LearningPeriodInMizhiRsp> learningPeriodInMizhiRsps = statisticMapper.schoolPeriodInMizhi(statisticQueryVo);
        List<LearningPeriodInMizhiVo> learningPeriodInMizhiVos = getLearningPeriodInMizhiVos(learningPeriodInMizhiRsps);
        return learningPeriodInMizhiVos;
    }

    @Override
    public List<LearningPeriodInMizhiVo> schoolPeriodInMizhiNotBuildCard(StatisticQueryVo statisticQueryVo) {
        List<LearningPeriodInMizhiRsp> learningPeriodInMizhiRsps = statisticMapper.schoolPeriodInMizhiNotBuildCard(statisticQueryVo);
        List<LearningPeriodInMizhiVo> learningPeriodInMizhiVos = getLearningPeriodInMizhiVos(learningPeriodInMizhiRsps);
        return learningPeriodInMizhiVos;
    }

    @Override
    public List<LearningPeriodWithSubsidizeVo> learningPeriodWithSubsidize(StatisticQueryVo statisticQueryVo) {
        List<LearningPeriodInMizhiRsp> learningPeriodInMizhiRsps = statisticMapper.learningPeriodWithSubsidize(statisticQueryVo);
        Multimap<String, LearningPeriodInMizhiRsp> multimap = ArrayListMultimap.create();
        learningPeriodInMizhiRsps.stream().forEach(periodRsp -> {
            multimap.put(periodRsp.getVillage(), periodRsp);
        });
        Map<String, Collection<LearningPeriodInMizhiRsp>> learningPeriodInMizhiRspMaps = multimap.asMap();
        List<LearningPeriodWithSubsidizeVo> learningPeriodWithSubsidizeVos = Lists.newArrayList();
        for (Map.Entry<String, Collection<LearningPeriodInMizhiRsp>> entry : learningPeriodInMizhiRspMaps.entrySet()) {
            String village = entry.getKey();
            LearningPeriodWithSubsidizeVo learningPeriodVo = judgeVillageWithSubsidizeExist(learningPeriodWithSubsidizeVos, village);
            Collection<LearningPeriodInMizhiRsp> periodRsps = entry.getValue();
            periodRsps.stream().forEach(learningPeriodInMizhiRsp -> {
                // 设置人数
                String studyLevelCount = StatisticUtil.learningPeriodWithSubsidize(learningPeriodInMizhiRsp.getStudyLevel() + "人数");
                if (StringUtils.isEmpty(studyLevelCount)) {
                    return;
                }
                assignmentToLearningPeriod(studyLevelCount, learningPeriodInMizhiRsp.getStatisticCount() ,learningPeriodVo);
                // 设置金额
                String studyLevelMoney = StatisticUtil.learningPeriodWithSubsidize(learningPeriodInMizhiRsp.getStudyLevel() + "资助金");
                assignmentToLearningPeriod(studyLevelMoney, learningPeriodInMizhiRsp.getTotalMoney() ,learningPeriodVo);
            });
            learningPeriodWithSubsidizeVos.add(learningPeriodVo);
        }
        // 创建总计
        LearningPeriodWithSubsidizeVo learningPeriodWithSubsidizeVo = new LearningPeriodWithSubsidizeVo();
        learningPeriodWithSubsidizeVo.setVillage("总计");
        Map<String, Integer> studyLevelWithCount = learningPeriodInMizhiRsps.stream().collect(Collectors.groupingBy(LearningPeriodInMizhiRsp::getStudyLevel, Collectors.summingInt(LearningPeriodInMizhiRsp::getStatisticCount)));
        Map<String, Double> studyLevelWithMoney = learningPeriodInMizhiRsps.stream().collect(Collectors.groupingBy(LearningPeriodInMizhiRsp::getStudyLevel, Collectors.summingDouble(LearningPeriodInMizhiRsp::getTotalMoney)));
        studyLevelWithCount.forEach((studyLevel,count) -> {
            String studyLevelPropertyCount = StatisticUtil.learningPeriodWithSubsidize(studyLevel + "人数");
            if (StringUtils.isEmpty(studyLevelPropertyCount)) {
                return;
            }
            assignmentToLearningPeriod(studyLevelPropertyCount, count, learningPeriodWithSubsidizeVo);
        });
        studyLevelWithMoney.forEach((studyLevel,money) -> {
            String studyLevelPropertyMoney = StatisticUtil.learningPeriodWithSubsidize(studyLevel + "资助金");
            if (StringUtils.isEmpty(studyLevelPropertyMoney)) {
                return;
            }
            assignmentToLearningPeriod(studyLevelPropertyMoney, money, learningPeriodWithSubsidizeVo);
        });
        learningPeriodWithSubsidizeVos.add(learningPeriodWithSubsidizeVo);
        // 设置横向total
        learningPeriodWithSubsidizeVos.stream().forEach(learningPeriodInMizhiVo1 -> {
            learningPeriodInMizhiVo1.finishTotal();
        });
        return learningPeriodWithSubsidizeVos;
    }

    private LearningPeriodWithSubsidizeVo judgeVillageWithSubsidizeExist(List<LearningPeriodWithSubsidizeVo> learningPeriodWithSubsidizeVos, String village) {
        for (LearningPeriodWithSubsidizeVo learningPeriodVo : learningPeriodWithSubsidizeVos) {
            if (StringUtils.isNotEmpty(learningPeriodVo.getVillage()) && learningPeriodVo.getVillage().equals(village)) {
                return learningPeriodVo;
            }
        }
        LearningPeriodWithSubsidizeVo learningPeriodVo = new LearningPeriodWithSubsidizeVo();
        learningPeriodVo.setVillage(village);
        return learningPeriodVo;
    }

    private List<LearningPeriodInMizhiVo> getLearningPeriodInMizhiVos(List<LearningPeriodInMizhiRsp> learningPeriodInMizhiRsps) {
        Multimap<String, LearningPeriodInMizhiRsp> multimap = ArrayListMultimap.create();
        learningPeriodInMizhiRsps.stream().forEach(periodRsp -> {
            multimap.put(periodRsp.getVillage(), periodRsp);
        });
        Map<String, Collection<LearningPeriodInMizhiRsp>> learningPeriodInMizhiRspMaps = multimap.asMap();
        List<LearningPeriodInMizhiVo> learningPeriodInMizhiVos = Lists.newArrayList();
        for (Map.Entry<String, Collection<LearningPeriodInMizhiRsp>> entry : learningPeriodInMizhiRspMaps.entrySet()) {
            String village = entry.getKey();
            LearningPeriodInMizhiVo learningPeriodVo = judgeVillageInMizhiExist(learningPeriodInMizhiVos, village);
            Collection<LearningPeriodInMizhiRsp> periodRsps = entry.getValue();
            periodRsps.stream().forEach(learningPeriodInMizhiRsp -> {
                // 设置人数
                String studyLevelCount = StatisticUtil.learningPeriodInMizhi(learningPeriodInMizhiRsp.getStudyLevel() + "人数");
                if (StringUtils.isEmpty(studyLevelCount)) {
                    return;
                }
                assignmentToLearningPeriod(studyLevelCount, learningPeriodInMizhiRsp.getStatisticCount() ,learningPeriodVo);
                // 设置金额
                String studyLevelMoney = StatisticUtil.learningPeriodInMizhi(learningPeriodInMizhiRsp.getStudyLevel() + "资助金");
                assignmentToLearningPeriod(studyLevelMoney, learningPeriodInMizhiRsp.getTotalMoney() ,learningPeriodVo);
            });
            learningPeriodInMizhiVos.add(learningPeriodVo);
        }
        // 创建总计
        LearningPeriodInMizhiVo learningPeriodInMizhiVo = new LearningPeriodInMizhiVo();
        learningPeriodInMizhiVo.setVillage("总计");
        Map<String, Integer> studyLevelWithCount = learningPeriodInMizhiRsps.stream().collect(Collectors.groupingBy(LearningPeriodInMizhiRsp::getStudyLevel, Collectors.summingInt(LearningPeriodInMizhiRsp::getStatisticCount)));
        Map<String, Double> studyLevelWithMoney = learningPeriodInMizhiRsps.stream().collect(Collectors.groupingBy(LearningPeriodInMizhiRsp::getStudyLevel, Collectors.summingDouble(LearningPeriodInMizhiRsp::getTotalMoney)));
        studyLevelWithCount.forEach((studyLevel,count) -> {
            String studyLevelPropertyCount = StatisticUtil.learningPeriodInMizhi(studyLevel + "人数");
            if (StringUtils.isEmpty(studyLevelPropertyCount)) {
                return;
            }
            assignmentToLearningPeriod(studyLevelPropertyCount, count, learningPeriodInMizhiVo);
        });
        studyLevelWithMoney.forEach((studyLevel,money) -> {
            String studyLevelPropertyMoney = StatisticUtil.learningPeriodInMizhi(studyLevel + "资助金");
            if (StringUtils.isEmpty(studyLevelPropertyMoney)) {
                return;
            }
            assignmentToLearningPeriod(studyLevelPropertyMoney, money, learningPeriodInMizhiVo);
        });
        learningPeriodInMizhiVos.add(learningPeriodInMizhiVo);
        // 设置横向total
        learningPeriodInMizhiVos.stream().forEach(learningPeriodInMizhiVo1 -> {
            learningPeriodInMizhiVo1.finishTotal();
        });
        return learningPeriodInMizhiVos;
    }

    private LearningPeriodInMizhiVo judgeVillageInMizhiExist(List<LearningPeriodInMizhiVo> learningPeriodInMizhiVos, String village) {
        for (LearningPeriodInMizhiVo learningPeriodVo : learningPeriodInMizhiVos) {
            if (StringUtils.isNotEmpty(learningPeriodVo.getVillage()) && learningPeriodVo.getVillage().equals(village)) {
                return learningPeriodVo;
            }
        }
        LearningPeriodInMizhiVo learningPeriodInMizhiVo = new LearningPeriodInMizhiVo();
        learningPeriodInMizhiVo.setVillage(village);
        return learningPeriodInMizhiVo;
    }

    private <T, R> void assignmentToLearningPeriod(String studyLevel, R value, T target) {
        Class clazz = target.getClass();
        try {
            Method method = clazz.getMethod("set" + studyLevel.toUpperCase().substring(0, 1)+ studyLevel.substring(1), value.getClass());
            method.setAccessible(true);
            method.invoke(target, value);
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
