package com.company.regofcardsmagic.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@NamePattern("%s|name")
@Table(name = "REGOFCARDSMAGIC_POSITION_IN_TEAM")
@Entity(name = "regofcardsmagic_PositionInTeam")
public class PositionInTeam extends StandardEntity {
    private static final long serialVersionUID = 7685164094867090448L;

    @NotNull
    @Column(name = "NAME", nullable = false)
    protected String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}