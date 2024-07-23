package com.flightinfo.serviceImpl;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.flightinfo.entity.FlightInfoEntity;
import com.flightinfo.repository.FlightInfoRepository;
import com.flightinfo.service.FlightInfoService;
import com.flightinfo.vo.FlightInfoRSVO;
import com.flightinfo.vo.FlightInfoResponseVO;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.opencsv.CSVWriter;

import jakarta.servlet.http.HttpServletResponse;

@Service
public class FlightInfoServiceImpl implements FlightInfoService {

	@Value("${flight.info.api.url}")
	private String url;

	@Autowired
	private FlightInfoRepository flightInfoRepository;

	private final RestTemplate restTemplate = new RestTemplate();

	@Override
	public void fetchAndSaveFlightInfo() {

		FlightInfoResponseVO response = restTemplate.getForObject(url, FlightInfoResponseVO.class);
		for (FlightInfoRSVO responseVO : response.getFlights()) {
			FlightInfoEntity flightInfoEntity = new FlightInfoEntity();
			flightInfoEntity.setFlightNo(responseVO.getFlight_no());
			flightInfoEntity.setOrigin(responseVO.getOrigin());
			flightInfoEntity.setDepartureTime(responseVO.getDeparture_time());
			flightInfoEntity.setDestination(responseVO.getDestination());
			flightInfoEntity.setArrivalTime(responseVO.getArrival_time());
			flightInfoEntity.setAirline(responseVO.getAirline());
			flightInfoEntity.setGate(responseVO.getGate());
			flightInfoEntity.setStatus(responseVO.getStatus());
			System.out.println(responseVO);
			flightInfoRepository.save(flightInfoEntity);

		}

	}

	@Override
	public void exportFlights(LocalDate fromDate, LocalDate toDate, String format, HttpServletResponse response) {
		List<FlightInfoEntity> flights = getFlightInfo(fromDate, toDate);
		System.out.println(flights);
		switch (format.toLowerCase()) {
		case "csv":
			exportFlightsToCsv(flights, response);
			break;
		case "pdf":
			exportFlightsToPdf(flights, response);
			break;
		case "json":
			exportToJson(flights, response);
			break;
		default:
			throw new IllegalArgumentException("Unsupported format: " + format);
		}
	}

	private void exportToJson(List<FlightInfoEntity> flights, HttpServletResponse response) {
		response.setContentType("application/json");
		response.setHeader("Content-Disposition", "attachment; filename=FilteredFlightInfo.json");
		ObjectMapper objectMapper = null;

		try {
			objectMapper = new ObjectMapper();
			objectMapper.registerModule(new JavaTimeModule());
			response.getWriter().write(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(flights));
		} catch (IOException e) {
			throw new RuntimeException("Failed to write JSON", e);
		}
	}

	private void exportFlightsToPdf(List<FlightInfoEntity> flights, HttpServletResponse response) {

		response.setContentType("application/pdf");
		response.setHeader("Content-Disposition", "attachment; filename=FilteredFlightInfo.pdf");

		Document document = new Document();
		try {
			PdfWriter.getInstance(document, response.getOutputStream());
			document.open();

			for (FlightInfoEntity flight : flights) {
				document.add(new Paragraph("Flight Number:" + flight.getFlightNo()));
				document.add(new Paragraph("Airline: " + flight.getAirline()));
				document.add(new Paragraph("Origin: " + flight.getOrigin()));
				document.add(new Paragraph("Destination: " + flight.getDestination()));
				document.add(new Paragraph("Departure Time: " + flight.getDepartureTime().toString()));
				document.add(new Paragraph("Arrival Time: " + flight.getArrivalTime().toString()));
				document.add(new Paragraph(" "));
			}

			document.close();
		} catch (DocumentException | IOException e) {
			throw new RuntimeException("Failed to write PDF", e);
		}

	}

	private void exportFlightsToCsv(List<FlightInfoEntity> flights, HttpServletResponse response) {
		response.setContentType("text/csv");
		response.setHeader("Content-Disposition", "attachment; filename=FilteredFlightInfo.csv");

		try (CSVWriter writer = new CSVWriter(response.getWriter())) {
			String[] header = { "Flight Number", "Airline", "Origin", "Destination", "Departure Time", "Arrival Time" };
			writer.writeNext(header);

			for (FlightInfoEntity flight : flights) {
				writer.writeNext(new String[] { flight.getFlightNo(), flight.getAirline(), flight.getOrigin(),
						flight.getDestination(), flight.getDepartureTime().toString(),
						flight.getArrivalTime().toString() });
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private List<FlightInfoEntity> getFlightInfo(LocalDate fromDate, LocalDate toDate) {
		List<FlightInfoEntity> flightInfoEntity = flightInfoRepository.findByDepartureTimeBetween(fromDate, toDate);
		return flightInfoEntity;
	}

}
