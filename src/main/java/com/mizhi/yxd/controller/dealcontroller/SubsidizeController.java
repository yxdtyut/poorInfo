package com.mizhi.yxd.controller.dealcontroller;

import com.alibaba.fastjson.JSON;
import com.mizhi.yxd.entity.SubPoor;
import com.mizhi.yxd.entity.SubSubsidize;
import com.mizhi.yxd.entity.SubsidizeAndPoor;
import com.mizhi.yxd.exception.GlobleException;
import com.mizhi.yxd.request.PoorRequest;
import com.mizhi.yxd.result.CodeMsg;
import com.mizhi.yxd.result.Result;
import com.mizhi.yxd.service.PoorService;
import com.mizhi.yxd.service.SubsidizeService;
import com.mizhi.yxd.tools.Layui;
import com.mizhi.yxd.validate.ValueValidate;
import com.mizhi.yxd.vo.CreateSubsidizeVo;
import com.mizhi.yxd.vo.UpdatePoorVo;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    @Autowired
    private PoorService poorService;

    @PostMapping("/add")
    public Result<String> createSubsidize(@RequestBody CreateSubsidizeVo createSubsidizeVo, HttpSession httpSession) {
        if (StringUtils.isNotEmpty(createSubsidizeVo.getPoorId())) {
            SubSubsidize subSubsidize = new SubSubsidize();
            BeanUtils.copyProperties(createSubsidizeVo, subSubsidize);
            subsidizeService.createSubsidize(subSubsidize);
        } else {
            PoorRequest poorRequest = new PoorRequest();
            BeanUtils.copyProperties(createSubsidizeVo, poorRequest);
            poorRequest.setAccount((String) httpSession.getAttribute("account"));
            List<SubPoor> subPoors = poorService.findByCondition(poorRequest);
            if (CollectionUtils.isNotEmpty(subPoors)) {
                List<SubSubsidize> subSubsidizes = subPoors.stream().map(subPoor -> {
                    SubSubsidize subSubsidize = new SubSubsidize();
                    subSubsidize.setNutrimealMoney(createSubsidizeVo.getNutrimealMoney());
                    subSubsidize.setSubsidizeMoney(createSubsidizeVo.getSubsidizeMoney());
                    subSubsidize.setSubsidizeProject(createSubsidizeVo.getSubsidizeProject());
                    subSubsidize.setPoorId(subPoor.getId());
                    return subSubsidize;
                }).collect(Collectors.toList());
                subsidizeService.createSubsidizeBatch(subSubsidizes);
            } else {
                throw new GlobleException(CodeMsg.THERE_IS_NO_COUNT_ERROR);
            }
        }
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

    @DeleteMapping("/delete/{id}")
    public Result<Integer> deleteSubsidizeInfo(@PathVariable String id) {
        log.info("delete poor info, id:{}", id);
        int count = subsidizeService.deleteSubsidizeInfo(id);
        return Result.success(count);
    }

    @PostMapping("/deletes")
    public Result<Integer> deletePoolInfos(String nums) {
        String[] strings = nums.split(",");
        List<String> data = Arrays.asList(strings);
        int count = 0;
        if (data.size() > 0 && !data.contains("")) {
            count = subsidizeService.deleteByPoorIds(data);
        }
        return Result.success(count);
    }

    @PutMapping("/update")
    public Result<String> updatePoorInfo(UpdatePoorVo updatePoorVo, HttpSession httpSession) {
        log.info("update subsidize vo:{}", JSON.toJSONString(updatePoorVo));
        ValueValidate.validate(updatePoorVo);
        updatePoorVo.setAccount((String) httpSession.getAttribute("account"));
        updatePoorVo.setField(ValueValidate.map.get(updatePoorVo.getField()));
        if (ValueValidate.ifSubsidize(updatePoorVo)) {
            subsidizeService.updateByField(updatePoorVo);
        } else {
            poorService.updateByField(updatePoorVo);
        }
        return Result.success("success");
    }
}
