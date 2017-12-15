package com.java4u.hibernate5.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ADDRESS")
public class Address {

	@Id
	@Column(name = "Address_ID")
	private Long id;

	@Column(name = "CITY")
	private String city;

	@Column(name = "STATE")
	private String State;

	@Enumerated(EnumType.STRING)
	@Column(name = "Address_Type")
	private AddressType addressType;

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "phone_type")
	private Phone phone;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return State;
	}

	public void setState(String state) {
		State = state;
	}

	public AddressType getAddressType() {
		return addressType;
	}

	public void setAddressType(AddressType addressType) {
		this.addressType = addressType;
	}

	public Phone getPhone() {
		return phone;
	}

	public void setPhone(Phone phone) {
		this.phone = phone;
	}

}
