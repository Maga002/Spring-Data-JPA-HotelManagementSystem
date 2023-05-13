package com.practice.hotel.customer;

import com.practice.hotel.paymentTransaction.Payment;
import com.practice.hotel.paymentTransaction.Transaction;
import com.practice.hotel.reservation.Reservation;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Table(name = "customers")
@Entity(name = "Customer")
public class Customer {

    @Id
    @SequenceGenerator(name = "customer_id_seq", sequenceName = "customer_id_seq")
    @GeneratedValue(generator = "customer_id_seq", strategy = GenerationType.SEQUENCE)
    @Column(name = "id", updatable = false)
    private Long id;
    @Column(name = "customer_first_name", nullable = false, length = 30)
    private String customerFirstName;
    @Column(name = "customer_last_name", nullable = false, length = 30)
    private String customerLastName;
    @Column(name = "address", nullable = false)
    private String address;
    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private CustomerStatus status;


    @OneToMany(mappedBy = "customer", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Payment> payments = new ArrayList<>();

    @OneToMany(mappedBy = "customer", cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, orphanRemoval = true)
    private List<Reservation> reservations = new ArrayList<>();

    @OneToMany(mappedBy = "customer")
    private List<Transaction> transactions = new ArrayList<>();

    public Customer() {
    }

    public Customer(String customerFirstName, String customerLastName, String address, CustomerStatus status) {
        this.customerFirstName = customerFirstName;
        this.customerLastName = customerLastName;
        this.address = address;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerFirstName() {
        return customerFirstName;
    }

    public void setCustomerFirstName(String customerFirstName) {
        this.customerFirstName = customerFirstName;
    }

    public String getCustomerLastName() {
        return customerLastName;
    }

    public void setCustomerLastName(String customerLastName) {
        this.customerLastName = customerLastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public CustomerStatus getStatus() {
        return status;
    }

    public void setStatus(CustomerStatus status) {
        this.status = status;
    }

    /*___________________Relations________________________*/
    public List<Reservation> getReservations() {
        return reservations;
    }

    public void addReservations(Reservation reservation) {
        reservations.add(reservation);
        reservation.setCustomer(this);
    }

    public void removeReservations(Reservation reservation) {
        reservations.remove(reservation);
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void addPayments(Payment payment) {
        payments.add(payment);
        payment.setCustomer(this);
    }

    public void removePayments(Payment payment) {
        payments.remove(payment);
    }

    /* ___________________Relations________________________ */


    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", customerFirstName='" + customerFirstName + '\'' +
                ", customerLastName='" + customerLastName + '\'' +
                ", address='" + address + '\'' +
                ", status=" + status +
                '}';
    }
}
