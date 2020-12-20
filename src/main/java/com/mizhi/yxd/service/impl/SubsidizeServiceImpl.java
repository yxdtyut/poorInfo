package com.mizhi.yxd.service.impl;

import com.mizhi.yxd.entity.SubSubsidize;
import com.mizhi.yxd.entity.SubsidizeAndPoor;
import com.mizhi.yxd.exception.GlobleException;
import com.mizhi.yxd.mapper.SubSubsidizeMapper;
import com.mizhi.yxd.request.PoorRequest;
import com.mizhi.yxd.result.CodeMsg;
import com.mizhi.yxd.service.SubsidizeService;
import com.mizhi.yxd.vo.UpdatePoorVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<SubsidizeAndPoor> findByCondition(PoorRequest poorRequest) {
        return subSubsidizeMapper.findByCondition(poorRequest);
    }

    @Override
    public int findCountByCondition(PoorRequest poorRequest) {
        return subSubsidizeMapper.findCountByCondition(poorRequest);
    }

    @Override
    public int deleteSubsidizeInfo(String id) {
        return subSubsidizeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int deleteByPoorIds(List<String> data) {
        return subSubsidizeMapper.deleteByPoorIds(data);
    }

    @Override
    public void updateByField(UpdatePoorVo updatePoorVo) {
        subSubsidizeMapper.updateByField(updatePoorVo);
    }

    @Override
    public void createSubsidizeBatch(List<SubSubsidize> subSubsidizes) {
        subSubsidizeMapper.createSubsidizeBatch(subSubsidizes);
    }
}
