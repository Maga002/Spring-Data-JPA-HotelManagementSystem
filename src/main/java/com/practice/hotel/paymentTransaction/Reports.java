package com.practice.hotel.paymentTransaction;

import jakarta.persistence.*;

import java.time.LocalDate;

@Table(name = "reports")
@Entity(name = "Report")
public class Reports {
    @Id
    @SequenceGenerator(name = "report_id_seq",sequenceName = "report_id_seq")
    @GeneratedValue(generator = "report_id_seq",strategy = GenerationType.SEQUENCE)
    @Column(name = "id",updatable = false)
    private Long id;
    @Column(name = "information")
    private String information;
    @Column(name = "date",nullable = false)
    private LocalDate date;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "transaction_id",referencedColumnName = "id")
    private Transaction transaction;

    public Reports(Long id, String information, LocalDate date, Transaction transaction) {
        this.id = id;
        this.information = information;
        this.date = date;
        this.transaction = transaction;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    @Override
    public String toString() {
        return "Reports{" +
                "id=" + id +
                ", information='" + information + '\'' +
                ", date=" + date +
                ", transaction=" + transaction +
                '}';
    }
}
