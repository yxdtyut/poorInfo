package com.mizhi.yxd.controller.dealcontroller;

import com.alibaba.fastjson.JSON;
import com.mizhi.yxd.entity.SubPoor;
import com.mizhi.yxd.result.Result;
import com.mizhi.yxd.service.PoorService;
import com.mizhi.yxd.tools.BeanUtils;
import com.mizhi.yxd.tools.ExcelUtils;
import com.mizhi.yxd.vo.PoorExportVo;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

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
        final List<SubPoor> poors = BeanUtils.copyProperties(exportVoList, SubPoor.class);
        log.info("import, poor:{}", JSON.toJSONString(poors));
        log.info("ready to save poor message, account:{}", JSON.toJSONString(httpSession.getAttribute("account")));
        poors.stream().forEach(subPoor -> subPoor.setAccount((String)httpSession.getAttribute("account")));
        poorService.insertBatch(poors);
        log.info("import message success");
        return Result.success("success");
    }
}
