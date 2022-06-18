package com.axyya.flightmgtsys.service;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.axyya.flightmgtsys.App;
import com.axyya.flightmgtsys.model.Booking;
import com.axyya.flightmgtsys.model.FlightSchedule;
import com.axyya.flightmgtsys.repo.BookingRepo;
import com.axyya.flightmgtsys.repo.FlightScheduleRepo;

import javassist.NotFoundException;

@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	BookingRepo repo;
	@Autowired
	FlightScheduleRepo flightScheduleRepo;
	private static final Logger log = LoggerFactory.getLogger(App.class);

	@Override
	@Transactional
	public boolean addBooking(Booking booking) throws NotFoundException {

		int flight_id = booking.getSchedule().getFlight().getFlightId();
		FlightSchedule f = flightScheduleRepo.findByDateAndFlightId(flight_id,
				booking.getBookingDateTime().toLocalDate());
		if (f == null)
			throw new NotFoundException("flight is not available for this schedule");
		int availSeats = f.getAvailableSeat();
		if (availSeats > booking.getNoOfSeats()) {

			f.setAvailableSeat(availSeats - booking.getNoOfSeats());
			booking.setTotalAmount(booking.getNoOfSeats() * f.getFlight().getSeatPrice());
			booking.setSchedule(f);
			repo.save(booking);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Booking findBookingById(Integer id) throws NotFoundException {

		if (!repo.existsById(id))
			throw new NotFoundException("no such bokking fond");
		return repo.findById(id).get();

	}

	@Override
	public List<Booking> getAllBookings()throws EmptyResultDataAccessException{
		if(repo.findAll().isEmpty())
			throw new EmptyResultDataAccessException("no bboings to display",0);
		return repo.findAll();
	}

	@Override
	public boolean updatebooking(Booking booking) throws NotFoundException {
		//Booking booking1=repo.findById(booking.getBookingId()).get();
        if(repo.existsById(booking.getBookingId())){
        	repo.save(booking);
        	return true;
        }
		throw new NotFoundException("UNABLE TO FETCH BOOKING WITH ID  "+booking.getBookingId());
	}

	
}
