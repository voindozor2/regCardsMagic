package com.company.regofcardsmagic.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import com.haulmont.cuba.core.entity.annotation.Lookup;
import com.haulmont.cuba.core.entity.annotation.LookupType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import com.haulmont.cuba.core.entity.StandardEntity;
import javax.persistence.InheritanceType;
import javax.persistence.Inheritance;

@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "REGOFCARDSMAGIC_STORAGE")
@Entity(name = "regofcardsmagic$Storage")
public class Storage extends StandardEntity {
    private static final long serialVersionUID = -4502204891979708515L;

    @Lookup(type = LookupType.DROPDOWN, actions = {"lookup"})
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CARD_ID")
    protected Card card;

    public void setCard(Card card) {
        this.card = card;
    }

    public Card getCard() {
        return card;
    }


}