package com.mizhi.yxd.controller.dealcontroller;

import com.alibaba.fastjson.JSON;
import com.mizhi.yxd.entity.SubPoor;
import com.mizhi.yxd.entity.SubUser;
import com.mizhi.yxd.request.StudentRequest;
import com.mizhi.yxd.service.StudentService;
import com.mizhi.yxd.tools.Layui;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author yangxudong
 * @description:
 * @date 2020/12/20 15:04
 */
@RestController
@RequestMapping("/student")
@Api("学生相关api")
@Slf4j
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/studentInfo")
    public Object poorInfo(@RequestParam("limit") String limit, @RequestParam("page") String page
            , StudentRequest studentRequest) {
        int lim = Integer.parseInt(limit);
        int start = (Integer.parseInt(page) - 1) * lim;
        Map<String, Object> map = new HashMap<>();
        map.put("start", start);
        map.put("pagesize", lim);
        List<SubUser> subUsers = studentService.findByCondition(studentRequest);
        int total = studentService.findCountByCondition(studentRequest);
        Layui l = Layui.data(total, subUsers);
        return JSON.toJSON(l);
    }
}
