package com.practice.hotel.paymentTransaction;

import com.practice.hotel.customer.Customer;
import com.practice.hotel.employee.Employee;
import com.practice.hotel.reservation.Reservation;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Table(name = "transactions")
@Entity(name = "Transaction")
public class Transaction {
    @Id
    @SequenceGenerator(name = "transaction_id_seq",sequenceName = "transaction_id_seq")
    @GeneratedValue(generator = "transaction_id_seq",strategy = GenerationType.SEQUENCE)
    @Column(name = "id",updatable = false)
    private Long id;
    @Column(name = "transaction_name",nullable = false)
    private String transactionName;
    @Column(name = "transaction_date",nullable = false)
    private LocalDate transactionDate;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "employee_id",referencedColumnName = "id")
    private Employee employee;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "customer_id",referencedColumnName = "id")
    private Customer customer;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "reservation_id",referencedColumnName = "id")
    private Reservation reservation;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "payment_id",referencedColumnName = "id")
    private Payment payment;

    @OneToMany(mappedBy = "transaction",cascade = CascadeType.PERSIST)
    private List<Reports> reports = new ArrayList<>();

    public Transaction(String transactionName, LocalDate transactionDate, Employee employee, Customer customer, Reservation reservation, Payment payment, List<Reports> reports) {
        this.transactionName = transactionName;
        this.transactionDate = transactionDate;
        this.employee = employee;
        this.customer = customer;
        this.reservation = reservation;
        this.payment = payment;
        this.reports = reports;
    }

    public Transaction() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTransactionName() {
        return transactionName;
    }

    public void setTransactionName(String transactionName) {
        this.transactionName = transactionName;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public List<Reports> getReports() {
        return reports;
    }

    public void setReports(List<Reports> reports) {
        this.reports = reports;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", transactionName='" + transactionName + '\'' +
                ", transactionDate=" + transactionDate +
                ", employee=" + employee +
                ", customer=" + customer +
                ", reservation=" + reservation +
                ", payment=" + payment +
                ", reports=" + reports +
                '}';
    }
}
