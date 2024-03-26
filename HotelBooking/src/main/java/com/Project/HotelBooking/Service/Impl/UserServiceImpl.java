package com.Project.HotelBooking.Service.Impl;

import com.Project.HotelBooking.Dto.UserDto;
import com.Project.HotelBooking.Entity.User;
import com.Project.HotelBooking.Exception.ResourceNotFoundException;
import com.Project.HotelBooking.Repository.UserRepository;
import com.Project.HotelBooking.Service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private ModelMapper mapper;

    public UserServiceImpl(UserRepository userRepository, ModelMapper mapper) {
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = mapToEntity(userDto);
        User save = userRepository.save(user);
        return mapToDto(save);
    }

    @Override
    public UserDto updateuserById(UserDto userDto, long id) {
        User updateUser = userRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("User", "Id", id));
        updateUser.setId(userDto.getId());
        updateUser.setEmail(userDto.getEmail());
        updateUser.setMobileNumber(userDto.getMobileNumber());

        User updatedUser = userRepository.save(updateUser);

        return mapToDto(updatedUser);
    }

    @Override
    public UserDto GetUserById( long id) {
        User user = userRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Id",("id"), id));
        return mapToDto(user);
    }

    @Override
    public UserDto DeletByUserId(long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id", ("id"), id));
        return mapToDto(user);
    }


    UserDto mapToDto(User user){
        return mapper.map(user, UserDto.class);
    }
    User mapToEntity(UserDto userDto){
        return mapper.map(userDto, User.class);
    }
}
