package com.Project.HotelBooking.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Role extends JpaRepository<Role,Long> {
}
