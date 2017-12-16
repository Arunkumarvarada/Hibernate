package com.java4u.hibernate5.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ParkingSite")
public class ParkingSite {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "parkingSiteId")
	private int parkingSiteId;

	@Column(name = "parkingSiteName")
	private String parkingSiteName;

	@ManyToMany
	private List<ParkingCompany> parkingCompanies = new ArrayList<>();

	public int getParkingSiteId() {
		return parkingSiteId;
	}

	public void setParkingSiteId(int parkingSiteId) {
		this.parkingSiteId = parkingSiteId;
	}

	public String getParkingSiteName() {
		return parkingSiteName;
	}

	public void setParkingSiteName(String parkingSiteName) {
		this.parkingSiteName = parkingSiteName;
	}

	public List<ParkingCompany> getParkingCompanies() {
		return parkingCompanies;
	}

	public void setParkingCompanies(List<ParkingCompany> parkingCompanies) {
		this.parkingCompanies = parkingCompanies;
	}

}
