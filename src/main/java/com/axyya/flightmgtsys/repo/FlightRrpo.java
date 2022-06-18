package com.axyya.flightmgtsys.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.axyya.flightmgtsys.model.Flight;

public interface FlightRrpo extends JpaRepository<Flight, Integer> {

}
