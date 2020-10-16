package com.redbus.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.redbus.entities.Bus;
import com.redbus.entities.Trip;

@Repository
public interface BusDao extends CrudRepository<Bus, Integer>{

	//public Bus findByBusNameAnd
}
