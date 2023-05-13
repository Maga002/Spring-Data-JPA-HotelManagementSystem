package com.practice.hotel.room;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Table(name = "room_class")
@Entity(name = "RoomClass")
public class RoomClass {
    @Id
    @SequenceGenerator(name = "room_class_id_seq",sequenceName = "room_class_id_seq")
    @GeneratedValue(generator = "room_class_id_seq",strategy = GenerationType.SEQUENCE)
    private Long id;
    @Enumerated(EnumType.STRING)
    private RoomType type;

    @OneToMany(mappedBy = "roomTypeId",cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    private List<RoomInformation> roomInformations = new ArrayList<>();

    public RoomClass(RoomType type) {
        this.type = type;
    }

    public RoomClass() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RoomType getType() {
        return type;
    }

    public void setType(RoomType type) {
        this.type = type;
    }

    public List<RoomInformation> getRoomInformations() {
        return roomInformations;
    }

    public void setRoomInformations(List<RoomInformation> roomInformations) {
        this.roomInformations = roomInformations;
    }

    @Override
    public String toString() {
        return "RoomClass{" +
                "id=" + id +
                ", type=" + type +
                '}';
    }
}
