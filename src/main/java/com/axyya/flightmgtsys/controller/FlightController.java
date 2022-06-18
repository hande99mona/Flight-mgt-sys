package com.axyya.flightmgtsys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.axyya.flightmgtsys.model.Flight;
import com.axyya.flightmgtsys.service.FlightService;

@RestController
@RequestMapping(path="/flight")
public class FlightController {
	@Autowired
	FlightService service;
	
	@PostMapping(path = "/add-flight")
	public ResponseEntity<Flight> addFlight(@RequestBody Flight flight) {
		Flight f = service.addFlight( flight);
		return f != null ? new ResponseEntity<Flight>(f, HttpStatus.OK)
				: new ResponseEntity<Flight>(f, HttpStatus.FORBIDDEN);
	}



}
