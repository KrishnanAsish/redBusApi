package com.redbus.api;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.redbus.service.TripService;
import com.redbus.vo.SeatLockVO;

@RestController
public class BookingController {

	@Autowired
	TripService tripService;
	
	@RequestMapping(path="/trips")
	public ResponseEntity<?> getTrips(@RequestParam("source") String source,
			@RequestParam("destination") String destination,
			@RequestParam("journey_date") 
	  @DateTimeFormat(pattern = "dd.MM.yyyy") Date journeyDate) {
		try {
			return new ResponseEntity(tripService.fetchTripsBasedOnTimeAndPlace(source,destination, journeyDate),
					HttpStatus.FOUND);
		}catch(Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.EXPECTATION_FAILED);
		}
	}
	
	
	@RequestMapping(path="/trips/buses/view_seats")
	public ResponseEntity<?> viewSeatForBusTrip(@RequestParam("bus_name") String busName,
			@RequestParam("source") String source,
			@RequestParam("destination") String destination,
			@RequestParam("journey_date") 
	  @DateTimeFormat(pattern = "dd.MM.yyyy.HH.mm") Date startTime) {
		try {
			return new ResponseEntity(tripService.showSeatLayoutForBus(busName, source,destination,startTime),
					HttpStatus.FOUND);
		}catch(Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.EXPECTATION_FAILED);
		}
	}
	
	@RequestMapping(method = RequestMethod.POST, path="/trips/buses/lock_seats" )
	public ResponseEntity<?> lockSeatsForBusTrip(@RequestBody SeatLockVO seatDetails) {
		try {
			return new ResponseEntity(tripService.lockSeats(seatDetails),
					HttpStatus.FOUND);
		}catch(Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.EXPECTATION_FAILED);
		}
	}
	
}
