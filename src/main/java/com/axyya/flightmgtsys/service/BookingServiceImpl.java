package com.axyya.flightmgtsys.service;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axyya.flightmgtsys.App;
import com.axyya.flightmgtsys.model.Booking;
import com.axyya.flightmgtsys.model.FlightSchedule;
import com.axyya.flightmgtsys.repo.BookingRepo;
import com.axyya.flightmgtsys.repo.FlightScheduleRepo;

@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	BookingRepo repo;
	@Autowired
	FlightScheduleRepo flightScheduleRepo;
	private static final Logger log = LoggerFactory.getLogger(App.class);

	@Override
	@Transactional
	public boolean addBooking(Booking booking) {

		int flight_id = booking.getSchedule().getFlight().getFlightId();
		FlightSchedule f = flightScheduleRepo.findByDateAndFlightId(flight_id,
				booking.getBookingDateTime().toLocalDate());
		if(f==null)
		   return false;
		int availSeats = f.getAvailableSeat();
		if (availSeats > booking.getNoOfSeats()) {
			
			f.setAvailableSeat(availSeats - booking.getNoOfSeats());
			booking.setTotalAmount(booking.getNoOfSeats()*f.getFlight().getSeatPrice());
			booking.setSchedule(f);
			repo.save(booking);
			return true;
		} else {
			return false;
		}
	}
}
