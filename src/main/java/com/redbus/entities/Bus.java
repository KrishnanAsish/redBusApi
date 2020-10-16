package com.redbus.entities;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.redbus.utils.RedBusConstants;

@Entity
public class Bus {

	@Id
	@GeneratedValue( strategy = GenerationType.AUTO)
	private int id;
	
	private String busName;
	
	@Column(unique = true)
	private String busRegNo;
	
	@ElementCollection(targetClass = RedBusConstants.BusType.class)
	@Enumerated(EnumType.STRING)
	private Collection<RedBusConstants.BusType> busFeatures;
	
	@OneToMany(mappedBy = "bus")
	private Collection<Seat> seats;
	
	@OneToMany
	private Collection<TripManager> tripDetails;

	public String getBusName() {
		return busName;
	}

	public void setBusName(String busName) {
		this.busName = busName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBusRegNo() {
		return busRegNo;
	}

	public void setBusRegNo(String busRegNo) {
		this.busRegNo = busRegNo;
	}

	public Collection<RedBusConstants.BusType> getBusFeatures() {
		return busFeatures;
	}

	public void setBusFeatures(Collection<RedBusConstants.BusType> busFeatures) {
		this.busFeatures = busFeatures;
	}

	public Collection<Seat> getSeats() {
		return seats;
	}

	public void setSeats(Collection<Seat> seats) {
		this.seats = seats;
	}

	public Collection<TripManager> getTripDetails() {
		return tripDetails;
	}

	public void setTripDetails(Collection<TripManager> tripDetails) {
		this.tripDetails = tripDetails;
	}
	
}
