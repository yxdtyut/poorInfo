package com.mizhi.yxd.controller.dealcontroller;

import com.alibaba.fastjson.JSON;
import com.mizhi.yxd.service.StatisticService;
import com.mizhi.yxd.tools.Layui;
import com.mizhi.yxd.vo.LearningPeriodInMizhiVo;
import com.mizhi.yxd.vo.LearningPeriodVo;
import com.mizhi.yxd.vo.StatisticQueryVo;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
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
}
