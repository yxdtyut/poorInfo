package com.mizhi.yxd.service;

import com.mizhi.yxd.entity.SubPoor;
import com.mizhi.yxd.request.PoorRequest;
import com.mizhi.yxd.vo.UpdatePoorVo;

import java.util.List;

/**
 * @author yangxudong
 * @description:
 * @date 2020/10/26 22:36
 */
public interface PoorService {
    void insertBatch(List<SubPoor> poors);

    List<SubPoor> findByCondition(PoorRequest poorRequest);

    int findCountByCondition(PoorRequest poorRequest);

    void updateByField(UpdatePoorVo updatePoorVo);

    int deletePoorInfo(String id);
}
