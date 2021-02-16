package com.mizhi.yxd.mapper;

import com.mizhi.yxd.entity.Admin;
import com.mizhi.yxd.vo.PwdVo;
import org.apache.ibatis.annotations.Mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface AdminMapper {
	public Admin findAdmin(String account, String psw, Integer identify);

    int registUser(Map map);

    int queryCountByAccount(@Param("account") String account);

    List<Admin> findAll();

    void insertBatch(@Param("accounts") List<Admin> accounts);

    Admin findAdminByPwdVo(@Param("vo") PwdVo pwdVo);

    void updatePwd(@Param("vo") PwdVo pwdVo);
}
