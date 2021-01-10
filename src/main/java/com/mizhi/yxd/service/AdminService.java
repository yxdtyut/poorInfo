package com.mizhi.yxd.service;

import com.mizhi.yxd.entity.Admin;

import java.util.List;
import java.util.Map;

public interface AdminService {
	public Admin findAdmin(String account, String psw, Integer identify);

    int registUser(Map map);

    int queryCountByAccount(String account);

    void checkAccountExist(List<Admin> accounts);

    void insertBatch(List<Admin> accounts);
}
