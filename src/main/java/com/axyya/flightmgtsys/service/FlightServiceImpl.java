package com.axyya.flightmgtsys.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axyya.flightmgtsys.model.Flight;
import com.axyya.flightmgtsys.repo.FlightRrpo;
@Service
public class FlightServiceImpl  implements FlightService{

	@Autowired
	FlightRrpo repo;
	
	@Override
	public Flight addFlight(Flight flight) {
		return repo.save(flight);
		 
	}

}
