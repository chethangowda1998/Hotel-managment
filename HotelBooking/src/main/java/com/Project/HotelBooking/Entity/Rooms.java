package com.Project.HotelBooking.Entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Rooms {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long RoomNumber;
    private String RoomType;
    private Double Price_Per_Night;
    @ManyToOne
    @JoinColumn(name = "hotel_id",referencedColumnName = "hotelName")
    private Hotel hotel;






}
