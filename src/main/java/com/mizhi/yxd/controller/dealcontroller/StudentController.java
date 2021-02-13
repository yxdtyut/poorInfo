package com.mizhi.yxd.controller.dealcontroller;

import com.alibaba.fastjson.JSON;
import com.mizhi.yxd.entity.SubPoor;
import com.mizhi.yxd.entity.SubUser;
import com.mizhi.yxd.request.PoorRequest;
import com.mizhi.yxd.request.StudentRequest;
import com.mizhi.yxd.result.Result;
import com.mizhi.yxd.service.StudentService;
import com.mizhi.yxd.tools.BeanUtils;
import com.mizhi.yxd.tools.ExcelUtils;
import com.mizhi.yxd.tools.FileUtil;
import com.mizhi.yxd.tools.Layui;
import com.mizhi.yxd.validate.ValueValidate;
import com.mizhi.yxd.vo.StudentExportVo;
import com.mizhi.yxd.vo.UpdatePoorVo;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

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
        List<SubUser> subUsers = studentService.findByConditionWithPage(studentRequest, map);
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
    public ResponseEntity<byte[]> downloadTemp() throws IOException {
        String filename = "student.xlsx";
        FileUtil.downloadByFileName(filename);
        return null;
    }

    @DeleteMapping("/delete/{id}")
    public Result<Integer> deletePoorInfo(@PathVariable String id) {
        log.info("delete student info, id:{}", id);
        int count = studentService.deleteStudentById(id);
        return Result.success(count);
    }

    @PostMapping("/deletes")
    public Result<Integer> deletePoolInfos(String nums) {
        String[] strings = nums.split(",");
        List<String> data = Arrays.asList(strings);
        int count = 0;
        if (data.size() > 0 && !data.contains("")) {
            count = studentService.deleteByPoorIds(data);
        }
        return Result.success(count);
    }

    @PutMapping("/update")
    public Result<String> updatePoorInfo(UpdatePoorVo updatePoorVo) {
        log.info("update student vo:{}", JSON.toJSONString(updatePoorVo));
        ValueValidate.validateStudent(updatePoorVo);
        updatePoorVo.setField(ValueValidate.studentMap.get(updatePoorVo.getField()));
        studentService.updateByField(updatePoorVo);
        return Result.success("success");
    }

    @PostMapping("/import")
    public Result<String> importExcel(MultipartFile file, HttpSession httpSession) throws IOException {
        List<StudentExportVo> exportVoList = ExcelUtils.importExcel(file, StudentExportVo.class);
        exportVoList.stream().forEach(studentExportVo -> studentExportVo.validate());
        final List<SubUser> users = BeanUtils.copyProperties(exportVoList, SubUser.class);
        log.info("import, student:{}", JSON.toJSONString(users));
        studentService.checkIdcardExist(users);
        studentService.insertBatch(users);
        log.info("import message success");
        return Result.success("success");
    }

    @GetMapping("/export")
    public void exportPoorInfo(@RequestParam String nums, HttpServletResponse response) throws IOException {
        StudentRequest request = new StudentRequest();
        String[] strings = nums.split(",");
        List<String> data = Arrays.asList(strings);
        if (data.size() > 0 && !data.contains("")) {
            request.setIds(data);
        }
        List<SubUser> subUsers = studentService.findByCondition(request);
        List<StudentExportVo> studentExportVos = BeanUtils.copyProperties(subUsers, StudentExportVo.class);
        ExcelUtils.exportExcel(studentExportVos, null, "在校学生", StudentExportVo.class, "在校学生信息", true, response);
    }
}
