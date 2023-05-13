package com.practice.hotel.room;

import com.practice.hotel.reservation.Reservation;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Table(name = "room_information")
@Entity(name = "RoomInformation")
public class RoomInformation {
    @Id
    @SequenceGenerator(name = "room_info_id_seq",sequenceName = "room_info_id_seq")
    @GeneratedValue(generator = "room_info_id_seq",strategy = GenerationType.SEQUENCE)
    @Column(name = "id",updatable = false)
    private Long id;
    @Column(name = "description")
    private String description;
    @Column(name = "price",nullable = false)
    private Double price;

    @OneToMany(cascade = {CascadeType.PERSIST,CascadeType.REMOVE},mappedBy = "roomId")
    private List<Reservation> reservations = new ArrayList<>();

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "room_type_id",referencedColumnName = "id")
    private RoomClass roomTypeId;

    public RoomInformation(String description, Double price, RoomClass roomTypeId) {
        this.description = description;
        this.price = price;
        this.roomTypeId = roomTypeId;
    }

    public RoomInformation() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public RoomClass getRoomTypeId() {
        return roomTypeId;
    }

    public void setRoomTypeId(RoomClass roomTypeId) {
        this.roomTypeId = roomTypeId;
    }

    @Override
    public String toString() {
        return "RoomInformation{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}
