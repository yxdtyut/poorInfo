package com.mizhi.yxd.request;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * @author yangxudong
 * @description:
 * @date 2020/10/27 23:26
 */
@Data
public class PoorRequest {
    private String account;
    private String username;
    private String province;
    private String school;
    private String county;
    private String village;
    private String cun;
    private String idcard;
    private String studyLevel;
    private String thisEnjoy;
    private String semester;
    private List<String> ids;

    public void initSemester() {
        if (StringUtils.isEmpty(this.semester)) {
            this.semester = "2021春";
        }
    }
}
