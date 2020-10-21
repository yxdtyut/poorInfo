package com.mizhi.yxd.service;

import com.mizhi.yxd.entity.Admin;

import java.util.Map;

public interface AdminService {
	public Admin findAdmin(String account, String psw, Integer identify);

    int registUser(Map map);

    int queryCountByAccount(String account);
}
