package com.practice.hotel.paymentTransaction;


import com.practice.hotel.customer.Customer;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Table(name = "payments")
@Entity(name = "Payment")
public class Payment {
    @Id
    @SequenceGenerator(name = "payment_id_seq",sequenceName = "payment_id_seq")
    @GeneratedValue(generator = "payment_id_seq",strategy = GenerationType.SEQUENCE)
    @Column(name = "id",updatable = false)
    private Long id;
    @Column(name = "payment_date",nullable = false)
    private LocalDate paymentDate;

    @ManyToOne
    @JoinColumn(name = "customer_id",referencedColumnName = "id",foreignKey = @ForeignKey(name = "customer_id_fk"))
    private Customer customer;


    @OneToMany(mappedBy = "payment")
    private List<Transaction> transactions = new ArrayList<>();

    public Payment(LocalDate paymentDate, Customer customer) {
        this.paymentDate = paymentDate;
        this.customer = customer;
    }

    public Payment() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", paymentDate=" + paymentDate +
                ", customer=" + customer +
                '}';
    }
}
