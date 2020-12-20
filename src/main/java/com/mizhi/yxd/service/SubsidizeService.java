package com.mizhi.yxd.service;

import com.mizhi.yxd.entity.SubSubsidize;
import com.mizhi.yxd.entity.SubsidizeAndPoor;
import com.mizhi.yxd.request.PoorRequest;
import com.mizhi.yxd.vo.UpdatePoorVo;

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

    int deleteSubsidizeInfo(String id);

    int deleteByPoorIds(List<String> data);

    void updateByField(UpdatePoorVo updatePoorVo);

    void createSubsidizeBatch(List<SubSubsidize> subSubsidizes);
}
