package com.mizhi.yxd.controller.dealcontroller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.mizhi.yxd.exception.GlobleException;
import com.mizhi.yxd.result.CodeMsg;
import com.mizhi.yxd.result.Result;
import com.mizhi.yxd.tools.MyTool;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.alibaba.fastjson.JSON;
import com.mizhi.yxd.entity.Admin;
import com.mizhi.yxd.service.AdminService;

import cn.hutool.crypto.SecureUtil;

@Controller
@RequestMapping("/Sys")
@Slf4j
public class LoginResgisterDeal {

	@Autowired
	AdminService adminService;


    @ResponseBody
	@RequestMapping(value = "/dealLogin")
	public Result getInfo(@RequestParam(value = "num") String num, @RequestParam(value = "psw") String psw,
						  @RequestParam(value = "identify") Integer identify, HttpSession httpSession) {
		String dataJson = "fail";
		Admin admin = adminService.findAdmin(num, SecureUtil.md5(psw), identify);
		if (null == admin) {
			log.error("count find user by account:{}", num);
			throw new GlobleException(CodeMsg.USER_OR_PWD_NOT_RIGHT);
		}
		String account = admin.getAccount();
		String name = admin.getName();
		httpSession.setAttribute("account", account);
		httpSession.setAttribute("name", name);
		httpSession.setAttribute("photo", identify == 0?"admin.png":"normal.png");
		httpSession.setAttribute("role", identify == 0?"admin":"normal");
		dataJson = JSON.toJSONString(admin);
		return Result.success(dataJson);
	}
	
	
	@RequestMapping(value = "/registUser")
	@ResponseBody
	public Result registUser(@RequestBody Map map) {
		log.info("regist info: {}", JSON.toJSONString(map));
		map.put("psw", SecureUtil.md5(map.get("psw").toString()));
		// 查询用户是否存在
		int count = adminService.queryCountByAccount((String) map.get("account"));
		if (count > 0) {
			log.error("this account already be registed, account:{}", JSON.toJSONString(map.get("account")));
			throw new GlobleException(CodeMsg.USER_ALREADY_REGIST);
		}
		if (adminService.registUser(map) > 0) {
			return Result.success("success");
		}
		return Result.success("success");
	}
}
