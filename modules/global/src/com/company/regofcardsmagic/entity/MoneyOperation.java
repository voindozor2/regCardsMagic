package com.company.regofcardsmagic.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import com.haulmont.chile.core.annotations.NamePattern;

@NamePattern("%s|sum")
@Table(name = "REGOFCARDSMAGIC_MONEY_OPERATION")
@Entity(name = "regofcardsmagic$MoneyOperation")
public class MoneyOperation extends Operation {
    private static final long serialVersionUID = -2573294933346409387L;

    @NotNull
    @Column(name = "SUM_", nullable = false)
    protected Double sum;

    public void setSum(Double sum) {
        this.sum = sum;
    }

    public Double getSum() {
        return sum;
    }


}