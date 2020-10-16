package com.redbus.entities;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.redbus.utils.RedBusConstants;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"bus_id","trip_id","seat_id"}))
public class TripManager {

	public TripManager() {
		
	}
	
	public TripManager(Bus bus,Trip trip,Seat seat, RedBusConstants.SeatStatus seatStatus) {
		this.bus=bus;
		this.trip=trip;
		this.seat=seat;
		this.seatStatus=seatStatus;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@OneToOne
	private Bus bus;
	
	@OneToOne
	private Trip trip;
	
	@OneToOne
	private Seat seat;
	
	@Enumerated
	private RedBusConstants.SeatStatus seatStatus;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Bus getBus() {
		return bus;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}

	public Trip getTrip() {
		return trip;
	}

	public void setTrip(Trip trip) {
		this.trip = trip;
	}

	public Seat getSeat() {
		return seat;
	}

	public void setSeat(Seat seat) {
		this.seat = seat;
	}

	public RedBusConstants.SeatStatus getSeatStatus() {
		return seatStatus;
	}

	public void setSeatStatus(RedBusConstants.SeatStatus seatStatus) {
		this.seatStatus = seatStatus;
	}
	
}
