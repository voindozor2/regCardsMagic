package com.company.regofcardsmagic.entity;

import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Table(name = "REGOFCARDSMAGIC_STORAGE")
@Entity(name = "regofcardsmagic_Storage")
public class Storage extends StandardEntity {
    private static final long serialVersionUID = -3981455773046170282L;

    @OneToMany(mappedBy = "storage")
    protected List<Card> cards;

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }
}