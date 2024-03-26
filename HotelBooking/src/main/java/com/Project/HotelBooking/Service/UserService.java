package com.Project.HotelBooking.Service;

import com.Project.HotelBooking.Dto.UserDto;

public interface UserService {


    UserDto createUser(UserDto userDto);




    UserDto updateuserById(UserDto userDto, long id);


    UserDto GetUserById( long id);

    UserDto DeletByUserId(long id);
}