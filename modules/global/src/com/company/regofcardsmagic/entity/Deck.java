package com.company.regofcardsmagic.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@NamePattern("%s|title")
@Table(name = "REGOFCARDSMAGIC_DECK")
@Entity(name = "regofcardsmagic_Deck")
public class Deck extends StandardEntity {
    private static final long serialVersionUID = -7938580693106697173L;

    @NotNull
    @Column(name = "TITLE", nullable = false)
    protected String title;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "OWNER_ID")
    protected People owner;

    public People getOwner() {
        return owner;
    }

    public void setOwner(People owner) {
        this.owner = owner;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}