package com.redbus.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.redbus.entities.Bus;
import com.redbus.entities.Trip;
import com.redbus.entities.TripMetaData;

@Repository
public interface TripMetaDataDao extends CrudRepository<TripMetaData, Integer>{

}
