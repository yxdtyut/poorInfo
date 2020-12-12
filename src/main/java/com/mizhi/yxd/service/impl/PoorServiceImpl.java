package com.mizhi.yxd.service.impl;

import com.mizhi.yxd.entity.SubPoor;
import com.mizhi.yxd.mapper.SubPoorMapper;
import com.mizhi.yxd.request.PoorRequest;
import com.mizhi.yxd.service.PoorService;
import com.mizhi.yxd.tools.SnowflakeIdWorker;
import com.mizhi.yxd.vo.UpdatePoorVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yangxudong
 * @description:
 * @date 2020/10/26 22:37
 */
@Service
public class PoorServiceImpl implements PoorService {

    @Autowired
    private SubPoorMapper poorMapper;

    @Override
    public void insertBatch(List<SubPoor> poors) {
        poors.stream().forEach(subPoor -> subPoor.setId(SnowflakeIdWorker.primaryKey()));
        poorMapper.insertBatch(poors);
    }

    @Override
    public List<SubPoor> findByCondition(PoorRequest poorRequest) {
        return poorMapper.selectByCondition(poorRequest);
    }

    @Override
    public int findCountByCondition(PoorRequest poorRequest) {
        return poorMapper.findCountByCondition(poorRequest);
    }

    @Override
    public void updateByField(UpdatePoorVo updatePoorVo) {
        poorMapper.updateByField(updatePoorVo);
    }

    @Override
    public int deletePoorInfo(String id) {
        return poorMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int deleteByPoorIds(List<String> data) {
        return poorMapper.deleteByPoorIds(data);
    }
}
