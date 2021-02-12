package com.mizhi.yxd.entity;

import lombok.Data;

/**
 * @author yangxudong
 * @description:
 * @date 2021/1/29 19:35
 */
@Data
public class BatchOperationRsp {
    private String id;
    private String name;
    private Boolean isSuccess;
    private String errorMsg;
}
