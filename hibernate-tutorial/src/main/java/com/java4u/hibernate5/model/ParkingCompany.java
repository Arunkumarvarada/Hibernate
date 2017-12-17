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
@Table(name = "ParkingCompany")
public class ParkingCompany {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "parkingCompanyId")
	private int parkingCompanyId;

	@Column(name = "parkingCompanyName")
	private String parkingCompanyName;

	@ManyToMany(mappedBy = "parkingCompanies")
	private List<ParkingSite> sites = new ArrayList<>();

	public int getParkingCompanyId() {
		return parkingCompanyId;
	}

	public void setParkingCompanyId(int parkingCompanyId) {
		this.parkingCompanyId = parkingCompanyId;
	}

	public String getParkingCompanyName() {
		return parkingCompanyName;
	}

	public void setParkingCompanyName(String parkingCompanyName) {
		this.parkingCompanyName = parkingCompanyName;
	}

	public List<ParkingSite> getSites() {
		return sites;
	}

	public void setSites(List<ParkingSite> sites) {
		this.sites = sites;
	}

}
