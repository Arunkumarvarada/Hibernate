package com.java4u.hibernate5.crud;

import org.hibernate.Session;

import com.java4u.hibernate5.model.Employee;
import com.java4u.hibernate5.util.HibernateUtilMySql;

public class MergeDemo {

	public static void main(String[] args) {
		Session session = HibernateUtilMySql.getSessionFactory().openSession();

		Employee emp = new Employee();
		emp.setEmail("varunkumar.varada@gmail.com");
		emp.setEmpAddress("Bangalore");
		emp.setName("Varun");
		emp.setPhone("7799234445");
		
		// Saving Object using merge() method
		try {
			session.beginTransaction();
			session.merge(emp);
			session.getTransaction().commit();
			System.out.println("Insertion Completed");
		} catch (Exception e) {
			session.getTransaction().rollback();
		}
	}

}
