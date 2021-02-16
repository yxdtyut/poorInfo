package com.mizhi.yxd.service.impl;

import com.mizhi.yxd.exception.GlobleException;
import com.mizhi.yxd.result.CodeMsg;
import com.mizhi.yxd.vo.PwdVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mizhi.yxd.entity.Admin;
import com.mizhi.yxd.mapper.AdminMapper;
import com.mizhi.yxd.service.AdminService;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	AdminMapper adminMapper;

	@Override
	public Admin findAdmin(String account, String psw, Integer identify) {
		// TODO Auto-generated method stub
		return adminMapper.findAdmin(account, psw, identify);
	}

	@Override
	public int registUser(Map map) {
		return adminMapper.registUser(map);
	}

	@Override
	public int queryCountByAccount(String account) {
		return adminMapper.queryCountByAccount(account);
	}

	@Override
	public void checkAccountExist(List<Admin> accounts) {
		List<Admin> admins = adminMapper.findAll();
		List<String> adminAccounts = admins.stream().map(Admin::getAccount).collect(Collectors.toList());
		accounts.stream().forEach(account -> {
			if (adminAccounts.contains(account.getAccount())) {
				throw new GlobleException(CodeMsg.SIX_FIFTEEN_NOT_RIGHT.setMsg(account+"已存在"));
			}
		});
	}

	@Override
	public void insertBatch(List<Admin> accounts) {
		adminMapper.insertBatch(accounts);
	}

	@Override
	public Admin findAdminByPwdVo(PwdVo pwdVo) {
		return adminMapper.findAdminByPwdVo(pwdVo);
	}

	@Override
	public void updatePwd(PwdVo pwdVo) {
		adminMapper.updatePwd(pwdVo);
	}

}
