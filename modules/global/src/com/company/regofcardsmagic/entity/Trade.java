package com.company.regofcardsmagic.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import com.haulmont.cuba.core.entity.annotation.Lookup;
import com.haulmont.cuba.core.entity.annotation.LookupType;
import com.haulmont.cuba.core.entity.annotation.OnDelete;
import com.haulmont.cuba.core.entity.annotation.OnDeleteInverse;
import com.haulmont.cuba.core.global.DeletePolicy;
import java.util.List;
import javax.persistence.OneToMany;

@Table(name = "REGOFCARDSMAGIC_TRADE")
@Entity(name = "regofcardsmagic$Trade")
public class Trade extends MoneyOperation {
    private static final long serialVersionUID = 1225419383148195291L;

    @Lookup(type = LookupType.SCREEN)
    @NotNull
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "SELLER_ID")
    protected People seller;

    @Lookup(type = LookupType.DROPDOWN, actions = {"lookup"})
    @NotNull
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "BUYER_ID")
    protected People buyer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CARD_ID")
    protected Card card;

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }



    public void setSeller(People seller) {
        this.seller = seller;
    }

    public People getSeller() {
        return seller;
    }

    public void setBuyer(People buyer) {
        this.buyer = buyer;
    }

    public People getBuyer() {
        return buyer;
    }


}