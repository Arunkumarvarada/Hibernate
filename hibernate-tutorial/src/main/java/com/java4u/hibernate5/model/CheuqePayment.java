package com.java4u.hibernate5.model;

import javax.persistence.Entity;

@Entity
public class CheuqePayment extends Payment {
	private String ChequeType;

	public String getChequeType() {
		return ChequeType;
	}

	public void setChequeType(String chequeType) {
		ChequeType = chequeType;
	}

}
