package com.Project.HotelBooking.Repository;

import com.Project.HotelBooking.Entity.Bookings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingsRepository extends JpaRepository<Bookings,Long> {
}