package com.mizhi.yxd.controller.dealcontroller;

import com.alibaba.fastjson.JSON;
import com.mizhi.yxd.entity.SubPoor;
import com.mizhi.yxd.request.PoorRequest;
import com.mizhi.yxd.result.Result;
import com.mizhi.yxd.service.PoorService;
import com.mizhi.yxd.tools.BeanUtils;
import com.mizhi.yxd.tools.ExcelUtils;
import com.mizhi.yxd.tools.FileUtil;
import com.mizhi.yxd.tools.Layui;
import com.mizhi.yxd.validate.ValueValidate;
import com.mizhi.yxd.vo.PoorExportVo;
import com.mizhi.yxd.vo.PoorVo;
import com.mizhi.yxd.vo.UpdatePoorVo;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.activation.MimetypesFileTypeMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
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
        String[] strings = nums.split(",");
        List<String> data = Arrays.asList(strings);
        int count = 0;
        if (data.size() > 0 && !data.contains("")) {
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

    @RequestMapping(value = "/download", method = RequestMethod.GET)
    public ResponseEntity<byte[]> downloadTemp(HttpServletRequest request) throws IOException{
        String filename = "贫困库模板.xlsx";
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletResponse response = requestAttributes.getResponse();
        // 设置信息给客户端不解析
        String type = new MimetypesFileTypeMap().getContentType(filename);
        // 设置contenttype，即告诉客户端所发送的数据属于什么类型
        response.setHeader("Content-type",type);
        // 设置编码
        String hehe = new String(filename.getBytes("utf-8"), "iso-8859-1");
        // 设置扩展头，当Content-Type 的类型为要下载的类型时 , 这个信息头会告诉浏览器这个文件的名字和类型。
        response.setHeader("Content-Disposition", "attachment;filename=" + hehe);
        FileUtil.download(filename, response);
        return null;
    }

    @GetMapping("/export")
    public void exportPoorInfo(@RequestParam String nums, HttpSession httpSession, HttpServletResponse response) throws IOException {
        PoorRequest request = new PoorRequest();
        request.setAccount((String) httpSession.getAttribute("account"));
        String[] strings = nums.split(",");
        List<String> data = Arrays.asList(strings);
        if (data.size() > 0 && !data.contains("")) {
            request.setIds(data);
        }
        List<SubPoor> subPoors = poorService.findByCondition(request);
        List<PoorExportVo> poorExportVos = BeanUtils.copyProperties(subPoors, PoorExportVo.class);
        ExcelUtils.exportExcel(poorExportVos, null, "贫困库", PoorExportVo.class, "贫困库信息", true, response);
    }
}
