package com.zhengyuan.liunao.service;

import com.zhengyuan.liunao.entity.Admin;

import java.util.Map;

public interface AdminService {
	public Admin findAdmin(String account, String psw, Integer identify);

    int registUser(Map map);

    int queryCountByAccount(String account);
}
