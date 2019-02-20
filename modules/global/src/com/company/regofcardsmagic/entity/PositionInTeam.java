package com.company.regofcardsmagic.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.chile.core.annotations.NamePattern;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;

@NamePattern("%s|name")
@Table(name = "REGOFCARDSMAGIC_POSITION_IN_TEAM")
@Entity(name = "regofcardsmagic$PositionInTeam")
public class PositionInTeam extends StandardEntity {
    private static final long serialVersionUID = 3856964801248118836L;

    @NotNull
    @Column(name = "NAME", nullable = false)
    protected String name;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "positionInTeam")
    protected People people;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "positionInTeam")
    protected Compensation compensation;

    public void setCompensation(Compensation compensation) {
        this.compensation = compensation;
    }

    public Compensation getCompensation() {
        return compensation;
    }


    public void setPeople(People people) {
        this.people = people;
    }

    public People getPeople() {
        return people;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


}