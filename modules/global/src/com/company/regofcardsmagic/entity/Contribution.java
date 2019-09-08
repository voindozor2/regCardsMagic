package com.company.regofcardsmagic.entity;

import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

@Table(name = "REGOFCARDSMAGIC_CONTRIBUTION")
@Entity(name = "regofcardsmagic_Contribution")
public class Contribution extends StandardEntity {
    private static final long serialVersionUID = 8303168779814739777L;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PEOPLE_ID")
    protected People people;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATE_")
    protected Date date;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "TYPE_ID")
    protected TypesOfContribution type;

    @Column(name = "SUM_")
    protected BigDecimal sum;

    public BigDecimal getSum() {
        return sum;
    }

    public void setSum(BigDecimal sum) {
        this.sum = sum;
    }

    public TypesOfContribution getType() {
        return type;
    }

    public void setType(TypesOfContribution type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public People getPeople() {
        return people;
    }

    public void setPeople(People people) {
        this.people = people;
    }
}