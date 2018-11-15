package com.company.regofcardsmagic.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Lob;
import javax.validation.constraints.NotNull;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.chile.core.annotations.NamePattern;

@NamePattern("%s|dci")
@Table(name = "REGOFCARDSMAGIC_PEOPLE")
@Entity(name = "regofcardsmagic$People")
public class People extends StandardEntity {
    private static final long serialVersionUID = -5886202435797481684L;

    @NotNull
    @Lob
    @Column(name = "SURNAME", nullable = false)
    protected String surname;

    @NotNull
    @Lob
    @Column(name = "NAME", nullable = false)
    protected String name;

    @NotNull
    @Lob
    @Column(name = "PATRONYMIC", nullable = false)
    protected String patronymic;

    @NotNull
    @Column(name = "DCI", nullable = false, unique = true)
    protected Integer dci;

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSurname() {
        return surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setDci(Integer dci) {
        this.dci = dci;
    }

    public Integer getDci() {
        return dci;
    }


}