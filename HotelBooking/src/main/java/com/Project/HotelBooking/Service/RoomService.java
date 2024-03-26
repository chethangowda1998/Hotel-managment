package com.Project.HotelBooking.Service;

import com.Project.HotelBooking.Dto.RoomDto;

public interface RoomService {
   RoomDto createroom(RoomDto roomDto);

  RoomDto updateRoombyId(RoomDto roomDto, long id);

   RoomDto getRoombyId(long id);
}
