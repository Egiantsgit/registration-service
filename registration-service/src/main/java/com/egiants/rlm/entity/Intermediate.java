package com.egiants.rlm.entity;

import javax.validation.constraints.NotNull;

public class Intermediate {

    @NotNull(message = "collegeName Can't be Null")
    private String collegeName;
    @NotNull(message = "startYearMonth Can't be Null")
    private String startYearMonth;
    @NotNull(message = "endYearMonth Can't be Null")
    private String endYearMonth;
    //TODO: this address need to Address not String
    @NotNull(message = "collegeAddress Can't be Null")
    private String collegeAddress;
    @NotNull(message = "postalCode Can't be Null")
    private String postalCode;
    @NotNull(message = "landMark Can't be Null")
    private String landMark;

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public String getStartYearMonth() {
        return startYearMonth;
    }

    public void setStartYearMonth(String startYearMonth) {
        this.startYearMonth = startYearMonth;
    }

    public String getEndYearMonth() {
        return endYearMonth;
    }

    public void setEndYearMonth(String endYearMonth) {
        this.endYearMonth = endYearMonth;
    }

    public String getCollegeAddress() {
        return collegeAddress;
    }

    public void setCollegeAddress(String collegeAddress) {
        this.collegeAddress = collegeAddress;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getLandMark() {
        return landMark;
    }

    public void setLandMark(String landMark) {
        this.landMark = landMark;
    }
}
