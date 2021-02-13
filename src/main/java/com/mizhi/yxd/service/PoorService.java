package com.mizhi.yxd.service;

import com.mizhi.yxd.entity.SubPoor;
import com.mizhi.yxd.request.PoorRequest;
import com.mizhi.yxd.vo.UpdatePoorVo;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * @author yangxudong
 * @description:
 * @date 2020/10/26 22:36
 */
public interface PoorService {
    void insertBatch(List<SubPoor> poors);

    List<SubPoor> findByCondition(PoorRequest poorRequest);

    List<SubPoor> findByConditionWithPage(PoorRequest poorRequest, Map<String, Object> map);

    int findCountByCondition(PoorRequest poorRequest);

    void updateByField(UpdatePoorVo updatePoorVo);

    int deletePoorInfo(String id);

    int deleteByPoorIds(List<String> data);

    void insertPoorInfo(SubPoor subPoor);

    void checkIdcardExist(List<SubPoor> poors, HttpSession httpSession);
}
