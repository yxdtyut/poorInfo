package com.mizhi.yxd.controller.dealcontroller;

import com.mizhi.yxd.entity.SubSubsidize;
import com.mizhi.yxd.result.Result;
import com.mizhi.yxd.service.SubsidizeService;
import com.mizhi.yxd.vo.CreateSubsidizeVo;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
