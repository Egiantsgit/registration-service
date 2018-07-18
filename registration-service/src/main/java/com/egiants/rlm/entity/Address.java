package com.egiants.rlm.entity;

import javax.validation.constraints.NotNull;

public class Address {

    @NotNull(message = "line1 Can't be Null")
    private String line1;
    @NotNull(message = "line2 Can't be Null")
    private String line2;
    private String line3;
    @NotNull(message = "city Can't be Null")
    private String city;
    @NotNull(message = "state Can't be Null")
    private String state;
    @NotNull(message = "postalCode Can't be Null")
    private String postalCode;
    private Integer phoneNo;
    private Integer alternatePhoneNo;

    public String getLine1() { return this.line1; }

    public void setLine1(String line1) { this.line1 = line1; }

    public String getLine2() { return this.line2; }

    public void setLine2(String line2) { this.line2 = line2; }

    public String getLine3() { return this.line3; }

    public void setLine3(String line3) { this.line3 = line3; }

    public String getCity() { return this.city; }

    public void setCity(String city) { this.city = city; }

    public String getState() { return this.state; }

    public void setState(String state) { this.state = state; }

    public String getPostalCode() { return postalCode; }

    public void setPostalCode(String postalCode) { this.postalCode = postalCode;  }

    public Integer getPhoneNo() { return this.phoneNo; }

    public void setPhoneNo(Integer phoneNo) { this.phoneNo = phoneNo; }

    public Integer getAlternatePhoneNo() { return this.alternatePhoneNo; }

    public void setAlternatePhoneNo(Integer alternatePhoneNo) { this.alternatePhoneNo = alternatePhoneNo; }
}
