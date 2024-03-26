package com.Project.HotelBooking.Controller;

import com.Project.HotelBooking.Dto.HotelDto;
import com.Project.HotelBooking.Service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Api")
public class Hotel {
    @Autowired
    private HotelService hotelService;

    public Hotel(HotelService hotelService) {
        this.hotelService = hotelService;
    }
    @PostMapping("/hotel")
    public ResponseEntity<HotelDto>CreateHotel(@RequestBody HotelDto hotelDto){
        HotelDto dto = hotelService.CreateHotel(hotelDto);
return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }
    @PutMapping("/updatehotel")
    public ResponseEntity<HotelDto>UpdateHotelById(@RequestBody HotelDto hotelDto,@PathVariable ("Id") long id){
        HotelDto dto = hotelService.UpdateHotelById(hotelDto, id);
        return new ResponseEntity<>(dto,HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<HotelDto>GetHotelById(@PathVariable ("Id") long id){
        HotelDto dto = hotelService.GetHotelById(id);
        return new ResponseEntity<>(dto,HttpStatus.OK);


    }
}
