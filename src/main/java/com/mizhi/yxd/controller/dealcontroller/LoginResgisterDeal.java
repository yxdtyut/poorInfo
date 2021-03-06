package com.mizhi.yxd.controller.dealcontroller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.mizhi.yxd.exception.GlobleException;
import com.mizhi.yxd.result.CodeMsg;
import com.mizhi.yxd.result.Result;
import com.mizhi.yxd.tools.BeanUtils;
import com.mizhi.yxd.tools.ExcelUtils;
import com.mizhi.yxd.tools.Layui;
import com.mizhi.yxd.vo.AccountExportVo;
import com.mizhi.yxd.vo.PwdVo;
import com.mizhi.yxd.vo.UserQueryVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
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
	public Result<String> importExcel(MultipartFile file, HttpSession httpSession) throws IOException {
		String loginAccount = (String) httpSession.getAttribute("account");
		if (!loginAccount.equals("zzzx")) {
			throw new GlobleException(CodeMsg.NOT_SYS_USER);
		}
		List<AccountExportVo> exportVoList = ExcelUtils.importExcel(file, AccountExportVo.class);
		exportVoList.stream().forEach(accountExportVo -> accountExportVo.validate());
		final List<Admin> accounts = BeanUtils.copyProperties(exportVoList, Admin.class);
		accounts.stream().forEach(account -> account.setPsw(SecureUtil.md5(account.getPsw())));
		adminService.checkAccountExist(accounts);
		adminService.insertBatch(accounts);
		log.info("import account success");
		return Result.success("success");
	}

	@RequestMapping(value = "/updatePwd")
	@ResponseBody
	public Result updatePwd(@RequestBody PwdVo pwdVo, HttpSession httpSession) {
		String account = (String) httpSession.getAttribute("account");
		pwdVo.setAccount(account);
		pwdVo.setOldPassword(SecureUtil.md5(pwdVo.getOldPassword()));
		// 查询用户是否存在
		Admin admin = adminService.findAdminByPwdVo(pwdVo);
		if (null == admin) {
			log.error("change password is not right:{}", account);
			throw new GlobleException(CodeMsg.PWD_NOT_RIGHT);
		}
		if (!pwdVo.judgePasswordSame()) {
			throw new GlobleException(CodeMsg.TWO_PWD_NOT_RIGHT);
		}
		pwdVo.setPassword(SecureUtil.md5(pwdVo.getPassword()));
		pwdVo.setConfirmPassword(SecureUtil.md5(pwdVo.getConfirmPassword()));
		adminService.updatePwd(pwdVo);
		log.info("update password success, account:{}", account);
		return Result.success("success");
	}

	@PostMapping(value = "/userManager")
	@ResponseBody
	public Object userManager(@RequestParam("limit") String limit, @RequestParam("page") String page
			,UserQueryVo userQueryVo, HttpSession httpSession) {
		log.info("userManager query:{}", JSON.toJSONString(userQueryVo));
		int lim = Integer.parseInt(limit);
		int start = (Integer.parseInt(page) - 1) * lim;
		Map<String, Object> map = new HashMap<>();
		map.put("start", start);
		map.put("pagesize", lim);
		List<Admin> admins = adminService.queryUserWithPage(userQueryVo, map);
		int total = adminService.queryAdminCountByCondition(userQueryVo);
		Layui l = Layui.data(total, admins);
		return JSON.toJSON(l);
	}

	@DeleteMapping("/delete/{account}")
	@ResponseBody
	public Result<Integer> deleteUser(@PathVariable String account) {
		log.info("delete user info, account:{}", account);
		int count = adminService.deleteUser(account);
		return Result.success(count);
	}

	@GetMapping("/reset/{account}")
	@ResponseBody
	public Result<String> resetUserPwd(@PathVariable String account) {
		log.info("reset user password, account:{}", account);
		adminService.resetUserPwd(account);
		return Result.success("success");
	}
}
