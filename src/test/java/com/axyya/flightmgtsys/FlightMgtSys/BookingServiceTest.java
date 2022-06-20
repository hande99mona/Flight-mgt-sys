package com.axyya.flightmgtsys.FlightMgtSys;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.axyya.flightmgtsys.model.Booking;
import com.axyya.flightmgtsys.model.Flight;
import com.axyya.flightmgtsys.model.FlightSchedule;
import com.axyya.flightmgtsys.model.Gender;
import com.axyya.flightmgtsys.model.Passenger;
import com.axyya.flightmgtsys.model.User;
import com.axyya.flightmgtsys.repo.BookingRepo;
import com.axyya.flightmgtsys.service.BookingService;
import com.axyya.flightmgtsys.service.BookingServiceImpl;

import javassist.NotFoundException;

@ExtendWith(SpringExtension.class)
public class BookingServiceTest {
	@Autowired
	BookingService bookingService;
	@MockBean
	BookingRepo bookingRepo;
	
	@TestConfiguration
	static class BookingServiceTestConfiguration{
		@Bean
		public BookingService createBookingService() {
			return new BookingServiceImpl();
		}
	}
	@Test
	public void addBookingTest() throws NotFoundException {
		 Booking booking = new Booking();
		 booking.setBookingId(1);
		 booking.setTotalAmount(2570);
		 booking.setBookingDateTime(LocalDateTime.now());
		 booking.setPassengerinfo(List.of(new Passenger("Shariq", 23, Gender.MALE)));
		 booking.setUser(new User("Shariq", "mail@gmail.com", "1234567890", new char[] {'1','2'}, Gender.MALE, 23));
		 booking.setSchedule(new FlightSchedule(new Flight("Sprice Jet", "Delhi" ,"Pune",200.0),LocalDate.now(),50));
		 Mockito.when(bookingRepo.save(Mockito.any(Booking.class))).thenReturn(booking);
		 assertEquals(true,bookingService.addBooking(booking));
	}
}
