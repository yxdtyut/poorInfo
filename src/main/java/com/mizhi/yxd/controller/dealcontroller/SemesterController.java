package com.mizhi.yxd.controller.dealcontroller;

import com.alibaba.fastjson.JSON;
import com.mizhi.yxd.entity.Semester;
import com.mizhi.yxd.result.Result;
import com.mizhi.yxd.service.SemesterService;
import com.mizhi.yxd.tools.Layui;
import com.mizhi.yxd.validate.ValueValidate;
import com.mizhi.yxd.vo.UpdatePoorVo;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yangxudong
 * @description:
 * @date 2021/9/21 13:57
 */
@RestController
@RequestMapping("/semester")
@Api("semester相关api")
@Slf4j
public class SemesterController {

    @Autowired
    SemesterService semesterService;

    @PostMapping(value = "/semesterManager")
    @ResponseBody
    public Object semesterManager(@RequestParam("limit") String limit, @RequestParam("page") String page
            , HttpSession httpSession) {
        int lim = Integer.parseInt(limit);
        int start = (Integer.parseInt(page) - 1) * lim;
        Map<String, Object> map = new HashMap<>();
        map.put("start", start);
        map.put("pagesize", lim);
        List<Semester> semesters = semesterService.querySemesterWithPage(map);
        int total = semesterService.findCount();
        Layui l = Layui.data(total, semesters);
        return JSON.toJSON(l);
    }

    @PutMapping("/update")
    public Result<String> updatePoorInfo(Semester semester, HttpSession httpSession) {
        log.info("update semester vo:{}", JSON.toJSONString(semester));
        semesterService.updateSemester(semester);
        return Result.success("success");
    }
}
