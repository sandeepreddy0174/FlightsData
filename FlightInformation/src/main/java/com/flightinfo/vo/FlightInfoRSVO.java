package com.flightinfo.vo;

import java.time.LocalDate;

public class FlightInfoRSVO {
	private String flight_no;
	private String origin;
	private LocalDate departure_time;
	private String destination;
	private LocalDate arrival_time;
	private String airline;
	private String gate;
	private String status;

	/**
	 * @return the flight_no
	 */
	public String getFlight_no() {
		return flight_no;
	}

	/**
	 * @param flight_no the flight_no to set
	 */
	public void setFlight_no(String flight_no) {
		this.flight_no = flight_no;
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
	 * @return the departure_time
	 */
	public LocalDate getDeparture_time() {
		return departure_time;
	}

	/**
	 * @param departure_time the departure_time to set
	 */
	public void setDeparture_time(LocalDate departure_time) {
		this.departure_time = departure_time;
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
	 * @return the arrival_time
	 */
	public LocalDate getArrival_time() {
		return arrival_time;
	}

	/**
	 * @param arrival_time the arrival_time to set
	 */
	public void setArrival_time(LocalDate arrival_time) {
		this.arrival_time = arrival_time;
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

	@Override
	public String toString() {
		return "FlightInfoRSVO [flight_no=" + flight_no + ", origin=" + origin + ", departure_time=" + departure_time
				+ ", destination=" + destination + ", arrival_time=" + arrival_time + ", airline=" + airline + ", gate="
				+ gate + ", status=" + status + "]";
	}

}
