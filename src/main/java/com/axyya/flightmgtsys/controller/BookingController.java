package com.axyya.flightmgtsys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.axyya.flightmgtsys.model.Booking;
import com.axyya.flightmgtsys.service.BookingService;

import javassist.NotFoundException;

@RestController
@RequestMapping(path="/booking")
public class BookingController {
	
	@Autowired
	BookingService service;
	
	@PostMapping(path = "/add-booking")
	   public ResponseEntity<String> addBooking(@RequestBody Booking booking) throws NotFoundException {
		
		return service.addBooking(booking) ? new ResponseEntity<String>("booking done", HttpStatus.OK)
				:new ResponseEntity<String>("seats not available", HttpStatus.FORBIDDEN);
	}
    
	@GetMapping(path = "/show-bookings")
	public ResponseEntity<List<Booking>>showallBookings()throws EmptyResultDataAccessException {
		return new ResponseEntity<List<Booking>>(service.getAllBookings(),HttpStatus.OK);
		
	}
     
	@GetMapping(path = "/find-booking/{id}")
	public ResponseEntity<Booking> findBookingwithId(@PathVariable("id")Integer id) {
		Booking response=null;
		try {
			  response=service.findBookingById(id);
		} catch (NotFoundException e) {
			return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(response,HttpStatus.OK);
		
	}
	@PutMapping(path="/update-booking")
	public ResponseEntity<String>ubdateBookingDetails(@RequestBody Booking booking)
	{     
		try {
			service.updatebooking(booking);
					return new ResponseEntity<String>("DATA UPDATED SUCESSFULLY",HttpStatus.OK);
					
		} catch (NotFoundException e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.OK);
		}
	
		
	}
	 
}
