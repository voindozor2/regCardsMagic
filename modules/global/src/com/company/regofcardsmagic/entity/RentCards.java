package com.company.regofcardsmagic.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import com.haulmont.chile.core.annotations.NamePattern;

@NamePattern("%s|toWho")
@Table(name = "REGOFCARDSMAGIC_RENT_CARDS")
@Entity(name = "regofcardsmagic$RentCards")
public class RentCards extends Storage {
    private static final long serialVersionUID = -4033390588866313828L;

    @NotNull
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "TO_WHO_ID")
    protected People toWho;

    public void setToWho(People toWho) {
        this.toWho = toWho;
    }

    public People getToWho() {
        return toWho;
    }


}