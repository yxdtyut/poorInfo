package com.mizhi.yxd.service.impl;

import com.mizhi.yxd.entity.SubPoor;
import com.mizhi.yxd.mapper.SubPoorMapper;
import com.mizhi.yxd.service.PoorService;
import com.mizhi.yxd.tools.SnowflakeIdWorker;
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
}
