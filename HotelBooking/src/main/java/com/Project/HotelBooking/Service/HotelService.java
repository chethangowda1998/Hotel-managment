package com.Project.HotelBooking.Service;

import com.Project.HotelBooking.Dto.HotelDto;
import org.springframework.stereotype.Service;

@Service
public interface HotelService {
    HotelDto CreateHotel(HotelDto hotelDto);




    HotelDto UpdateHotelById(HotelDto hotelDto, long id);

    HotelDto GetHotelById( long id);
}
