package com.mizhi.yxd.service.impl;

import com.mizhi.yxd.entity.SubPoor;
import com.mizhi.yxd.exception.GlobleException;
import com.mizhi.yxd.mapper.SubPoorMapper;
import com.mizhi.yxd.request.PoorRequest;
import com.mizhi.yxd.result.CodeMsg;
import com.mizhi.yxd.service.PoorService;
import com.mizhi.yxd.tools.SnowflakeIdWorker;
import com.mizhi.yxd.vo.UpdatePoorVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author yangxudong
 * @description:
 * @date 2020/10/26 22:37
 */
@Slf4j
@Service
public class PoorServiceImpl implements PoorService {

    @Autowired
    private SubPoorMapper poorMapper;

    @Override
    public void insertBatch(List<SubPoor> poors) {
        poors.stream().forEach(subPoor -> subPoor.setId(SnowflakeIdWorker.primaryKey()));
        try {
            poorMapper.insertBatch(poors);
        } catch (Exception e) {
            log.error("poor import insert error, e:{}", e.getMessage());
            throw new GlobleException(CodeMsg.IMPROT_INSERT_ERROR);
        }
    }

    @Override
    public List<SubPoor> findByCondition(PoorRequest poorRequest) {
        return poorMapper.selectByCondition(poorRequest);
    }

    @Override
    public List<SubPoor> findByConditionWithPage(PoorRequest poorRequest, Map<String, Object> map) {
        return poorMapper.selectByConditionWithPage(poorRequest, map);
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

    @Override
    public void insertPoorInfo(SubPoor subPoor) {
        subPoor.setId(SnowflakeIdWorker.primaryKey());
        poorMapper.insertPoorInfo(subPoor);
    }

    @Override
    public void checkIdcardExist(List<SubPoor> poors, HttpSession httpSession) {
        PoorRequest poorRequest = new PoorRequest();
        poorRequest.setAccount((String) httpSession.getAttribute("account"));
        if (poors.size() > 0) {
            poorRequest.setSemester(poors.get(0).getSemester());
        }
        List<SubPoor> subPoors = poorMapper.selectByCondition(poorRequest);
        if (subPoors.size() > 0) {
            Map<String, SubPoor> allSubPoorMap = subPoors.stream().collect(Collectors.toMap(SubPoor::getIdCard, x -> x));
            poors.stream().forEach(subPoor -> {
                if (allSubPoorMap.containsKey(subPoor.getIdCard())) {
                    throw new GlobleException(CodeMsg.IDCARD_EXIST_ERROR.setMsg(subPoor.getName() + "--" + subPoor.getIdCard() + "," + CodeMsg.IDCARD_EXIST_ERROR.getMsg()));
                }
            });
        }
    }
}
