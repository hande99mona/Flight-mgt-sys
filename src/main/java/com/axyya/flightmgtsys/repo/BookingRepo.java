package com.axyya.flightmgtsys.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.axyya.flightmgtsys.model.Booking;

public interface BookingRepo extends JpaRepository<Booking, Integer> {

}
