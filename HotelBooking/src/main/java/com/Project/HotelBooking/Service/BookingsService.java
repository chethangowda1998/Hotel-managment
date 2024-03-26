package com.Project.HotelBooking.Service;

import com.Project.HotelBooking.Dto.BookingsDto;
import org.springframework.stereotype.Service;

@Service
public interface BookingsService {
    BookingsDto createbookings(BookingsDto createbookings);

    BookingsDto updateBookingsById(BookingsDto bookingsDto,long id);

    BookingsDto getBookingsById(long id);
}
