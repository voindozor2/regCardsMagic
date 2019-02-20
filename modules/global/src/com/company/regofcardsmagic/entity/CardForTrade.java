package com.company.regofcardsmagic.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import com.haulmont.chile.core.annotations.NamePattern;

@NamePattern("%s|card")
@Table(name = "REGOFCARDSMAGIC_CARD_FOR_TRADE")
@Entity(name = "regofcardsmagic$CardForTrade")
public class CardForTrade extends Storage {
    private static final long serialVersionUID = -4454303761571722397L;

}