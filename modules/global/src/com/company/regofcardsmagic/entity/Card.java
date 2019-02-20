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

@NamePattern("%s|name")
@Table(name = "REGOFCARDSMAGIC_CARD")
@Entity(name = "regofcardsmagic$Card")
public class Card extends StandardEntity {
    private static final long serialVersionUID = -1927607317509204936L;

    @NotNull
    @Column(name = "NAME", nullable = false)
    protected String name;

    @Lob
    @Column(name = "INFORMATION")
    protected String information;

    @Lookup(type = LookupType.DROPDOWN, actions = {"lookup"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "OWNER_ID")
    protected People owner;

    @Lookup(type = LookupType.DROPDOWN, actions = {"lookup"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DECK_ID")
    protected Deck deck;


    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public Deck getDeck() {
        return deck;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public String getInformation() {
        return information;
    }

    public void setOwner(People owner) {
        this.owner = owner;
    }

    public People getOwner() {
        return owner;
    }


}