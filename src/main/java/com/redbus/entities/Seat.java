package com.redbus.entities;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.redbus.utils.RedBusConstants;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"name","bus_id","row","col","isUpper"}))
public class Seat {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "bus_id")
	private Bus bus;
	
	private SeatPosition seatPosition;
	
	private float price;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Bus getBus() {
		return bus;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}

	public SeatPosition getSeatPosition() {
		return seatPosition;
	}

	public void setSeatPosition(SeatPosition seatPosition) {
		this.seatPosition = seatPosition;
	}

	public float getBasePrice() {
		return price;
	}

	public void setBasePrice(float basePrice) {
		this.price = basePrice;
	}
	
}
