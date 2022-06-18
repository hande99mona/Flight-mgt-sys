package com.axyya.flightmgtsys.service;

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
	public boolean addBooking(Booking booking) {

		int flight_id = booking.getSchedule().getFlight().getFlightId();
		FlightSchedule f = flightScheduleRepo.findByDateAndFlightId(flight_id,
				booking.getBookingDateTime().toLocalDate());
		int availSeats = f.getAvailableSeat();
		log.info("" + booking.getUser());
		if (availSeats > booking.getNoOfSeats()) {
			repo.save(booking);
			f.setAvailableSeat(availSeats - booking.getNoOfSeats());
			flightScheduleRepo.save(f);
			return true;
		} else {
			return false;
		}
	}
}
