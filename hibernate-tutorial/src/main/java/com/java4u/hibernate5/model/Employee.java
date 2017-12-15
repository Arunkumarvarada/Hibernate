package com.java4u.hibernate5.model;

import java.io.Serializable;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@Entity
@NamedQuery(name = "Employee.byid", query = "from Employee where id=?")
@NamedNativeQuery(name = "Employee.byName", query = "select * from Employee where emp_name=?", resultClass = Employee.class)
@Table(name = "EMPLOYEE")
public class Employee implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;

	@Column(name = "emp_name")
	private String name;

	@Column(name = "emp_Address")
	private String empAddress;

	@Column(name = "phone")
	private String phone;

	@Column(name = "email_ID")
	private String email;

	public Employee() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmpAddress() {
		return empAddress;
	}

	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", empAddress=" + empAddress + ", phone=" + phone + ", email="
				+ email + "]";
	}

}
