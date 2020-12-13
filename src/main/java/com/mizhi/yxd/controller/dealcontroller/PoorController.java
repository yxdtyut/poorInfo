package com.mizhi.yxd.controller.dealcontroller;

import com.alibaba.fastjson.JSON;
import com.mizhi.yxd.entity.SubPoor;
import com.mizhi.yxd.request.PoorRequest;
import com.mizhi.yxd.result.Result;
import com.mizhi.yxd.service.PoorService;
import com.mizhi.yxd.tools.BeanUtils;
import com.mizhi.yxd.tools.ExcelUtils;
import com.mizhi.yxd.tools.Layui;
import com.mizhi.yxd.tools.SnowflakeIdWorker;
import com.mizhi.yxd.validate.ValueValidate;
import com.mizhi.yxd.vo.PoorExportVo;
import com.mizhi.yxd.vo.PoorVo;
import com.mizhi.yxd.vo.UpdatePoorVo;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author yangxudong
 * @description:
 * @date 2020/10/26 22:35
 */
@RestController
@RequestMapping("/poor")
@Api("poor相关api")
@Slf4j
public class PoorController {
    @Autowired
    private PoorService poorService;

    @PostMapping("/import")
    public Result<String> importExcel(MultipartFile file, HttpSession httpSession) throws IOException {
        List<PoorExportVo> exportVoList = ExcelUtils.importExcel(file, PoorExportVo.class);
        exportVoList.stream().forEach(poorExportVo -> poorExportVo.validate());
        final List<SubPoor> poors = BeanUtils.copyProperties(exportVoList, SubPoor.class);
        log.info("import, poor:{}", JSON.toJSONString(poors));
        log.info("ready to save poor message, account:{}", JSON.toJSONString(httpSession.getAttribute("account")));
        poors.stream().forEach(subPoor -> subPoor.setAccount((String) httpSession.getAttribute("account")));
        poorService.checkIdcardExist(poors, httpSession);
        poorService.insertBatch(poors);
        log.info("import message success");
        return Result.success("success");
    }

    @PostMapping("/poorInfo")
    public Object poorInfo(@RequestParam("limit") String limit, @RequestParam("page") String page
            , HttpSession httpSession, PoorRequest poorRequest) {
        int lim = Integer.parseInt(limit);
        int start = (Integer.parseInt(page) - 1) * lim;
        Map<String, Object> map = new HashMap<>();
        map.put("start", start);
        map.put("pagesize", lim);
        poorRequest.setAccount((String) httpSession.getAttribute("account"));
        List<SubPoor> subPoors = poorService.findByCondition(poorRequest);
        int total = poorService.findCountByCondition(poorRequest);
        List<PoorVo> poorVos = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(subPoors)) {
            poorVos = subPoors.stream().map(subPoor -> PoorVo.transferFrom(subPoor)).collect(Collectors.toList());
        }
        Layui l = Layui.data(total, poorVos);
        return JSON.toJSON(l);
    }

    @PutMapping("/update")
    public Result<String> updatePoorInfo(UpdatePoorVo updatePoorVo, HttpSession httpSession) {
        log.info("update poor vo:{}", JSON.toJSONString(updatePoorVo));
        ValueValidate.validate(updatePoorVo);
        updatePoorVo.setAccount((String) httpSession.getAttribute("account"));
        updatePoorVo.setField(ValueValidate.map.get(updatePoorVo.getField()));
        poorService.updateByField(updatePoorVo);
        return Result.success("success");
    }

    @DeleteMapping("/delete/{id}")
    public Result<Integer> deletePoorInfo(@PathVariable String id) {
        log.info("delete poor info, id:{}", id);
        int count = poorService.deletePoorInfo(id);
        return Result.success(count);
    }

    @PostMapping("/deletes")
    public Result<Integer> deletePoolInfos(String nums) {
        String[] str = nums.split(",");
        List<String> data = new ArrayList<String>();
        for (int i = 0; i < str.length; i++) {
            data.add(str[i]);
        }
        int count = 0;
        if (data.size() > 0) {
            count = poorService.deleteByPoorIds(data);
        }
        return Result.success(count);
    }

    @PostMapping("/add")
    public Result<String> addPoorInfo(@RequestBody PoorExportVo poorExportVo, HttpSession httpSession) {
        poorExportVo.validate();
        SubPoor subPoor = new SubPoor();
        org.springframework.beans.BeanUtils.copyProperties(poorExportVo, subPoor);
        log.info("add poor:{}", JSON.toJSONString(subPoor));
        subPoor.setAccount((String) httpSession.getAttribute("account"));
        poorService.checkIdcardExist(Arrays.asList(subPoor), httpSession);
        poorService.insertPoorInfo(subPoor);
        log.info("add poor success");
        return Result.success("success");
    }
}
