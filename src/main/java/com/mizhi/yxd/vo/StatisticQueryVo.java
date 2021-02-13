package com.mizhi.yxd.vo;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

/**
 * @author yangxudong
 * @description:
 * @date 2021/2/12 19:11
 */
public class StatisticQueryVo {
    private String semester;
    private String account;

    public String getSemester() {
        return StringUtils.isEmpty(this.semester)?"2021春":this.semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }
}
