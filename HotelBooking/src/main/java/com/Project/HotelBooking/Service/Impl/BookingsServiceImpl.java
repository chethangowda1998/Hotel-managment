package com.Project.HotelBooking.Service.Impl;

import com.Project.HotelBooking.Dto.BookingsDto;
import com.Project.HotelBooking.Entity.Bookings;
import com.Project.HotelBooking.Exception.ResourceNotFoundException;
import com.Project.HotelBooking.Repository.BookingsRepository;
import com.Project.HotelBooking.Service.BookingsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingsServiceImpl implements BookingsService {
    @Autowired
    private BookingsRepository bookingsRepository;
    @Autowired
    private ModelMapper mapper;

    public BookingsServiceImpl(BookingsRepository bookingsRepository, ModelMapper mapper) {
        this.bookingsRepository = bookingsRepository;
        this.mapper = mapper;
    }

    @Override
    public BookingsDto createbookings(BookingsDto bookingsDto) {
        Bookings bookings = mapToEntity(bookingsDto);
        Bookings saved = bookingsRepository.save(bookings);
        return mapToDto(saved);
    }

    @Override
    public BookingsDto updateBookingsById(BookingsDto bookingsDto, long id) {
        Bookings bookings = bookingsRepository.findById(id).orElseThrow(()
                -> new ResourceNotFoundException("bookings","Id",id));
        bookings.setHotelName(bookingsDto.getHotelName());
        bookings.setCheckIn(bookingsDto.getCheckin());
        bookings.setCheckOut(bookingsDto.getCheckout());
        bookings.setEmail(bookingsDto.getEmail());
        bookings.setMobileNumber(bookingsDto.getMobileNumber());
        Bookings savedentity = bookingsRepository.save(bookings);
        return mapToDto(savedentity);
    }

    @Override
    public BookingsDto getBookingsById(long id) {
        Bookings bookings = bookingsRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("bookings","Id",id));
        return mapToDto(bookings);
    }


    Bookings mapToEntity(BookingsDto bookingsDto){
       Bookings entity = mapper.map(bookingsDto, Bookings.class);
return entity;
   }
   BookingsDto mapToDto(Bookings bookings){
       BookingsDto dto = mapper.map(bookings, BookingsDto.class);
       return dto;
   }
}
