package com.axyya.flightmgtsys.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;

@Entity
@Scope(scopeName = "prototype")
@Table(name = "flight_booking")
public class Booking implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer bookingId;
	private double totalAmount;
	private LocalDateTime bookingDateTime;
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "user_id")
	private User user;
	@ElementCollection
	List<Passenger> passengerinfo;

	@OneToOne
	FlightSchedule schedule;

	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Booking(double totalAmount, LocalDateTime bookingDateTime, User user, List<Passenger> passengerinfo,
			FlightSchedule schedule) {
		super();
		this.totalAmount = totalAmount;
		this.bookingDateTime = bookingDateTime;
		this.user = user;
		this.passengerinfo = passengerinfo;
		this.schedule = schedule;
	}

	public List<Passenger> getPassengerinfo() {
		return passengerinfo;
	}

	public void setPassengerinfo(List<Passenger> passengerinfo) {
		this.passengerinfo = passengerinfo;
	}

	public Integer getBookingId() {
		return bookingId;
	}

	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public LocalDateTime getBookingDateTime() {
		return bookingDateTime;
	}

	public void setBookingDateTime(LocalDateTime bookingDateTime) {
		this.bookingDateTime = bookingDateTime;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getNoOfSeats() {
		return this.passengerinfo.size();
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public FlightSchedule getSchedule() {
		return schedule;
	}

	public void setSchedule(FlightSchedule schedule) {
		this.schedule = schedule;
	}

	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", totalAmount=" + totalAmount + ", bookingDateTime="
				+ bookingDateTime + ", user=" + user + ", passengerinfo=" + passengerinfo + ", schedule=" + schedule
				+ "]";
	}

}
