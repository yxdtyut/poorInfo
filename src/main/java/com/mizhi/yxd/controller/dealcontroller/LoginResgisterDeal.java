package com.mizhi.yxd.controller.dealcontroller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.mizhi.yxd.exception.GlobleException;
import com.mizhi.yxd.result.CodeMsg;
import com.mizhi.yxd.result.Result;
import com.mizhi.yxd.tools.BeanUtils;
import com.mizhi.yxd.tools.ExcelUtils;
import com.mizhi.yxd.vo.AccountExportVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.alibaba.fastjson.JSON;
import com.mizhi.yxd.entity.Admin;
import com.mizhi.yxd.service.AdminService;

import cn.hutool.crypto.SecureUtil;
import org.springframework.web.multipart.MultipartFile;

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

	@PostMapping(value = "/importAccount")
	@ResponseBody
	public Result<String> importExcel(MultipartFile file) throws IOException {
		List<AccountExportVo> exportVoList = ExcelUtils.importExcel(file, AccountExportVo.class);
		exportVoList.stream().forEach(accountExportVo -> accountExportVo.validate());
		final List<Admin> accounts = BeanUtils.copyProperties(exportVoList, Admin.class);
		accounts.stream().forEach(account -> SecureUtil.md5(account.getPsw()));
		adminService.checkAccountExist(accounts);
		adminService.insertBatch(accounts);
		log.info("import account success");
		return Result.success("success");
	}
}
