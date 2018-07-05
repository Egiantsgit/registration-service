package com.egiants.rlm.entity;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

public class UserWorkExperience {

    //TODO: need to modify totalExperience and previousFieldOfExperience
    @NotNull(message = "totalExperience Can't be Null")
    private Integer totalExperience;
    @NotNull(message = "previousFieldOfExperience Can't be Null")
    private String previousFieldOfExperience;
    @Valid
    private List<CompanyDetail> companyDetails;

    public Integer getTotalExperience() {
        return totalExperience;
    }

    public void setTotalExperience(Integer totalExperience) {
        this.totalExperience = totalExperience;
    }

    public String getPreviousFieldOfExperience() {
        return previousFieldOfExperience;
    }

    public void setPreviousFieldOfExperience(String previousFieldOfExperience) {
        this.previousFieldOfExperience = previousFieldOfExperience;
    }

    public List<CompanyDetail> getCompanyDetails() {
        return companyDetails;
    }

    public void setCompanyDetails(List<CompanyDetail> companyDetails) {
        this.companyDetails = companyDetails;
    }
}
