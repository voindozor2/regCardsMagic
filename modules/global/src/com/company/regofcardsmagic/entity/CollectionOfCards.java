package com.company.regofcardsmagic.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Lob;
import javax.validation.constraints.NotNull;
import com.haulmont.chile.core.annotations.NamePattern;

@NamePattern("%s|box")
@Table(name = "REGOFCARDSMAGIC_COLLECTION_OF_CARDS")
@Entity(name = "regofcardsmagic$CollectionOfCards")
public class CollectionOfCards extends Storage {
    private static final long serialVersionUID = -9198444413087131712L;

    @NotNull
    @Lob
    @Column(name = "BOX", nullable = false)
    protected String box;

    @NotNull
    @Lob
    @Column(name = "SEPARATOR_", nullable = false)
    protected String separator;

    public void setBox(String box) {
        this.box = box;
    }

    public String getBox() {
        return box;
    }

    public void setSeparator(String separator) {
        this.separator = separator;
    }

    public String getSeparator() {
        return separator;
    }


}