package com.Project.HotelBooking.Service.Impl;

import com.Project.HotelBooking.Dto.RoomDto;
import com.Project.HotelBooking.Entity.Rooms;
import com.Project.HotelBooking.Exception.ResourceNotFoundException;
import com.Project.HotelBooking.Repository.RoomsRepository;
import com.Project.HotelBooking.Service.RoomService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class RoomServiceImpl implements RoomService {
    @Autowired
    private RoomsRepository roomsRepository;
    @Autowired
    private ModelMapper mapper;

    public RoomServiceImpl(RoomsRepository roomsRepository, ModelMapper mapper) {
        this.roomsRepository = roomsRepository;
        this.mapper = mapper;
    }


    @Override
    public RoomDto createroom(RoomDto roomDto) {
        Rooms rooms = mapToEntity(roomDto);
        Rooms savedentity = roomsRepository.save(rooms);

        return mapToDto(savedentity);
    }

    @Override
    public RoomDto updateRoombyId(RoomDto roomDto, long id) {
        Rooms rooms = roomsRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Rooms","Id",id));
        rooms.setRoomNumber(roomDto.getRoomNumber());
        rooms.setRoomType(roomDto.getRoomType());
        rooms.setPrice_Per_Night(roomDto.getPricePerNight());
        Rooms saved = roomsRepository.save(rooms);
        return mapToDto(saved);
    }

    @Override
    public RoomDto getRoombyId(long id) {
        Rooms rooms = roomsRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Rooms","Id",id));

        return mapToDto(rooms);
    }


    Rooms mapToEntity(RoomDto roomDto){
        Rooms map = mapper.map(roomDto, Rooms.class);
        return map;

    }
      RoomDto   mapToDto(Rooms rooms){
          RoomDto dto = mapper.map(rooms, RoomDto.class);
return dto;

      }
}
