package com.axyya.flightmgtsys.FlightMgtSys;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.CoreMatchers.notNullValue;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.axyya.flightmgtsys.controller.BookingController;
import com.axyya.flightmgtsys.model.Booking;
import com.axyya.flightmgtsys.model.Flight;
import com.axyya.flightmgtsys.model.FlightSchedule;
import com.axyya.flightmgtsys.model.Gender;
import com.axyya.flightmgtsys.model.Passenger;
import com.axyya.flightmgtsys.model.User;
import com.axyya.flightmgtsys.repo.BookingRepo;
import com.axyya.flightmgtsys.service.BookingService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(BookingController.class)
public class BookingControllerTest {
	 @Autowired
	 MockMvc mockMvc;
	 
	 @Autowired
	 ObjectMapper mapper;
	 @MockBean
	 BookingService service;
	 @MockBean
	 BookingRepo bookingRepo;
	 @Test
	 public void testGetBookings() throws Exception {
		 Booking booking = new Booking();
		 booking.setBookingId(1);
		 booking.setTotalAmount(2570);
		 booking.setBookingDateTime(LocalDateTime.now());
		 booking.setPassengerinfo(List.of(new Passenger("Shariq", 23, Gender.MALE)));
		 booking.setUser(new User("Shariq", "mail@gmail.com", "1234567890", new char[] {'1','2'}, Gender.MALE, 23));
		 booking.setSchedule(new FlightSchedule(new Flight("Sprice Jet", "Delhi" ,"Pune",200.0),LocalDate.now(),50));
		 
		 Mockito.when(service.getAllBookings()).thenReturn(List.of(booking));
		 mockMvc.perform(MockMvcRequestBuilders
		            .get("/booking/show-bookings").contentType(MediaType.APPLICATION_JSON))
		 			.andDo(print())
			        .andExpect(status().isOk())
			        .andExpect(jsonPath("$", hasSize(1)))
			        .andExpect(jsonPath("$[0].totalAmount", is(2570.0)));
	 }
	 @Test
	 public void testGetBookingById() throws Exception {
		 Booking booking = new Booking();
		 booking.setBookingId(1);
		 booking.setTotalAmount(2570);
		 booking.setBookingDateTime(LocalDateTime.now());
		 booking.setPassengerinfo(List.of(new Passenger("Shariq", 23, Gender.MALE)));
		 booking.setUser(new User("Shariq", "mail@gmail.com", "1234567890", new char[] {'1','2'}, Gender.MALE, 23));
		 booking.setSchedule(new FlightSchedule(new Flight("Sprice Jet", "Delhi" ,"Pune",200.0),LocalDate.now(),50));
		 
		 Mockito.when(service.findBookingById(Mockito.anyInt())).thenReturn(booking);
		 mockMvc.perform(MockMvcRequestBuilders
		            .get("/booking/find-booking/1").contentType(MediaType.APPLICATION_JSON))
		 			.andDo(print())
			        .andExpect(status().isOk())
			        .andExpect(jsonPath("$", notNullValue()))
			        .andExpect(jsonPath("$.totalAmount", is(2570.0)));
	 }
	 
	 @Test
	 public void testAddBooking() throws Exception {
		 Booking booking = new Booking();
		 booking.setBookingId(1);
		 booking.setTotalAmount(2570);
		 booking.setBookingDateTime(LocalDateTime.now());
		 booking.setPassengerinfo(List.of(new Passenger("Shariq", 23, Gender.MALE)));
		 Mockito.when(service.addBooking(Mockito.any(Booking.class))).thenReturn(true);
		 MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/booking/add-booking")
		            .contentType(MediaType.APPLICATION_JSON)
		            .accept(MediaType.APPLICATION_JSON)
		            .content(this.mapper.writeValueAsString(booking));
		 mockMvc.perform(mockRequest)
		         .andExpect(status().isOk());
	 }
	 @Test
	 public void testUpdateBooking() throws Exception {
		 Booking booking = new Booking();
		 booking.setBookingId(1);
		 booking.setTotalAmount(2570);
		 booking.setBookingDateTime(LocalDateTime.now());
		 booking.setPassengerinfo(List.of(new Passenger("Shariq", 23, Gender.MALE)));
		 Mockito.when(service.updatebooking(Mockito.any(Booking.class))).thenReturn(true);
		 MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.put("/booking/update-booking")
		            .contentType(MediaType.APPLICATION_JSON)
		            .accept(MediaType.APPLICATION_JSON)
		            .content(this.mapper.writeValueAsString(booking));
		 mockMvc.perform(mockRequest)
		         .andExpect(status().isOk());
	 }
}	
