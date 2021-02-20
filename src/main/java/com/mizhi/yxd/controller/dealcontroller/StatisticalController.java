package com.mizhi.yxd.controller.dealcontroller;

import com.alibaba.fastjson.JSON;
import com.mizhi.yxd.service.StatisticService;
import com.mizhi.yxd.tools.BeanUtils;
import com.mizhi.yxd.tools.ExcelUtils;
import com.mizhi.yxd.tools.Layui;
import com.mizhi.yxd.vo.LearningPeriodInMizhiVo;
import com.mizhi.yxd.vo.LearningPeriodVo;
import com.mizhi.yxd.vo.SchoolPeriodInMizhiVo;
import com.mizhi.yxd.vo.StatisticQueryVo;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * @author yangxudong
 * @description:
 * @date 2021/2/12 19:07
 */
@RestController
@RequestMapping("/statistic")
@Api("统计相关api")
@Slf4j
public class StatisticalController {
    @Autowired
    private StatisticService statisticService;


    @PostMapping("/learningPeriod")
    public Object learningPeriod(StatisticQueryVo statisticQueryVo, HttpSession httpSession) {
        log.info("statistic learningPeriod query vo message:{}", JSON.toJSONString(statisticQueryVo));
        statisticQueryVo.setAccount((String) httpSession.getAttribute("account"));
        List<LearningPeriodVo> learningPeriodVos =  statisticService.learningPeriod(statisticQueryVo);
        Layui l = Layui.data(learningPeriodVos.size(), learningPeriodVos);
        return JSON.toJSON(l);
    }

    @PostMapping("/learningPeriodInMizhi")
    public Object learningPeriodInMizhi(StatisticQueryVo statisticQueryVo, HttpSession httpSession) {
        log.info("statistic learningPeriodInMizhi query vo message:{}", JSON.toJSONString(statisticQueryVo));
        statisticQueryVo.setAccount((String) httpSession.getAttribute("account"));
        List<LearningPeriodInMizhiVo> learningPeriodInMizhiVos =  statisticService.learningPeriodInMizhi(statisticQueryVo);
        Layui l = Layui.data(learningPeriodInMizhiVos.size(), learningPeriodInMizhiVos);
        return JSON.toJSON(l);
    }

    @PostMapping("/schoolPeriodInMizhi")
    public Object schoolPeriodInMizhi(StatisticQueryVo statisticQueryVo, HttpSession httpSession) {
        log.info("statistic schoolPeriodInMizhi query vo message:{}", JSON.toJSONString(statisticQueryVo));
        statisticQueryVo.setAccount((String) httpSession.getAttribute("account"));
        List<LearningPeriodInMizhiVo> learningPeriodInMizhiVos =  statisticService.schoolPeriodInMizhi(statisticQueryVo);
        Layui l = Layui.data(learningPeriodInMizhiVos.size(), learningPeriodInMizhiVos);
        return JSON.toJSON(l);
    }

    @PostMapping("/schoolPeriodInMizhiNotBuildCard")
    public Object schoolPeriodInMizhiNotBuildCard(StatisticQueryVo statisticQueryVo, HttpSession httpSession) {
        log.info("statistic schoolPeriodInMizhiNotBuildCard query vo message:{}", JSON.toJSONString(statisticQueryVo));
        statisticQueryVo.setAccount((String) httpSession.getAttribute("account"));
        List<LearningPeriodInMizhiVo> learningPeriodInMizhiVos =  statisticService.schoolPeriodInMizhiNotBuildCard(statisticQueryVo);
        Layui l = Layui.data(learningPeriodInMizhiVos.size(), learningPeriodInMizhiVos);
        return JSON.toJSON(l);
    }

    @GetMapping("/learningPeriod/export")
    public void exportLearningPeriod(@RequestParam String semester, HttpSession httpSession, HttpServletResponse response) throws IOException {
        StatisticQueryVo statisticQueryVo = getStatisticQueryVo(semester, httpSession);
        List<LearningPeriodVo> learningPeriodVos =  statisticService.learningPeriod(statisticQueryVo);
        ExcelUtils.exportExcel(learningPeriodVos, null, "统计信息", LearningPeriodVo.class, "米脂县户籍建档立卡学生分乡镇分学段人数统计", true, response);
    }


    @GetMapping("/learningPeriodInMizhi/export")
    public void exportLearningPeriodInMizhi(@RequestParam String semester, @RequestParam String nums, HttpSession httpSession, HttpServletResponse response) throws IOException {
        StatisticQueryVo statisticQueryVo = getStatisticQueryVo(semester, httpSession);
        List<LearningPeriodInMizhiVo> learningPeriodInMizhiVos =  statisticService.learningPeriodInMizhi(statisticQueryVo);
        ExcelUtils.exportExcel(learningPeriodInMizhiVos, null, "统计信息", LearningPeriodInMizhiVo.class, "米脂县户籍在米就读建档立卡学生分乡镇分学段资助汇总", true, response);
    }


    @GetMapping("/schoolPeriodInMizhi/export")
    public void exportSchoolPeriodInMizhi(@RequestParam String semester, HttpSession httpSession, HttpServletResponse response) throws IOException {
        StatisticQueryVo statisticQueryVo = getStatisticQueryVo(semester, httpSession);
        List<LearningPeriodInMizhiVo> learningPeriodInMizhiVos =  statisticService.schoolPeriodInMizhi(statisticQueryVo);
        if (CollectionUtils.isNotEmpty(learningPeriodInMizhiVos)) {
            List<SchoolPeriodInMizhiVo> schoolPeriodInMizhiVos = BeanUtils.copyProperties(learningPeriodInMizhiVos, SchoolPeriodInMizhiVo.class);
            ExcelUtils.exportExcel(schoolPeriodInMizhiVos, null, "统计信息", SchoolPeriodInMizhiVo.class, "米脂县就读建档立卡分学校分学段资助汇总", true, response);
        }
    }

    @GetMapping("/schoolPeriodInMizhiNotBuildCard/export")
    public void schoolPeriodInMizhiNotBuildCard(@RequestParam String semester, HttpSession httpSession, HttpServletResponse response) throws IOException {
        StatisticQueryVo statisticQueryVo = getStatisticQueryVo(semester, httpSession);
        List<LearningPeriodInMizhiVo> learningPeriodInMizhiVos =  statisticService.schoolPeriodInMizhiNotBuildCard(statisticQueryVo);
        if (CollectionUtils.isNotEmpty(learningPeriodInMizhiVos)) {
            List<SchoolPeriodInMizhiVo> schoolPeriodInMizhiVos = BeanUtils.copyProperties(learningPeriodInMizhiVos, SchoolPeriodInMizhiVo.class);
            ExcelUtils.exportExcel(schoolPeriodInMizhiVos, null, "统计信息", SchoolPeriodInMizhiVo.class, "米脂县就读建档立卡分学校分学段资助汇总", true, response);
        }
    }

    private StatisticQueryVo getStatisticQueryVo(@RequestParam String semester, HttpSession httpSession) {
        StatisticQueryVo statisticQueryVo = new StatisticQueryVo();
        statisticQueryVo.setAccount((String) httpSession.getAttribute("account"));
        statisticQueryVo.setSemester(semester);
        return statisticQueryVo;
    }
}
