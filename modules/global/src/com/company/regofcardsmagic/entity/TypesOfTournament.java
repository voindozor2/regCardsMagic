package com.company.regofcardsmagic.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@NamePattern("%s|name")
@Table(name = "REGOFCARDSMAGIC_TYPES_OF_TOURNAMENT")
@Entity(name = "regofcardsmagic_TypesOfTournament")
public class TypesOfTournament extends StandardEntity {
    private static final long serialVersionUID = -161807024919209045L;

    @NotNull
    @Column(name = "NAME", nullable = false)
    protected String name;

    @Column(name = "DESCRIPTION")
    protected String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}