package com.mizhi.yxd.service.impl;

import com.mizhi.yxd.entity.SubSubsidize;
import com.mizhi.yxd.exception.GlobleException;
import com.mizhi.yxd.mapper.SubSubsidizeMapper;
import com.mizhi.yxd.result.CodeMsg;
import com.mizhi.yxd.service.SubsidizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yangxudong
 * @description:
 * @date 2020/12/15 22:17
 */
@Service
public class SubsidizeServiceImpl implements SubsidizeService {
    @Autowired
    private SubSubsidizeMapper subSubsidizeMapper;

    @Override
    public void createSubsidize(SubSubsidize subSubsidize) {
        SubSubsidize existSubsidize = subSubsidizeMapper.selectByPrimaryKey(subSubsidize.getPoorId());
        if (null != existSubsidize) {
            throw new GlobleException(CodeMsg.SUBSIDIZE_EXIST_ERROR);
        }
        subSubsidizeMapper.insert(subSubsidize);
    }
}
