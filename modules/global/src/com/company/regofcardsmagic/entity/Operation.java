package com.company.regofcardsmagic.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.InheritanceType;
import javax.persistence.Inheritance;
import com.haulmont.cuba.core.entity.StandardEntity;

@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "REGOFCARDSMAGIC_OPERATION")
@Entity(name = "regofcardsmagic$Operation")
public class Operation extends StandardEntity {
    private static final long serialVersionUID = 1605889265602693435L;

}