package com.axyya.flightmgtsys.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.axyya.flightmgtsys.model.Booking;
@Repository
public interface BookingRepo extends JpaRepository<Booking, Integer> {

}
