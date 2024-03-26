package com.Project.HotelBooking.Dto;

import lombok.Data;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class HotelDto {

    @NotBlank(message = "Name is required")
    private String hotelname;

    @NotBlank(message = "Address is required")
    private String address;

    private String description;

    @NotNull(message = "Price Per Night should not be empty")
    @DecimalMin(value = "0.0", message = "Price Per Night should not be less than 0.0")
    private Double pricePerNight;

    @DecimalMin(value = "0.0", message = "Review should not be less than 0.0")
    @Max(value = 5, message = "Review should not be greater than 5.0")
    private Double Ratings;
}

