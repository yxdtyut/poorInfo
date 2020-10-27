package com.mizhi.yxd.service;

import com.mizhi.yxd.entity.SubPoor;

import java.util.List;

/**
 * @author yangxudong
 * @description:
 * @date 2020/10/26 22:36
 */
public interface PoorService {
    void insertBatch(List<SubPoor> poors);
}
