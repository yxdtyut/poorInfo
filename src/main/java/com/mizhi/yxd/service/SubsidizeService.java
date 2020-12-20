package com.mizhi.yxd.service;

import com.mizhi.yxd.entity.SubSubsidize;
import com.mizhi.yxd.entity.SubsidizeAndPoor;
import com.mizhi.yxd.request.PoorRequest;

import java.util.List;

/**
 * @author yangxudong
 * @description:
 * @date 2020/12/15 22:17
 */
public interface SubsidizeService {
    void createSubsidize(SubSubsidize subSubsidize);

    List<SubsidizeAndPoor> findByCondition(PoorRequest poorRequest);

    int findCountByCondition(PoorRequest poorRequest);
}
