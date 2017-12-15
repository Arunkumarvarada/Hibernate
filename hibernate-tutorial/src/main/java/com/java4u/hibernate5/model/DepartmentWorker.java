package com.java4u.hibernate5.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="DepartmentWorker")
public class DepartmentWorker {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DeptWorker_ID")
	private long id;

	@Column(name = "DeptWorker_NAME", nullable = false)
	private String name;

	@Column(name = "DESIGNATION")
	private String designation;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

}
