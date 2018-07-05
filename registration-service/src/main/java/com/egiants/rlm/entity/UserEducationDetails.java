package com.egiants.rlm.entity;

import javax.validation.Valid;

public class UserEducationDetails {

    @Valid
    private Degree masters;
    @Valid
    private Degree bachelors;
    @Valid
    private Intermediate intermediate;

    public Degree getMasters() {
        return masters;
    }

    public void setMasters(Degree masters) {
        this.masters = masters;
    }

    public Degree getBachelors() {
        return bachelors;
    }

    public void setBachelors(Degree bachelors) {
        this.bachelors = bachelors;
    }

    public Intermediate getIntermediate() {
        return intermediate;
    }

    public void setIntermediate(Intermediate intermediate) {
        this.intermediate = intermediate;
    }
}
