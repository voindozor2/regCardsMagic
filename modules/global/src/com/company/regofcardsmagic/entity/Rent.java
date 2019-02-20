package com.company.regofcardsmagic.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Table(name = "REGOFCARDSMAGIC_RENT")
@Entity(name = "regofcardsmagic$Rent")
public class Rent extends Trade {
    private static final long serialVersionUID = -7039557966366731223L;

    @Temporal(TemporalType.DATE)
    @NotNull
    @Column(name = "RENTAL_DATE", nullable = false)
    protected Date rentalDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "ADMISSION_DATE")
    protected Date admissionDate;

    public void setRentalDate(Date rentalDate) {
        this.rentalDate = rentalDate;
    }

    public Date getRentalDate() {
        return rentalDate;
    }

    public void setAdmissionDate(Date admissionDate) {
        this.admissionDate = admissionDate;
    }

    public Date getAdmissionDate() {
        return admissionDate;
    }


}