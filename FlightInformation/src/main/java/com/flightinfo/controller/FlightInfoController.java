package com.flightinfo.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.flightinfo.service.FlightInfoService;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/flightinfo")
public class FlightInfoController {

	private FlightInfoService flightInfoService;

	@Autowired
	public FlightInfoController(FlightInfoService flightInfoService) {
		this.flightInfoService = flightInfoService;
	}
	
	@GetMapping(value = "/fetchAndSave")
	public ResponseEntity<String> fetchAndSave() {
		flightInfoService.fetchAndSaveFlightInfo();
		return null;
		
	}
	
	
	@GetMapping("/export")
    public void exportExchangeRates(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fromDate,
                                    @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate toDate,
                                    @RequestParam String format, HttpServletResponse response) {
		flightInfoService.exportFlights(fromDate,toDate,format,response);
    }
}
