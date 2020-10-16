package com.redbus.vo;

import java.util.Date;
import java.util.List;
import java.util.Set;

import com.redbus.entities.Seat;


public class SeatLockVO {

	String busName;
	String source;
	String destination;
	String startTime;
	List<SeatVO> selectedSeats;
	
	
	public List<SeatVO> getSelectedSeats() {
		return selectedSeats;
	}
	public void setSelectedSeats(List<SeatVO> selectedSeats) {
		this.selectedSeats = selectedSeats;
	}
	public String getBusName() {
		return busName;
	}
	public void setBusName(String busName) {
		this.busName = busName;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	
	
}
