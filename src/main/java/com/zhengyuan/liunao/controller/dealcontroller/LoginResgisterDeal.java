package com.zhengyuan.liunao.controller.dealcontroller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.zhengyuan.liunao.exception.GlobelException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.multipart.MultipartFile;
import com.zhengyuan.liunao.config.WebSecurityConfig;
import com.alibaba.fastjson.JSON;
import com.zhengyuan.liunao.entity.Admin;
import com.zhengyuan.liunao.entity.Stu;
import com.zhengyuan.liunao.entity.Teacher;
import com.zhengyuan.liunao.service.AdminService;
import com.zhengyuan.liunao.service.StuService;
import com.zhengyuan.liunao.service.TeacherService;
import com.zhengyuan.liunao.tools.MyTool;

import cn.hutool.crypto.SecureUtil;

@Controller
@RequestMapping("/Sys")
@Slf4j
public class LoginResgisterDeal {

	@Autowired
	AdminService adminService;

	@Autowired
	StuService stuService;

	@Autowired
	TeacherService teacherService;

    @ResponseBody
	@RequestMapping(value = "/dealLogin")
	public String getInfo(@RequestParam(value = "num") String num, @RequestParam(value = "psw") String psw,
			@RequestParam(value = "identify") Integer identify, HttpSession httpSession) {
		String dataJson = "fail";
		Admin admin = adminService.findAdmin(num, SecureUtil.md5(psw), identify);
		if (null == admin) {
			log.error("count find user by account:{}", num);
			throw new GlobelException("can not find user");
		}
		String account = admin.getAccount();
		String name = admin.getName();
		httpSession.setAttribute("account", account);
		httpSession.setAttribute("name", name);
		httpSession.setAttribute("photo", identify == 0?"admin.png":"normal.png");
		httpSession.setAttribute("role", identify == 0?"admin":"normal");
		dataJson = JSON.toJSONString(admin);
		return dataJson;
	}
	
	
	@RequestMapping(value = "/registUser")
	@ResponseBody
	public String registUser(@RequestBody Map map) {
		log.info("regist info: {}", JSON.toJSONString(map));
		map.put("psw", SecureUtil.md5(map.get("psw").toString()));
		// 查询用户是否存在
		int count = adminService.queryCountByAccount((String) map.get("account"));
		if (count > 0) {
			log.error("this account already be registed, account:{}", JSON.toJSONString(map.get("account")));
			throw new GlobelException("this account already be registed");
		}
		if (adminService.registUser(map) > 0) {
			return "success";
		}
		return "failure";
	}
	
	@RequestMapping(value = "/uploadImg", method = RequestMethod.POST)
	public @ResponseBody Object updatePersonal(@RequestParam("photo") MultipartFile file, HttpServletRequest request)
			throws IllegalStateException, IOException {
		Map<String, Object> map = new HashMap<String, Object>();
		String name = System.currentTimeMillis() + "_" + file.getOriginalFilename();

		String imgAbsolutePath = MyTool.SaveImg(file, MyTool.getImg(), name);
		map.put("code", 0);
		map.put("message", "上传成功");
		map.put("data", name);
		return map;
	}
	
	@RequestMapping(value = "/registerTeaDeal")
	@ResponseBody
	public String registerTeaDeal(@RequestBody Map map) {
		System.out.println("teacher psw:"+map.get("psw"));
		map.put("psw", SecureUtil.md5(map.get("psw").toString()));
		
		if (teacherService.addTeacher(map) > 0) {
			return "success";
		}

		return "failure";
	}

}
