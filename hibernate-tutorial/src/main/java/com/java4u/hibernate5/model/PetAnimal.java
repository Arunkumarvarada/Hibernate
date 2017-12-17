package com.java4u.hibernate5.model;

import javax.persistence.Entity;

@Entity
public class PetAnimal extends Animal {
	
	private String petName;
	private String color;

	public String getPetName() {
		return petName;
	}

	public void setPetName(String petName) {
		this.petName = petName;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

}
