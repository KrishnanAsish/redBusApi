package com.redbus.model;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.redbus.entities.Bus;
import com.redbus.entities.Trip;
import com.redbus.entities.TripManager;

@Repository
public interface TripManagerDao extends CrudRepository<TripManager, Integer>{

	//@Query(value="select ")
	//public List<TripManager> findSeatUnavailableForTheTrip(int tripId);
	
	public List<TripManager> findByTripId(int tripId);
}
