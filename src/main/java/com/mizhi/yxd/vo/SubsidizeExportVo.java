package com.mizhi.yxd.vo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.mizhi.yxd.entity.SubSubsidize;
import com.mizhi.yxd.exception.GlobleException;
import com.mizhi.yxd.result.CodeMsg;
import com.mizhi.yxd.tools.ValidateUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;

/**
 * @author yangxudong
 * @description:
 * @date 2020/12/20 14:50
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubsidizeExportVo extends PoorExportVo{
    @Excel(name = "资助项目", width = 15)
    private String subsidizeProject;

    @Excel(name = "资助金额", width = 15)
    private String subsidizeMoney;

    @Excel(name = "营养餐金额", width = 15)
    private String nutrimealMoney;

    @Override
    public void validate() {
        super.validate();
        String errorMsg = "信息输入有误，姓名:" + super.getName() + ",身份证:" + super.getIdCard();
        if (StringUtils.isNotEmpty(subsidizeMoney) && !ValidateUtils.checkIfNum(subsidizeMoney)) {
            throw new GlobleException(CodeMsg.IMPORT_VALIDATE_ERROR.setMsg(errorMsg + ",资助金额输入有误"));
        }
        if (StringUtils.isNotEmpty(nutrimealMoney) && !ValidateUtils.checkIfNum(nutrimealMoney)) {
            throw new GlobleException(CodeMsg.IMPORT_VALIDATE_ERROR.setMsg(errorMsg + ",营养餐金额输入有误"));
        }
    }

    public SubSubsidize transferToSubsidize() {
        return new SubSubsidize(subsidizeProject,new BigDecimal(subsidizeMoney),new BigDecimal(nutrimealMoney));
    }
}
