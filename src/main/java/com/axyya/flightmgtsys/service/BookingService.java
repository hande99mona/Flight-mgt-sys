package com.axyya.flightmgtsys.service;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;

import com.axyya.flightmgtsys.model.Booking;

import javassist.NotFoundException;

public interface BookingService {
	 public boolean addBooking(Booking booking) throws NotFoundException;
	 public Booking findBookingById(Integer id) throws NotFoundException;
	 public List<Booking> getAllBookings()throws EmptyResultDataAccessException;
	 public boolean updatebooking(Booking booking) throws NotFoundException;

}
