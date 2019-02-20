package com.company.regofcardsmagic.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import com.haulmont.cuba.core.entity.annotation.Lookup;
import com.haulmont.cuba.core.entity.annotation.LookupType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.chile.core.annotations.NamePattern;
import java.util.List;
import javax.persistence.OneToMany;

@NamePattern("%s|title")
@Table(name = "REGOFCARDSMAGIC_DECK")
@Entity(name = "regofcardsmagic$Deck")
public class Deck extends StandardEntity {
    private static final long serialVersionUID = -4757364458278098799L;

    @NotNull
    @Lob
    @Column(name = "TITLE", nullable = false)
    protected String title;

    @Lookup(type = LookupType.DROPDOWN, actions = {"lookup"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "OWNER_ID")
    protected People owner;



    @OneToMany(mappedBy = "deck")
    protected List<Card> maindeck;

    @OneToMany(mappedBy = "deck")
    protected List<Card> sideboard;

    public void setSideboard(List<Card> sideboard) {
        this.sideboard = sideboard;
    }

    public List<Card> getSideboard() {
        return sideboard;
    }


    public void setMaindeck(List<Card> maindeck) {
        this.maindeck = maindeck;
    }

    public List<Card> getMaindeck() {
        return maindeck;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setOwner(People owner) {
        this.owner = owner;
    }

    public People getOwner() {
        return owner;
    }


}