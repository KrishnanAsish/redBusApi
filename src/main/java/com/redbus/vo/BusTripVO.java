package com.redbus.vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.redbus.utils.RedBusConstants;

public class BusTripVO {

	private String busName;
	
	private int seatsAvailable;
	
	private float price;
	
	private String journeyStartTime;
	
	private String journeyEndTime;
	
	private List<RedBusConstants.BusType> busFacilities = new ArrayList<>();

	public String getBusName() {
		return busName;
	}

	public void setBusName(String busName) {
		this.busName = busName;
	}

	public int getSeatsAvailable() {
		return seatsAvailable;
	}

	public void setSeatsAvailable(int seatsAvailable) {
		this.seatsAvailable = seatsAvailable;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getJourneyStartTime() {
		return journeyStartTime;
	}

	public void setJourneyStartTime(String journeyStartTime) {
		this.journeyStartTime = journeyStartTime;
	}

	public String getJourneyEndTime() {
		return journeyEndTime;
	}

	public void setJourneyEndTime(String journeyEndTime) {
		this.journeyEndTime = journeyEndTime;
	}

	public List<RedBusConstants.BusType> getBusFacilities() {
		return busFacilities;
	}

	public void setBusFacilities(List<RedBusConstants.BusType> busFacilities) {
		this.busFacilities = busFacilities;
	}
	
}
