package com.java4u.hibernate5.model;

import javax.persistence.Entity;

@Entity
public class WildAnimal extends Animal {

	private String wildAnimalName;

	private String WildAnimalColor;

	public String getWildAnimalName() {
		return wildAnimalName;
	}

	public void setWildAnimalName(String wildAnimalName) {
		this.wildAnimalName = wildAnimalName;
	}

	public String getWildAnimalColor() {
		return WildAnimalColor;
	}

	public void setWildAnimalColor(String wildAnimalColor) {
		WildAnimalColor = wildAnimalColor;
	}

}
