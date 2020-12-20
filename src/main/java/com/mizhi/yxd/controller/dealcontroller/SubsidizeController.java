package com.mizhi.yxd.controller.dealcontroller;

import com.alibaba.fastjson.JSON;
import com.mizhi.yxd.entity.SubSubsidize;
import com.mizhi.yxd.entity.SubsidizeAndPoor;
import com.mizhi.yxd.request.PoorRequest;
import com.mizhi.yxd.result.Result;
import com.mizhi.yxd.service.SubsidizeService;
import com.mizhi.yxd.tools.Layui;
import com.mizhi.yxd.vo.CreateSubsidizeVo;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yangxudong
 * @description:
 * @date 2020/12/15 22:12
 */
@RestController
@RequestMapping("/subsidize")
@Api("subsidize相关api")
@Slf4j
public class SubsidizeController {
    @Autowired
    private SubsidizeService subsidizeService;

    @PostMapping("/add")
    public Result<String> createSubsidize(@RequestBody CreateSubsidizeVo createSubsidizeVo) {
        SubSubsidize subSubsidize = new SubSubsidize();
        BeanUtils.copyProperties(createSubsidizeVo, subSubsidize);
        subsidizeService.createSubsidize(subSubsidize);
        return Result.success("success");
    }

    @PostMapping("/subsidizeInfo")
    public Object poorInfo(@RequestParam("limit") String limit, @RequestParam("page") String page
            , HttpSession httpSession, PoorRequest poorRequest) {
        int lim = Integer.parseInt(limit);
        int start = (Integer.parseInt(page) - 1) * lim;
        Map<String, Object> map = new HashMap<>();
        map.put("start", start);
        map.put("pagesize", lim);
        poorRequest.setAccount((String) httpSession.getAttribute("account"));
        List<SubsidizeAndPoor> subSubsidizes = subsidizeService.findByCondition(poorRequest);
        int total = subsidizeService.findCountByCondition(poorRequest);
        Layui l = Layui.data(total, subSubsidizes);
        return JSON.toJSON(l);
    }
}
