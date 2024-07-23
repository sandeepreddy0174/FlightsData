package com.flightinfo.vo;

import java.util.List;

import lombok.Data;

@Data
public class FlightInfoResponseVO {

	List<FlightInfoRSVO> flights;

	/**
	 * @return the flights
	 */
	public List<FlightInfoRSVO> getFlights() {
		return flights;
	}

	/**
	 * @param flights the flights to set
	 */
	public void setFlights(List<FlightInfoRSVO> flights) {
		this.flights = flights;
	}

}
