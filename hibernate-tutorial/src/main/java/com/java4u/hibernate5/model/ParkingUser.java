package com.java4u.hibernate5.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ParkingUser")

public class ParkingUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ParkingUserId")
	private int parkingUserId;

	@Column(name = "parkingUserName")
	private String name;

	@ManyToOne
	private ParkingSpace parkingSpace;

	public int getParkingUserId() {
		return parkingUserId;
	}

	public void setParkingUserId(int parkingUserId) {
		this.parkingUserId = parkingUserId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ParkingSpace getParkingSpace() {
		return parkingSpace;
	}

	public void setParkingSpace(ParkingSpace parkingSpace) {
		this.parkingSpace = parkingSpace;
	}

}
