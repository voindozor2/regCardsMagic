package com.company.regofcardsmagic.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity(name = "regofcardsmagic_CollectionOfCards")
public class CollectionOfCards extends Storage {
    private static final long serialVersionUID = 3843461847845777009L;

    @NotNull
    @Column(name = "BOX", nullable = false)
    protected String box;

    @NotNull
    @Column(name = "SEPARATOR_", nullable = false)
    protected String separator;

    public String getSeparator() {
        return separator;
    }

    public void setSeparator(String separator) {
        this.separator = separator;
    }

    public String getBox() {
        return box;
    }

    public void setBox(String box) {
        this.box = box;
    }
}