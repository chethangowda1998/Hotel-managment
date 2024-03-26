package com.Project.HotelBooking.Controller;

import com.Project.HotelBooking.Dto.BookingsDto;
import com.Project.HotelBooking.Service.BookingsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api*")
public class Bookings {
    private BookingsService bookingsService;

    public Bookings(BookingsService bookingsService) {
        this.bookingsService = bookingsService;
    }
    @PostMapping("/bookings")
    public ResponseEntity<BookingsDto> createbookings(@RequestBody BookingsDto bookingsDto){
        BookingsDto createbookings = bookingsService.createbookings(bookingsDto);
        return new ResponseEntity<>(createbookings, HttpStatus.CREATED);

    }
    @PutMapping("/update")
    public ResponseEntity<BookingsDto>updateBookingsById(@RequestBody BookingsDto bookingsDto,@PathVariable ("id") long id){
        BookingsDto dto = bookingsService.updateBookingsById(bookingsDto, id);
        return new ResponseEntity<>(dto,HttpStatus.OK);

    }
    @GetMapping("/{id}")
    public  ResponseEntity<BookingsDto>getBookingsById(@PathVariable ("id") long id){
        BookingsDto bookingsById = bookingsService.getBookingsById(id);
        return new ResponseEntity<>(bookingsById,HttpStatus.OK);


    }
}
