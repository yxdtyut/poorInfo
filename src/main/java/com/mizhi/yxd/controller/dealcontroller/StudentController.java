package com.mizhi.yxd.controller.dealcontroller;

import com.alibaba.fastjson.JSON;
import com.mizhi.yxd.entity.SubPoor;
import com.mizhi.yxd.entity.SubUser;
import com.mizhi.yxd.request.StudentRequest;
import com.mizhi.yxd.result.Result;
import com.mizhi.yxd.service.StudentService;
import com.mizhi.yxd.tools.Layui;
import com.mizhi.yxd.vo.PoorExportVo;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.*;
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

    @PostMapping("/add")
    public Result<String> addPoorInfo(@RequestBody SubUser subUser) {
        log.info("add student:{}", JSON.toJSONString(subUser));
        subUser.validate();
        studentService.checkIdcardExist(Arrays.asList(subUser));
        studentService.insertPoorInfo(subUser);
        log.info("add student success");
        return Result.success("success");
    }

    @RequestMapping(value = "/download", method = RequestMethod.GET)
    public ResponseEntity<byte[]> downloadTemp(HttpServletRequest request) throws IOException {
        String path = getClass().getResource("/download/student.xlsx").getPath();
        String newFileName = "在校学生模板.xlsx";
        File file = FileUtils.getFile(path);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", new String(
                newFileName.getBytes("gbk"), "iso-8859-1"));
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),
                headers, HttpStatus.OK);
    }
}
