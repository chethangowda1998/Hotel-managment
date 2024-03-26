package com.Project.HotelBooking.Entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String HotelName;
    private String Address;
    private String Description;
    private Double PricePerNight;
    private Double Ratings;
    private int numberOfPersons;

   @OneToMany(mappedBy = "hotel",cascade = CascadeType.ALL)
    private List<Bookings> bookings;
    @OneToMany(mappedBy = "hotel",cascade = CascadeType.ALL)
    private List<Rooms> rooms;



}
