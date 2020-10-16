package com.redbus.entities;

import java.util.Date;

import javax.persistence.Embeddable;

@Embeddable
public class SpotData {

	private String landMarkDetails;
	
	private Date spotTime;
	
	private String phoneNumber;

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
	
}
