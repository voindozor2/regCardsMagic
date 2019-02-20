package com.company.regofcardsmagic.entity;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Lob;
import javax.validation.constraints.NotNull;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.chile.core.annotations.NamePattern;
import java.util.Date;
import java.util.List;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "POSITION_IN_TEAM_ID")
    protected PositionInTeam positionInTeam;

    @JoinTable(name = "REGOFCARDSMAGIC_PEOPLE_TEAM_LINK",
        joinColumns = @JoinColumn(name = "PEOPLE_ID"),
        inverseJoinColumns = @JoinColumn(name = "TEAM_ID"))
    @ManyToMany
    protected List<Team> team;

    @Lob
    @Column(name = "EMAIL")
    protected String email;

    @Lob
    @Column(name = "NICKNAME")
    protected String nickname;

    @Lob
    @Column(name = "NUMBER_OF_CARD")
    protected String numberOfCard;

    @Temporal(TemporalType.DATE)
    @NotNull
    @Column(name = "BIRTH_DATE", nullable = false)
    protected Date birthDate;

    @Temporal(TemporalType.DATE)
    @NotNull
    @Column(name = "ENTRY_DATE", nullable = false)
    protected Date entryDate;

    @NotNull
    @Lob
    @Column(name = "TELEPHONE_NUMBER", nullable = false)
    protected String telephoneNumber;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "toWho")
    protected RentCards rentCards;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "buyer")
    protected CardExchange cardExchange;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "people")
    protected Compensation compensation;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "seller")
    protected Trade trade;

    public void setTrade(Trade trade) {
        this.trade = trade;
    }

    public Trade getTrade() {
        return trade;
    }


    public void setCompensation(Compensation compensation) {
        this.compensation = compensation;
    }

    public Compensation getCompensation() {
        return compensation;
    }


    public void setCardExchange(CardExchange cardExchange) {
        this.cardExchange = cardExchange;
    }

    public CardExchange getCardExchange() {
        return cardExchange;
    }


    public void setRentCards(RentCards rentCards) {
        this.rentCards = rentCards;
    }

    public RentCards getRentCards() {
        return rentCards;
    }


    public void setPositionInTeam(PositionInTeam positionInTeam) {
        this.positionInTeam = positionInTeam;
    }

    public PositionInTeam getPositionInTeam() {
        return positionInTeam;
    }

    public void setTeam(List<Team> team) {
        this.team = team;
    }

    public List<Team> getTeam() {
        return team;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNumberOfCard(String numberOfCard) {
        this.numberOfCard = numberOfCard;
    }

    public String getNumberOfCard() {
        return numberOfCard;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }


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