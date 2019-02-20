package com.company.regofcardsmagic.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import com.haulmont.cuba.core.entity.annotation.Lookup;
import com.haulmont.cuba.core.entity.annotation.LookupType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import com.haulmont.cuba.core.entity.StandardEntity;
import javax.persistence.ManyToOne;

@Table(name = "REGOFCARDSMAGIC_CARD_EXCHANGE")
@Entity(name = "regofcardsmagic$CardExchange")
public class CardExchange extends StandardEntity {
    private static final long serialVersionUID = 3384751207793073941L;

    @Lookup(type = LookupType.DROPDOWN, actions = {"lookup"})
    @NotNull
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "BUYER_ID")
    protected People buyer;

    @Lookup(type = LookupType.DROPDOWN, actions = {"lookup"})
    @NotNull
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "SELLER_ID")
    protected People seller;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CARDS_FOR_BUY_ID")
    protected Card cardsForBuy;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CARDS_FOR_SALE_ID")
    protected Card cardsForSale;

    public void setCardsForBuy(Card cardsForBuy) {
        this.cardsForBuy = cardsForBuy;
    }

    public Card getCardsForBuy() {
        return cardsForBuy;
    }

    public void setCardsForSale(Card cardsForSale) {
        this.cardsForSale = cardsForSale;
    }

    public Card getCardsForSale() {
        return cardsForSale;
    }


    public void setBuyer(People buyer) {
        this.buyer = buyer;
    }

    public People getBuyer() {
        return buyer;
    }

    public void setSeller(People seller) {
        this.seller = seller;
    }

    public People getSeller() {
        return seller;
    }


}