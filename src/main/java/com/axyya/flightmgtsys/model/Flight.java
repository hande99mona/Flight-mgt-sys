package com.axyya.flightmgtsys.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;

@Entity
@Scope(scopeName="prototype")
@Table(name ="flight_details")
public class Flight implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int flightId;
	private String carrierName;
	private String source;
	private String destination;
	private Double seatPrice;
	
	public Flight() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Flight(String carrierName, String source, String destination, Double seatPrice) {
		super();
		this.carrierName = carrierName;
		this.source = source;
		this.destination = destination;
		this.seatPrice = seatPrice;
	}

	public Double getSeatPrice() {
		return seatPrice;
	}

	public void setSeatPrice(Double seatPrice) {
		this.seatPrice = seatPrice;
	}

	public int getFlightId() {
		return flightId;
	}
	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}
	public String getCarrierName() {
		return carrierName;
	}
	public void setCarrierName(String carrierName) {
		this.carrierName = carrierName;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Flight [flightId=" + flightId + ", carrierName=" + carrierName + ", source=" + source + ", destination="
				+ destination + ", seatPrice=" + seatPrice + "]";
	}
	
	
}

