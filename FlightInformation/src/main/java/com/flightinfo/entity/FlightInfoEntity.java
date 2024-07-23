package com.flightinfo.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Flight_Data")
public class FlightInfoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "FLT_NO")
	private String flightNo;

	@Column(name = "ORIGIN")
	private String origin;

	@Column(name = "DEP_TIME")
	private LocalDate departureTime;

	@Column(name = "DESTINATION")
	private String destination;

	@Column(name = "ARR_TIME")
	private LocalDate arrivalTime;

	@Column(name = "AIRLINE_NAME")
	private String airline;

	@Column(name = "GATE_NO")
	private String gate;

	@Column(name = "FLT_STATUS")
	private String status;

	public FlightInfoEntity() {

	}

	public FlightInfoEntity(String flightNo, String origin, LocalDate departureTime, String destination,
			LocalDate arrivalTime, String airline, String gate, String status) {
		super();
		this.flightNo = flightNo;
		this.origin = origin;
		this.departureTime = departureTime;
		this.destination = destination;
		this.arrivalTime = arrivalTime;
		this.airline = airline;
		this.gate = gate;
		this.status = status;
	}

	/**
	 * @return the flightNo
	 */
	public String getFlightNo() {
		return flightNo;
	}

	/**
	 * @param flightNo the flightNo to set
	 */
	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}

	/**
	 * @return the origin
	 */
	public String getOrigin() {
		return origin;
	}

	/**
	 * @param origin the origin to set
	 */
	public void setOrigin(String origin) {
		this.origin = origin;
	}

	/**
	 * @return the departureTime
	 */
	public LocalDate getDepartureTime() {
		return departureTime;
	}

	/**
	 * @param departureTime the departureTime to set
	 */
	public void setDepartureTime(LocalDate departureTime) {
		this.departureTime = departureTime;
	}

	/**
	 * @return the destination
	 */
	public String getDestination() {
		return destination;
	}

	/**
	 * @param destination the destination to set
	 */
	public void setDestination(String destination) {
		this.destination = destination;
	}

	/**
	 * @return the arrivalTime
	 */
	public LocalDate getArrivalTime() {
		return arrivalTime;
	}

	/**
	 * @param arrivalTime the arrivalTime to set
	 */
	public void setArrivalTime(LocalDate arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	/**
	 * @return the airline
	 */
	public String getAirline() {
		return airline;
	}

	/**
	 * @param airline the airline to set
	 */
	public void setAirline(String airline) {
		this.airline = airline;
	}

	/**
	 * @return the gate
	 */
	public String getGate() {
		return gate;
	}

	/**
	 * @param gate the gate to set
	 */
	public void setGate(String gate) {
		this.gate = gate;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

}
