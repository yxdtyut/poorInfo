package com.mizhi.yxd.service;

import com.mizhi.yxd.entity.Admin;
import com.mizhi.yxd.vo.PwdVo;
import com.mizhi.yxd.vo.UserQueryVo;

import java.util.List;
import java.util.Map;

public interface AdminService {
	public Admin findAdmin(String account, String psw, Integer identify);

    int registUser(Map map);

    int queryCountByAccount(String account);

    void checkAccountExist(List<Admin> accounts);

    void insertBatch(List<Admin> accounts);

    Admin findAdminByPwdVo(PwdVo pwdVo);

    void updatePwd(PwdVo pwdVo);

    List<Admin> queryUserWithPage(UserQueryVo userQueryVo, Map<String,Object> map);

    int queryAdminCountByCondition(UserQueryVo userQueryVo);

    int deleteUser(String id);

    void resetUserPwd(String id);
}
