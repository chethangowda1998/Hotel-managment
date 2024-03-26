package com.Project.HotelBooking.Controller;

import com.Project.HotelBooking.Dto.UserDto;
import com.Project.HotelBooking.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Api")
public class User {
    @Autowired
    private  UserService userService;

    public User(UserService userService) {
        this.userService = userService;

    }

    @PostMapping("/create")
    @PreAuthorize("hasRole('user')")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        UserDto newUser = userService.createUser(userDto);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }
    @PutMapping("/update")
    @PreAuthorize("hasRole('user')")
    public ResponseEntity<UserDto>updateuserById(@RequestBody UserDto userDto,@PathVariable("Id") long id){
        UserDto dto = userService.updateuserById(userDto, id);
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }
    @GetMapping("/users")
    @PreAuthorize("hasRole('user')")
    public ResponseEntity<UserDto>GetUserById( @PathVariable ("Id") long id){
       UserDto dto= userService.GetUserById(id);
       return new ResponseEntity<>(dto,HttpStatus.OK);



    }
//    @PostMapping()
//    public ResponseEntity<>createUser(@RequestBody UserDto userDto){
//        UserDto user1 = userService.createUser(userDto);
//        return new ResponseEntity<>(user1,HttpStatus.CREATED);
//
    @DeleteMapping()
    public  ResponseEntity<UserDto> DeletByUserId(long id){
         UserDto dto=userService.DeletByUserId(id);
         return new ResponseEntity<>(dto,HttpStatus.OK);
    }


}


