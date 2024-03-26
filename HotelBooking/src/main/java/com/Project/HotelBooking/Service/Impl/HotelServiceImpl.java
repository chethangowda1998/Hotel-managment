package com.Project.HotelBooking.Service.Impl;

import com.Project.HotelBooking.Dto.HotelDto;
import com.Project.HotelBooking.Entity.Hotel;
import com.Project.HotelBooking.Exception.ResourceNotFoundException;
import com.Project.HotelBooking.Repository.HotelRepository;
import com.Project.HotelBooking.Service.HotelService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HotelServiceImpl implements HotelService {
    @Autowired
    private final HotelRepository hotelRepository;
    @Autowired
    private final ModelMapper mapper;

    public HotelServiceImpl(HotelRepository hotelRepository, ModelMapper mapper) {
        this.hotelRepository = hotelRepository;
        this.mapper = mapper;
    }

    @Override
    public HotelDto CreateHotel(HotelDto hotelDto) {
        Hotel hotel = mapToEntity(hotelDto);
        Hotel saved = hotelRepository.save(hotel);
        HotelDto dto = mapToDto(saved);
        return dto;
    }

    @Override
    public HotelDto UpdateHotelById(HotelDto hotelDto, long id) {
        Hotel hotel = hotelRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Hotel", "Id", id));
        hotel.setHotelName(hotelDto.getHotelname());
        hotel.setAddress(hotelDto.getAddress());
        hotel.setDescription(hotelDto.getDescription());
        hotel.setPricePerNight(hotel.getPricePerNight());
        hotel.setRatings(hotel.getRatings());
        Hotel save = hotelRepository.save(hotel);
        HotelDto dto = mapToDto(save);
        return dto;
    }

    @Override
    public HotelDto GetHotelById( long id) {
        Hotel hotel = hotelRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Hotel", "Id", id));
        HotelDto dto = mapToDto(hotel);
        return dto;
    }

    HotelDto mapToDto(Hotel hotel){
        HotelDto Dto = mapper.map(hotel, HotelDto.class);
return Dto;
    }
    Hotel mapToEntity(HotelDto hotelDto){
        Hotel Entity = mapper.map(hotelDto, Hotel.class);
return Entity;
    }
}
