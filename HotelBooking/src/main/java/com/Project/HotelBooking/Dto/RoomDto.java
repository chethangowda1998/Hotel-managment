package com.Project.HotelBooking.Dto;

import lombok.Data;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
@Data
public class RoomDto {
    @NotEmpty(message = "Room Number Should Not Empty")
    private long RoomNumber;
    private String RoomType;
    @NotEmpty(message = "PricePerNight Should Not Be Empty")
    @DecimalMin(value = "450",message = "price per night not be less than 450")
    private Double PricePerNight;
}
