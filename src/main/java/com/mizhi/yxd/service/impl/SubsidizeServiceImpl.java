package com.mizhi.yxd.service.impl;

import com.mizhi.yxd.entity.BatchOperationRsp;
import com.mizhi.yxd.entity.SubPoor;
import com.mizhi.yxd.entity.SubSubsidize;
import com.mizhi.yxd.entity.SubsidizeAndPoor;
import com.mizhi.yxd.exception.GlobleException;
import com.mizhi.yxd.mapper.SubPoorMapper;
import com.mizhi.yxd.mapper.SubSubsidizeMapper;
import com.mizhi.yxd.request.PoorRequest;
import com.mizhi.yxd.result.CodeMsg;
import com.mizhi.yxd.service.SubsidizeService;
import com.mizhi.yxd.tools.SnowflakeIdWorker;
import com.mizhi.yxd.vo.SubsidizeExportVo;
import com.mizhi.yxd.vo.UpdatePoorVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * @author yangxudong
 * @description:
 * @date 2020/12/15 22:17
 */
@Slf4j
@Service
public class SubsidizeServiceImpl implements SubsidizeService {
    @Autowired
    private SubSubsidizeMapper subSubsidizeMapper;

    @Autowired
    private SubPoorMapper poorMapper;

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

    @Override
    public List<CompletableFuture<BatchOperationRsp>> batchDealImportData(List<SubsidizeExportVo> exportVoList, HttpSession httpSession) {
        PoorRequest poorRequest = new PoorRequest();
        poorRequest.setAccount((String) httpSession.getAttribute("account"));
        List<SubsidizeAndPoor> subsidizes = subSubsidizeMapper.findByCondition(poorRequest);
        List<String> idCards = subsidizes.stream().map(SubsidizeAndPoor::getIdCard).collect(Collectors.toList());
        List<SubPoor> subPoors = poorMapper.selectByCondition(poorRequest);
        Map<String, SubPoor> idcardToPoorMap = subPoors.stream().collect(Collectors.toMap(SubPoor::getIdCard, subPoor -> subPoor));
        Executor executor = Executors.newFixedThreadPool(4,
                new ThreadFactory() {
                    @Override
                    public Thread newThread(Runnable r) {
                        Thread thread = new Thread(r);
                        //使用守护线程,使用这种方式不会阻止程序的关停
                        thread.setDaemon(true);
                        return thread;
                    }
                }
        );
        List<CompletableFuture<BatchOperationRsp>> collect = exportVoList.stream()
                .map(subsidizeExportVo -> CompletableFuture.supplyAsync(
                        () -> saveSubsidizeExportVo(subsidizeExportVo, idCards, httpSession, idcardToPoorMap), executor
                        ).exceptionally(e -> {
                            log.error(e.getMessage());
                            BatchOperationRsp operationRsp = new BatchOperationRsp();
                             operationRsp.setIsSuccess(false);
                            operationRsp.setErrorMsg(subsidizeExportVo.getName() + ":" + subsidizeExportVo.getIdCard());
                            return operationRsp;
                        })
                ).collect(toList());
        return collect;
    }

    @Override
    public List<SubsidizeAndPoor> findByConditionWithPage(PoorRequest poorRequest, Map<String, Object> map) {
        return subSubsidizeMapper.findByConditionWithPage(poorRequest, map);
    }

    @Transactional
    public BatchOperationRsp saveSubsidizeExportVo(SubsidizeExportVo subsidizeExportVo, List<String> idCards, HttpSession httpSession, Map<String, SubPoor> idcardToPoorMap) {
        BatchOperationRsp rsp = new BatchOperationRsp();
        if (idCards.contains(subsidizeExportVo.getIdCard())) {
            log.error("idcard exist:{}", subsidizeExportVo.getIdCard());
            throw new GlobleException(CodeMsg.IMPORT_VALIDATE_ERROR.setMsg(subsidizeExportVo.getName() + "--" + subsidizeExportVo.getIdCard() + "," + CodeMsg.IDCARD_EXIST_ERROR.getMsg()));
        }
        String poorId = null;
        if (!idcardToPoorMap.containsKey(subsidizeExportVo.getIdCard())) {
            SubPoor subPoor = subsidizeExportVo.transforToPoor();
            subPoor.setId(SnowflakeIdWorker.primaryKey());
            subPoor.setAccount((String) httpSession.getAttribute("account"));
            poorMapper.insertPoorInfo(subPoor);
            poorId = subPoor.getId();
        } else {
            poorId = idcardToPoorMap.get(subsidizeExportVo.getIdCard()).getId();
        }
        SubSubsidize subSubsidize = subsidizeExportVo.transferToSubsidize();
        subSubsidize.setPoorId(poorId);
        subSubsidizeMapper.insert(subSubsidize);
        rsp.setIsSuccess(true);
        return rsp;
    }

}
