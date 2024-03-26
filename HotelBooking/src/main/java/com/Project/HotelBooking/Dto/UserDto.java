package com.Project.HotelBooking.Dto;


import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class UserDto {

    private long id;
    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    private String email;

    @NotBlank(message = "Mobile number is required")
//    @Size(min = 10, max = 10, message = "Mobile number should be exactly 10 digits")
//    @Pattern(regexp = "^[0-9]*$", message = "Mobile number should contain only digits")
    private String mobileNumber;


}
