package com.mizhi.yxd.request;

import lombok.Data;

import java.util.List;

/**
 * @author yangxudong
 * @description:
 * @date 2020/10/27 23:26
 */
@Data
public class PoorRequest {
    private String account;
    private String username;
    private String province;
    private String county;
    private String village;
    private String cun;
    private String idcard;
    private List<String> ids;
}
