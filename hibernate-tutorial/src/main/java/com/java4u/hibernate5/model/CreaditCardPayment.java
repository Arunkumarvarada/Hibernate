package com.java4u.hibernate5.model;

import javax.persistence.Entity;

@Entity
public class CreaditCardPayment extends Payment {

	private String CreditCardType;

	public String getCreditCardType() {
		return CreditCardType;
	}

	public void setCreditCardType(String creditCardType) {
		CreditCardType = creditCardType;
	}

}
