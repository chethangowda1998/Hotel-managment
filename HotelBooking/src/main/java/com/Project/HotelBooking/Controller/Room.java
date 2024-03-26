package com.Project.HotelBooking.Controller;

import com.Project.HotelBooking.Dto.RoomDto;
import com.Project.HotelBooking.Service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class Room {
    @Autowired
    private  RoomService roomService;


    public Room(RoomService roomService) {
        this.roomService = roomService;
    }
    @PostMapping("/rooms")
    public ResponseEntity<RoomDto>createroom(@RequestBody RoomDto roomDto){
        RoomDto dto = roomService.createroom(roomDto);
return new ResponseEntity<>(dto, HttpStatus.CREATED);

    }
    @PutMapping("/updateroom")
    public ResponseEntity<RoomDto>updateRoombyId(@RequestBody RoomDto roomDto,@PathVariable ("id") long id ){
        RoomDto dto = roomService.updateRoombyId(roomDto, id);
return new ResponseEntity<>(dto,HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<RoomDto>getRoombyId(@PathVariable ("id") long id){
        RoomDto roombyId = roomService.getRoombyId(id);
        return new ResponseEntity<>(roombyId,HttpStatus.OK);
    }
}
