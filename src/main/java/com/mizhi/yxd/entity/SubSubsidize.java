package com.mizhi.yxd.entity;

import java.math.BigDecimal;

public class SubSubsidize {
    private String poorId;

    private String subsidizeProject;

    private BigDecimal subsidizeMoney;

    private BigDecimal nutrimealMoney;

    public String getPoorId() {
        return poorId;
    }

    public void setPoorId(String poorId) {
        this.poorId = poorId == null ? null : poorId.trim();
    }

    public String getSubsidizeProject() {
        return subsidizeProject;
    }

    public void setSubsidizeProject(String subsidizeProject) {
        this.subsidizeProject = subsidizeProject == null ? null : subsidizeProject.trim();
    }

    public BigDecimal getSubsidizeMoney() {
        return subsidizeMoney;
    }

    public void setSubsidizeMoney(BigDecimal subsidizeMoney) {
        this.subsidizeMoney = subsidizeMoney;
    }

    public BigDecimal getNutrimealMoney() {
        return nutrimealMoney;
    }

    public void setNutrimealMoney(BigDecimal nutrimealMoney) {
        this.nutrimealMoney = nutrimealMoney;
    }
}