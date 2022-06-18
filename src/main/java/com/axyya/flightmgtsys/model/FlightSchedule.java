package com.axyya.flightmgtsys.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;

@Entity
@Scope(scopeName = "prototype")
@Table(name = "flight_schedule")
public class FlightSchedule {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@OneToOne
	@JoinColumn(name = "flight_id")
	private Flight flight;
	private LocalDate date;
	private Integer availableSeat;

	public FlightSchedule() {
	}

	public FlightSchedule(Flight flight, LocalDate date, Integer availableSeat) {
		this.flight = flight;
		this.date = date;
		this.availableSeat = availableSeat;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Integer getAvailableSeat() {
		return availableSeat;
	}

	public void setAvailableSeat(Integer availableSeat) {
		this.availableSeat = availableSeat;
	}

	@Override
	public String toString() {
		return "FlightSchedule [id=" + id + ", flight=" + flight + ", date=" + date + ", availableSeat=" + availableSeat
				+ "]";
	}

}
