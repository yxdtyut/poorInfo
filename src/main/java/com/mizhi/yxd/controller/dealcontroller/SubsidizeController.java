package com.mizhi.yxd.controller.dealcontroller;

import com.alibaba.fastjson.JSON;
import com.mizhi.yxd.entity.BatchOperationRsp;
import com.mizhi.yxd.entity.SubPoor;
import com.mizhi.yxd.entity.SubSubsidize;
import com.mizhi.yxd.entity.SubsidizeAndPoor;
import com.mizhi.yxd.exception.GlobleException;
import com.mizhi.yxd.request.PoorRequest;
import com.mizhi.yxd.result.CodeMsg;
import com.mizhi.yxd.result.Result;
import com.mizhi.yxd.service.PoorService;
import com.mizhi.yxd.service.SemesterService;
import com.mizhi.yxd.service.SubsidizeService;
import com.mizhi.yxd.tools.ExcelUtils;
import com.mizhi.yxd.tools.FileUtil;
import com.mizhi.yxd.tools.Layui;
import com.mizhi.yxd.tools.SemesterUtil;
import com.mizhi.yxd.validate.ValueValidate;
import com.mizhi.yxd.vo.CreateSubsidizeVo;
import com.mizhi.yxd.vo.PoorExportVo;
import com.mizhi.yxd.vo.SubsidizeExportVo;
import com.mizhi.yxd.vo.UpdatePoorVo;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

/**
 * @author yangxudong
 * @description:
 * @date 2020/12/15 22:12
 */
@RestController
@RequestMapping("/subsidize")
@Api("subsidize相关api")
@Slf4j
public class SubsidizeController {
    @Autowired
    private SubsidizeService subsidizeService;

    @Autowired
    private PoorService poorService;

    @Autowired
    private SemesterService semesterService;

    @Autowired
    private SemesterUtil semesterUtil;

    @PostMapping("/add")
    public Result<String> createSubsidize(@RequestBody CreateSubsidizeVo createSubsidizeVo, HttpSession httpSession) {
        if (StringUtils.isNotEmpty(createSubsidizeVo.getPoorId())) {
            SubSubsidize subSubsidize = new SubSubsidize();
            BeanUtils.copyProperties(createSubsidizeVo, subSubsidize);
            subsidizeService.createSubsidize(subSubsidize);
        } else {
            PoorRequest poorRequest = new PoorRequest();
            BeanUtils.copyProperties(createSubsidizeVo, poorRequest);
            poorRequest.setAccount((String) httpSession.getAttribute("account"));
            List<SubPoor> subPoors = poorService.findByCondition(poorRequest);
            if (CollectionUtils.isNotEmpty(subPoors)) {
                List<SubSubsidize> subSubsidizes = subPoors.stream().map(subPoor -> {
                    SubSubsidize subSubsidize = new SubSubsidize();
                    subSubsidize.setNutrimealMoney(createSubsidizeVo.getNutrimealMoney());
                    subSubsidize.setSubsidizeMoney(createSubsidizeVo.getSubsidizeMoney());
                    subSubsidize.setSubsidizeProject(createSubsidizeVo.getSubsidizeProject());
                    subSubsidize.setPoorId(subPoor.getId());
                    return subSubsidize;
                }).collect(Collectors.toList());
                subsidizeService.createSubsidizeBatch(subSubsidizes);
            } else {
                throw new GlobleException(CodeMsg.THERE_IS_NO_COUNT_ERROR);
            }
        }
        return Result.success("success");
    }

    @PostMapping("/subsidizeInfo")
    public Object poorInfo(@RequestParam("limit") String limit, @RequestParam("page") String page
            , HttpSession httpSession, PoorRequest poorRequest) {
        int lim = Integer.parseInt(limit);
        int start = (Integer.parseInt(page) - 1) * lim;
        Map<String, Object> map = new HashMap<>();
        map.put("start", start);
        map.put("pagesize", lim);
        poorRequest.initSemester();
        poorRequest.setAccount((String) httpSession.getAttribute("account"));
        List<SubsidizeAndPoor> subSubsidizes = subsidizeService.findByConditionWithPage(poorRequest, map);
        int total = subsidizeService.findCountByCondition(poorRequest);
        Layui l = Layui.data(total, subSubsidizes);
        return JSON.toJSON(l);
    }

    @DeleteMapping("/delete/{id}")
    public Result<Integer> deleteSubsidizeInfo(@PathVariable String id, @PathVariable String semester) {
        log.info("delete poor info, id:{}, semester:{}", id, semester);
        validateIfLock(semester);
        int count = subsidizeService.deleteSubsidizeInfo(id);
        return Result.success(count);
    }

    @PostMapping("/deletes")
    public Result<Integer> deletePoolInfos(String nums, String semester) {
        validateIfLock(semester);
        String[] strings = nums.split(",");
        List<String> data = Arrays.asList(strings);
        int count = 0;
        if (data.size() > 0 && !data.contains("")) {
            count = subsidizeService.deleteByPoorIds(data);
        }
        return Result.success(count);
    }

    private void validateIfLock(@PathVariable String semester) {
        if (StringUtils.isNotEmpty(semester) && "1".equals(semesterService.queryLockedByName(semester))) {
            log.error("semester is locked");
            throw new GlobleException(CodeMsg.SEMESTER_IS_LOCKED);
        }
    }

    @PutMapping("/update")
    public Result<String> updatePoorInfo(UpdatePoorVo updatePoorVo, HttpSession httpSession) {
        log.info("update subsidize vo:{}", JSON.toJSONString(updatePoorVo));
        ValueValidate.validate(updatePoorVo);
        updatePoorVo.setAccount((String) httpSession.getAttribute("account"));
        updatePoorVo.setField(ValueValidate.map.get(updatePoorVo.getField()));
        if (ValueValidate.ifSubsidize(updatePoorVo)) {
            subsidizeService.updateByField(updatePoorVo);
        } else {
            poorService.updateByField(updatePoorVo);
        }
        return Result.success("success");
    }

    @GetMapping("/export")
    public void exportPoorInfo(@RequestParam String semester, @RequestParam String nums, HttpSession httpSession, HttpServletResponse response) throws IOException {
        PoorRequest request = new PoorRequest();
        request.setAccount((String) httpSession.getAttribute("account"));
        String[] strings = nums.split(",");
        List<String> data = Arrays.asList(strings);
        if (data.size() > 0 && !data.contains("")) {
            request.setIds(data);
        }
        request.setSemester(semester);
        List<SubsidizeAndPoor> subSubsidizes = subsidizeService.findByCondition(request);
        List<SubsidizeExportVo> poorExportVos = com.mizhi.yxd.tools.BeanUtils.copyProperties(subSubsidizes, SubsidizeExportVo.class);
        if (CollectionUtils.isNotEmpty(poorExportVos)) {
            poorExportVos.stream().forEach(poorExportVo -> poorExportVo.setSemester(semester));
        }
        ExcelUtils.exportExcel(poorExportVos, null, "资助库", SubsidizeExportVo.class, "资助库信息", true, response);
    }

    @PostMapping("/import")
    public Result<Object> importExcel(MultipartFile file, HttpSession httpSession) throws IOException {
        List<SubsidizeExportVo> exportVoList = ExcelUtils.importExcel(file, SubsidizeExportVo.class);
        if (exportVoList.size() > 0) {
            List<String> idCardList = exportVoList.stream().map(SubsidizeExportVo::getIdCard).distinct().collect(Collectors.toList());
            if (idCardList.size() != exportVoList.size()) {
                throw new GlobleException(CodeMsg.IDCARD_REPEATED);
            }
        }
        int count = exportVoList.stream().collect(Collectors.groupingBy(SubsidizeExportVo::getSemester, Collectors.counting())).size();
        if (count != 1) {
            log.error("semester not only");
            throw new GlobleException(CodeMsg.SEMESTER_NOT_ONLY);
        }
        if (CollectionUtils.isNotEmpty(exportVoList) && !semesterUtil.ifContain(exportVoList.get(0).getSemester())) {
            log.error("semester not right");
            throw new GlobleException(CodeMsg.SEMESTER_NOT_RIGHT);
        }
        if (CollectionUtils.isNotEmpty(exportVoList) && "1".equals(semesterService.queryLockedByName(exportVoList.get(0).getSemester()))) {
            log.error("semester is locked");
            throw new GlobleException(CodeMsg.SEMESTER_IS_LOCKED);
        }
        exportVoList.stream().forEach(subsidizeExportVo -> subsidizeExportVo.validate());
        List<CompletableFuture<BatchOperationRsp>> batchOperationRsps = subsidizeService.batchDealImportData(exportVoList, httpSession);
        List<CompletableFuture<BatchOperationRsp>> failedOperationRsp = batchOperationRsps.stream().filter(operationRsp -> {
            try {
                return !operationRsp.get().getIsSuccess();
            } catch (InterruptedException e) {
                log.error("batch import subsidize error:" + e.getMessage());
            } catch (ExecutionException e) {
                log.error("batch import subsidize error:" + e.getMessage());
            }
            return true;
        }).collect(Collectors.toList());
        if (CollectionUtils.isNotEmpty(failedOperationRsp)) {
            List<BatchOperationRsp> operationRsps = new ArrayList<>();
            failedOperationRsp.stream().forEach(operationRsp -> {
                try {
                    BatchOperationRsp batchOperationRsp = operationRsp.get();
                    if (!batchOperationRsp.getIsSuccess()) {
                        operationRsps.add(batchOperationRsp);
                    }
                } catch (InterruptedException e) {
                    log.error("batch import subsidize error:" + e.getMessage());
                } catch (ExecutionException e) {
                    log.error("batch import subsidize error:" + e.getMessage());
                }
            });
            return Result.success(operationRsps);
        }
        return Result.success("success");
    }

    @RequestMapping(value = "/download", method = RequestMethod.GET)
    public ResponseEntity<byte[]> downloadTemp() throws IOException{
        String filename = "subsidize.xlsx";
        FileUtil.downloadByFileName(filename);
        return null;
    }
}
