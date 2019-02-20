package com.company.regofcardsmagic.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.chile.core.annotations.NamePattern;
import java.util.List;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@NamePattern("%s|name")
@Table(name = "REGOFCARDSMAGIC_TEAM")
@Entity(name = "regofcardsmagic$Team")
public class Team extends StandardEntity {
    private static final long serialVersionUID = 5884840924227941658L;

    @NotNull
    @Lob
    @Column(name = "NAME", nullable = false)
    protected String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TEAM_MATES_ID")
    protected People teamMates;

    @JoinTable(name = "REGOFCARDSMAGIC_PEOPLE_TEAM_LINK",
        joinColumns = @JoinColumn(name = "TEAM_ID"),
        inverseJoinColumns = @JoinColumn(name = "PEOPLE_ID"))
    @ManyToMany
    protected List<People> peoples;

    public void setPeoples(List<People> peoples) {
        this.peoples = peoples;
    }

    public List<People> getPeoples() {
        return peoples;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setTeamMates(People teamMates) {
        this.teamMates = teamMates;
    }

    public People getTeamMates() {
        return teamMates;
    }


}