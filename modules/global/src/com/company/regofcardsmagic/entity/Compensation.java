package com.company.regofcardsmagic.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.chile.core.annotations.NamePattern;

@NamePattern("%s|people")
@Table(name = "REGOFCARDSMAGIC_COMPENSATION")
@Entity(name = "regofcardsmagic$Compensation")
public class Compensation extends StandardEntity {
    private static final long serialVersionUID = 1263854955237279015L;

    @NotNull
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "PEOPLE_ID")
    protected People people;

    @NotNull
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "POSITION_IN_TEAM_ID")
    protected PositionInTeam positionInTeam;

    public void setPeople(People people) {
        this.people = people;
    }

    public People getPeople() {
        return people;
    }

    public void setPositionInTeam(PositionInTeam positionInTeam) {
        this.positionInTeam = positionInTeam;
    }

    public PositionInTeam getPositionInTeam() {
        return positionInTeam;
    }


}