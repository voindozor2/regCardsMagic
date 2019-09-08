package com.company.regofcardsmagic.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity(name = "regofcardsmagic_Rent")
public class Rent extends Trade {
    private static final long serialVersionUID = 1615586323906815497L;

    @Temporal(TemporalType.DATE)
    @NotNull
    @Column(name = "RENTAL_DATE", nullable = false)
    protected Date rentalDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "ADMISSION_DATE")
    protected Date admissionDate;

    public Date getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(Date admissionDate) {
        this.admissionDate = admissionDate;
    }

    public Date getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(Date rentalDate) {
        this.rentalDate = rentalDate;
    }
}