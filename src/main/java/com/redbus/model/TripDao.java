package com.redbus.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.redbus.entities.Trip;
import com.redbus.entities.TripManager;

@Repository
public interface TripDao extends CrudRepository<Trip, Integer>{

	public List<Trip> findTripBySourceAndDestinationAndStartTimeAfter(String source,String destination,Date journeyDate);
	
	public Trip findTripBySourceAndDestinationAndStartTime(String source,String destination,Date journeyDate);
}
