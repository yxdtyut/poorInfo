package com.mizhi.yxd.request;

import lombok.Data;

import java.util.List;

/**
 * @author yangxudong
 * @description:
 * @date 2020/12/20 15:20
 */
@Data
public class StudentRequest {
    private String username;
    private String school;
    private String clazz;
    private String studentNumber;
    private String idcard;
    private List<String> ids;
}
