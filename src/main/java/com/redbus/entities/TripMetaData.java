package com.redbus.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class TripMetaData implements Serializable{

	@Id
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "trip_id")
	private Trip trip;
	
	private String landMarkDetails;
	
	private Date spotTime;
	
	private String phoneNumber;
	
	private boolean isPickupPoint;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Trip getTrip() {
		return trip;
	}

	public void setTrip(Trip trip) {
		this.trip = trip;
	}

	public String getLandMarkDetails() {
		return landMarkDetails;
	}

	public void setLandMarkDetails(String landMarkDetails) {
		this.landMarkDetails = landMarkDetails;
	}

	public Date getSpotTime() {
		return spotTime;
	}

	public void setSpotTime(Date spotTime) {
		this.spotTime = spotTime;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public boolean isPickupPoint() {
		return isPickupPoint;
	}

	public void setPickupPoint(boolean isPickupPoint) {
		this.isPickupPoint = isPickupPoint;
	}
	
}
