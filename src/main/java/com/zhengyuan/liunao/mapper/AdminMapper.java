package com.zhengyuan.liunao.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.zhengyuan.liunao.entity.Admin;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

@Mapper
public interface AdminMapper {
	public Admin findAdmin(String account, String psw, Integer identify);

    int registUser(Map map);

    int queryCountByAccount(@Param("account") String account);
}
