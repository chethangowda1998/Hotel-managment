package com.Project.HotelBooking.Dto;

import lombok.Data;

import javax.validation.constraints.*;
import java.util.Date;

@Data
public class BookingsDto {
    @NotEmpty(message = "Hotel name not be empty")
    private String HotelName;
    @NotNull(message = "check in date must be")
    @PastOrPresent(message = "check in date must be pastorpresent")
    private Date Checkin;
    @NotNull(message = "Check out date must be")
    @PastOrPresent(message = "check in date must be pastorpresent")
    private Date Checkout;
    @Email
    private String email;
    @NotEmpty(message = "mobile should be in 10 digits only")
    @Size(min = 10,max =10,message = "number should be in 10 digits only")
    private Long MobileNumber;


}
