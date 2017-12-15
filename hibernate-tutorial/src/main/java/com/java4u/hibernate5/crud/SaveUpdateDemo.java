package com.java4u.hibernate5.crud;

import org.hibernate.Session;

import com.java4u.hibernate5.model.Employee;
import com.java4u.hibernate5.util.HibernateUtilMySql;

public class SaveUpdateDemo {

	public static void main(String[] args) {
		Session session = HibernateUtilMySql.getSessionFactory().openSession();

		Employee emp = new Employee();
		emp.setEmail("tarunkumar.varada@gmail.com");
		emp.setEmpAddress("Bangalore");
		emp.setName("Tarun");
		emp.setPhone("8899934445");
		
		// Saving Object using saveOrUpdate() method
		try {
			session.beginTransaction();
			session.saveOrUpdate(emp);
			session.getTransaction().commit();
			System.out.println("Insertion Completed");
		} catch (Exception e) {
			session.getTransaction().rollback();
		}

	}

}
