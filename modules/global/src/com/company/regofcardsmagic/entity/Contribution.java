package com.company.regofcardsmagic.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import com.haulmont.cuba.core.entity.annotation.Lookup;
import com.haulmont.cuba.core.entity.annotation.LookupType;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import com.haulmont.cuba.core.entity.StandardEntity;

@Table(name = "REGOFCARDSMAGIC_CONTRIBUTION")
@Entity(name = "regofcardsmagic$Contribution")
public class Contribution extends MoneyOperation {
    private static final long serialVersionUID = 3673898491323380065L;

    @Lookup(type = LookupType.DROPDOWN, actions = {"lookup"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PEOPLE_ID")
    protected People people;

    @Lookup(type = LookupType.DROPDOWN, actions = {"lookup"})
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "TYPE_ID")
    protected Types type;


    @Temporal(TemporalType.DATE)
    @NotNull
    @Column(name = "DATE_", nullable = false)
    protected Date date;

    public void setType(Types type) {
        this.type = type;
    }

    public Types getType() {
        return type;
    }




    public void setPeople(People people) {
        this.people = people;
    }

    public People getPeople() {
        return people;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }


}