package com.flightinfo.service;

import java.time.LocalDate;

import jakarta.servlet.http.HttpServletResponse;

public interface FlightInfoService {
	
	
	void fetchAndSaveFlightInfo();
	
	void exportFlights(LocalDate fromDate,LocalDate toDate, String format, HttpServletResponse response);

}
