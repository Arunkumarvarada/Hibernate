package com.java4u.hibernate5.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ParkingSpace")
public class ParkingSpace {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "parkingSpaceId")
	private int parkingSpaceId;

	@Column(name = "parkingSpaceName")
	private String parkingSpaceName;

	@OneToMany
	@JoinTable(name="ParkingSpaceUserMapping",joinColumns = @JoinColumn(name = "parkingSpaceId"), inverseJoinColumns = @JoinColumn(name = "parkingUserId"))
	private List<ParkingUser> parkingUser = new ArrayList<ParkingUser>();

	public int getParkingSpaceId() {
		return parkingSpaceId;
	}

	public void setParkingSpaceId(int parkingSpaceId) {
		this.parkingSpaceId = parkingSpaceId;
	}

	public String getParkingSpaceName() {
		return parkingSpaceName;
	}

	public void setParkingSpaceName(String parkingSpaceName) {
		this.parkingSpaceName = parkingSpaceName;
	}

	public List<ParkingUser> getParkingUser() {
		return parkingUser;
	}

	public void setParkingUser(List<ParkingUser> parkingUser) {
		this.parkingUser = parkingUser;
	}

}
