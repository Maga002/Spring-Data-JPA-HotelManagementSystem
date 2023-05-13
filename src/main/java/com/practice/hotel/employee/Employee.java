package com.practice.hotel.employee;


import com.practice.hotel.paymentTransaction.Transaction;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Table(name = "employees",uniqueConstraints = @UniqueConstraint(name = "username_unique",columnNames = "username"))
@Entity(name ="Employee")
public class Employee {
    @Id
    @SequenceGenerator(name = "employee_id_seq",sequenceName = "employee_id_seq")
    @GeneratedValue(generator = "employee_id_seq",strategy = GenerationType.SEQUENCE)
    @Column(name = "id",updatable = false)
    private Long id;
    @Column(name = "first_name",nullable = false)
    private String firstName;
    @Column(name = "last_name",nullable = false)
    private String lastName;
    @Column(name = "job_department",nullable = false)
    private String jobDepartment;
    @Column(name = "address",nullable = false)
    private String address;
    @Column(name = "contact_address",nullable = false)
    private String contactAddress;
    @Column(name = "username",nullable = false)
    private String username;
    @Column(name = "password",nullable = false)
    private String password;

    @OneToMany(mappedBy = "employee",cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    private List<Transaction> transactions = new ArrayList<>();

    public Employee(String firstName, String lastName, String jobDepartment, String address, String contactAddress, String username, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.jobDepartment = jobDepartment;
        this.address = address;
        this.contactAddress = contactAddress;
        this.username = username;
        this.password = password;
    }

    public Employee() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getJobDepartment() {
        return jobDepartment;
    }

    public void setJobDepartment(String jobDepartment) {
        this.jobDepartment = jobDepartment;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactAddress() {
        return contactAddress;
    }

    public void setContactAddress(String contactAddress) {
        this.contactAddress = contactAddress;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Transaction> getTransaction() {
        return transactions;
    }

    public void setTransaction(List<Transaction> transaction) {
        this.transactions = transactions;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", jobDepartment='" + jobDepartment + '\'' +
                ", address='" + address + '\'' +
                ", contactAddress='" + contactAddress + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
