package com.company.regofcardsmagic.entity;

import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Table(name = "REGOFCARDSMAGIC_TRADE")
@Entity(name = "regofcardsmagic_Trade")
public class Trade extends StandardEntity {
    private static final long serialVersionUID = 330846243139279812L;

    @Column(name = "IN_MONEY")
    protected BigDecimal inMoney;

    @Column(name = "OUT_MONEY")
    protected BigDecimal outMoney;

    @OneToMany(mappedBy = "trade")
    protected List<Card> inCards;

    @OneToMany(mappedBy = "trade")
    protected List<Card> outCards;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SELLER_ID")
    protected People seller;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BUYER_ID")
    protected People buyer;

    @Temporal(TemporalType.DATE)
    @NotNull
    @Column(name = "DATE_", nullable = false)
    protected Date date;

    public void setOutCards(List<Card> outCards) {
        this.outCards = outCards;
    }

    public List<Card> getOutCards() {
        return outCards;
    }

    public void setInCards(List<Card> inCards) {
        this.inCards = inCards;
    }

    public List<Card> getInCards() {
        return inCards;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public People getBuyer() {
        return buyer;
    }

    public void setBuyer(People buyer) {
        this.buyer = buyer;
    }

    public People getSeller() {
        return seller;
    }

    public void setSeller(People seller) {
        this.seller = seller;
    }

    public BigDecimal getOutMoney() {
        return outMoney;
    }

    public void setOutMoney(BigDecimal outMoney) {
        this.outMoney = outMoney;
    }

    public BigDecimal getInMoney() {
        return inMoney;
    }

    public void setInMoney(BigDecimal inMoney) {
        this.inMoney = inMoney;
    }
}