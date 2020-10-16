package com.redbus.entities;

import java.util.Collection;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@OneToOne
	private Client client;
	
	@ElementCollection
	private Collection<TripManager> bookedSeatDetails;

	@ElementCollection
	private Collection<SpotData> tripSpotDetails;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Collection<TripManager> getBookedSeatDetails() {
		return bookedSeatDetails;
	}

	public void setBookedSeatDetails(Collection<TripManager> bookedSeatDetails) {
		this.bookedSeatDetails = bookedSeatDetails;
	}
	
}
