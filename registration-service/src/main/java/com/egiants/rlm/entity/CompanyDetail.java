package com.egiants.rlm.entity;

import javax.validation.constraints.NotNull;

public class CompanyDetail {

    @NotNull(message = "companyName Can't be Null")
    private String companyName;
    @NotNull(message = "companyLocation Can't be Null")
    private String companyLocation;
    @NotNull(message = "startYearMonth Can't be Null")
    private String startYearMonth;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyLocation() {
        return companyLocation;
    }

    public void setCompanyLocation(String companyLocation) {
        this.companyLocation = companyLocation;
    }

    public String getStartYearMonth() {
        return startYearMonth;
    }

    public void setStartYearMonth(String startYearMonth) {
        this.startYearMonth = startYearMonth;
    }
}
