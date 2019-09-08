package com.company.regofcardsmagic.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity(name = "regofcardsmagic_RentCards")
public class RentCards extends Storage {
    private static final long serialVersionUID = -7333148287202493513L;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "TO_WHO_ID")
    protected People toWho;

    public People getToWho() {
        return toWho;
    }

    public void setToWho(People toWho) {
        this.toWho = toWho;
    }
}