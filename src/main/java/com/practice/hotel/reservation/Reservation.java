package com.practice.hotel.reservation;


import com.practice.hotel.customer.Customer;
import com.practice.hotel.paymentTransaction.Transaction;
import com.practice.hotel.room.RoomInformation;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

@Table(name = "reservation")
@Entity(name = "Reservation")
public class Reservation {
    @Id
    @SequenceGenerator(name = "reservation_id_seq",sequenceName = "reservation_id_seq")
    @GeneratedValue(generator = "reservation_id_seq",strategy = GenerationType.SEQUENCE)
    @Column(name = "id",updatable = false)
    private Long id;
    @Column(name = "reservation_date",nullable = false)
    private LocalDate reservationDate;
    @Column(name = "date_in",nullable = false)
    private LocalDate dateIn;
    @Column(name = "date_out")
    private LocalDate dateOut;
    @Column(name = "date_range")
    private Integer dateRange;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "customer_id",referencedColumnName = "id")
    private Customer customer;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "room_id",referencedColumnName = "id")
    private RoomInformation roomId;

    @OneToMany(mappedBy = "reservation")
    private List<Transaction> transactions = new ArrayList<>();


    public Reservation(LocalDate reservationDate, LocalDate dateIn, LocalDate dateOut, Customer customer,RoomInformation roomId) {
        this.reservationDate = reservationDate;
        this.dateIn = dateIn;
        this.dateOut = dateOut;
        this.dateRange = countDateRange(dateIn,dateOut);
        this.customer = customer;
        this.roomId = roomId;
    }

    public Reservation() {
    }

    public Long getId() {
        return id;
    }

    public Integer countDateRange(LocalDate dateIn,LocalDate dateOut){
        Period period = Period.between(dateIn, dateOut);
        return Math.abs(period.getDays());
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(LocalDate reservationDate) {
        this.reservationDate = reservationDate;
    }

    public LocalDate getDateIn() {
        return dateIn;
    }

    public void setDateIn(LocalDate dateIn) {
        this.dateIn = dateIn;
    }

    public LocalDate getDateOut() {
        return dateOut;
    }

    public void setDateOut(LocalDate dateOut) {
        this.dateOut = dateOut;
    }

    public Integer getDateRange() {
        return dateRange;
    }

    public void setDateRange(Integer dateRange) {
        this.dateRange = dateRange;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", reservationDate=" + reservationDate +
                ", dateIn=" + dateIn +
                ", dateOut=" + dateOut +
                ", dateRange=" + dateRange +
                '}';
    }
}
