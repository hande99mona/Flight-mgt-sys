package com.axyya.flightmgtsys.repo;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.axyya.flightmgtsys.model.FlightSchedule;

public interface FlightScheduleRepo extends JpaRepository<FlightSchedule, Integer> {
	@Query(value = "SELECT f from FlightSchedule f where f.flight.flightId=:flightId and f.date=:date")
	public FlightSchedule findByDateAndFlightId(@Param("flightId") Integer flightId,@Param("date") LocalDate date);
}
