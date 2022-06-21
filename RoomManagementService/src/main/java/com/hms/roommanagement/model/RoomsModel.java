package com.hms.roommanagement.model;

import java.time.LocalDate;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Configuration
@Document(collection="rooms")
public class RoomsModel {
	
	@MongoId
	private int id;//Room No
	
	@Indexed
	private String roomName;
	
	@Indexed
	private String bedType;
	
	private double price;
	
	private String description;
	
	@Indexed
	private String status;
	
	private List<Bookings> bookings;

	//NoArgs Constructor
	public RoomsModel() {
		super();
	}

	//AllArgs Constructor
	public RoomsModel(int id, String roomName, String bedType, double price, String description, String status,
			List<Bookings> bookings) {
		super();
		this.id = id;
		this.roomName = roomName;
		this.bedType = bedType;
		this.price = price;
		this.description = description;
		this.status = status;
		this.bookings = bookings;
	}
	

	public RoomsModel(List<Bookings> bookings) {
		super();
		this.bookings = bookings;
	}
	
	public boolean isAvailabeBetween(LocalDate checkInDate, LocalDate checkOutDate) {
		boolean available = bookings
				.stream()
				.anyMatch(o->
				(checkInDate.isAfter(o.getCheckInDate()) || checkInDate.isEqual(o.getCheckInDate())) &&
				(checkOutDate.isBefore(o.getCheckOutDate()) || checkOutDate.isEqual(o.getCheckOutDate()))
				);
		return !available;
	}

	//Getters and Setters
	public int getId() {
		return id;
	}

	

	public void setId(int id) {
		this.id = id;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}


	public String getBedType() {
		return bedType;
	}

	public void setBedType(String bedType) {
		this.bedType = bedType;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Bookings> getBookings() {
		return bookings;
	}

	public void setBookings(List<Bookings> bookings) {
		this.bookings = bookings;
	}

	
	
}
