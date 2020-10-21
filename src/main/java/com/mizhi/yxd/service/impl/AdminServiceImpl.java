package com.mizhi.yxd.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mizhi.yxd.entity.Admin;
import com.mizhi.yxd.mapper.AdminMapper;
import com.mizhi.yxd.service.AdminService;

import java.util.Map;


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

}
