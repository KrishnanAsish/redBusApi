package com.redbus.vo;

import com.redbus.entities.SeatPosition;
import com.redbus.utils.RedBusConstants;

public class SeatSelectionVO {

	private String name;
	
	private SeatPosition seatPosition;
	
	private float price;
	
	private RedBusConstants.SeatStatus seatStatus;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public SeatPosition getSeatPosition() {
		return seatPosition;
	}

	public void setSeatPosition(SeatPosition seatPosition) {
		this.seatPosition = seatPosition;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public RedBusConstants.SeatStatus getSeatStatus() {
		return seatStatus;
	}

	public void setSeatStatus(RedBusConstants.SeatStatus seatStatus) {
		this.seatStatus = seatStatus;
	}
	
}
