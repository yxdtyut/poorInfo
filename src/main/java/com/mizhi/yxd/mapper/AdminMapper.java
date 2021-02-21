package com.mizhi.yxd.mapper;

import com.mizhi.yxd.entity.Admin;
import com.mizhi.yxd.vo.PwdVo;
import com.mizhi.yxd.vo.UserQueryVo;
import org.apache.ibatis.annotations.Mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface AdminMapper {
	Admin findAdmin(String account, String psw, Integer identify);

    int registUser(Map map);

    int queryCountByAccount(@Param("account") String account);

    List<Admin> findAll();

    void insertBatch(@Param("accounts") List<Admin> accounts);

    Admin findAdminByPwdVo(@Param("vo") PwdVo pwdVo);

    void updatePwd(@Param("vo") PwdVo pwdVo);

    List<Admin> queryUserWithPage(@Param("vo") UserQueryVo userQueryVo, @Param("map") Map<String,Object> map);

    int queryAdminCountByCondition(@Param("vo") UserQueryVo userQueryVo);

    int deleteUser(@Param("account") String account);

    void resetUserPwd(@Param("account") String account,@Param("pwd") String pwd);
}
