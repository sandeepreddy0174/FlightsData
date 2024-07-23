package com.flightinfo.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flightinfo.entity.FlightInfoEntity;

@Repository
public interface FlightInfoRepository extends JpaRepository<FlightInfoEntity, Long>{

	List<FlightInfoEntity> findByDepartureTimeBetween(LocalDate fromDate, LocalDate toDate);

}
