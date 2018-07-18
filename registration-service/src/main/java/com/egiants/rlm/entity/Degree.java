package com.egiants.rlm.entity;

import javax.validation.constraints.NotNull;

public class Degree {

    //TODO: need to revist this field
    @NotNull(message = "gradYearMonth Can't be Null")
    private String gradYearMonth;
    @NotNull(message = "majorDegree Can't be Null")
    private String majorDegree;
    @NotNull(message = "university Can't be Null")
    private String university;
    //TODO: this address need to Address not String
    @NotNull(message = "universityAddress Can't be Null")
    private String universityAddress;
    @NotNull(message = "gpa Can't be Null")
    private Double gpa;
    @NotNull(message = "startYearMonth Can't be Null")
    private String startYearMonth;

    public String getGradYearMonth() {
        return gradYearMonth;
    }

    public void setGradYearMonth(String gradYearMonth) {
        this.gradYearMonth = gradYearMonth;
    }

    public String getMajorDegree() {
        return majorDegree;
    }

    public void setMajorDegree(String majorDegree) {
        this.majorDegree = majorDegree;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getUniversityAddress() {
        return universityAddress;
    }

    public void setUniversityAddress(String universityAddress) {
        this.universityAddress = universityAddress;
    }

    public Double getGpa() {
        return gpa;
    }

    public void setGpa(Double gpa) {
        this.gpa = gpa;
    }

    public String getStartYearMonth() {
        return startYearMonth;
    }

    public void setStartYearMonth(String startYearMonth) {
        this.startYearMonth = startYearMonth;
    }
}
