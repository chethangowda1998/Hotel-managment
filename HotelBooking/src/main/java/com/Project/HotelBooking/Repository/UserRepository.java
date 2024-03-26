package com.Project.HotelBooking.Repository;


import com.Project.HotelBooking.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


    Optional<User> findByEmailorMobilenumber(String email,String mobilenumber);


}
