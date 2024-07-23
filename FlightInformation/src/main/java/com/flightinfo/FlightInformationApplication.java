package com.flightinfo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.flightinfo.service.FlightInfoService;

@SpringBootApplication
public class FlightInformationApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlightInformationApplication.class, args);
	}
}
