package com.Project.HotelBooking.Entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Bookings {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String hotelName;

    private String email;

    private long mobileNumber;
    private  String Title;
    private  String FirstName;
    private  String LastName;


    @Temporal(TemporalType.DATE)
    private Date checkIn;

    @Temporal(TemporalType.DATE)
    private Date checkOut;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;



}
