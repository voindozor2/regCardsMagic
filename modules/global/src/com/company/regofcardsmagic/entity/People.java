package com.company.regofcardsmagic.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@NamePattern("%s|name")
@Table(name = "REGOFCARDSMAGIC_PEOPLE")
@Entity(name = "regofcardsmagic_People")
public class People extends StandardEntity {
    private static final long serialVersionUID = 2330505367394209643L;

    @NotNull
    @Column(name = "SURNAME", nullable = false)
    protected String surname;

    @NotNull
    @Column(name = "NAME", nullable = false)
    protected String name;

    @Column(name = "PATRONYMIC")
    protected String patronymic;

    @NotNull
    @Column(name = "DCI", nullable = false, unique = true)
    protected String dci;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "POSITION_IN_TEAM_ID")
    protected PositionInTeam positionInTeam;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TEAM_ID")
    protected Team team;

    @NotNull
    @Column(name = "EMAIL", nullable = false)
    protected String email;

    @Column(name = "NICKNAME")
    protected String nickname;

    @Column(name = "NUMBER_OF_CARD")
    protected String numberOfCard;

    @Temporal(TemporalType.DATE)
    @NotNull
    @Column(name = "BIRTH_DATE", nullable = false)
    protected Date birthDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "ENTRY_DATE")
    protected Date entryDate;

    @NotNull
    @Column(name = "TELEPHONE_NUMBER", nullable = false)
    protected String telephoneNumber;

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getNumberOfCard() {
        return numberOfCard;
    }

    public void setNumberOfCard(String numberOfCard) {
        this.numberOfCard = numberOfCard;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public PositionInTeam getPositionInTeam() {
        return positionInTeam;
    }

    public void setPositionInTeam(PositionInTeam positionInTeam) {
        this.positionInTeam = positionInTeam;
    }

    public String getDci() {
        return dci;
    }

    public void setDci(String dci) {
        this.dci = dci;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}