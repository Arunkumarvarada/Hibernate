package com.java4u.hibernate5.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.java4u.hibernate5.model.Employee;
import com.java4u.hibernate5.util.HibernateUtilMySql;

public class SaveDemo {

	public static void main(String[] args) {
		Session session = HibernateUtilMySql.getSessionFactory().openSession();

		Employee emp = new Employee();
		emp.setEmail("arunkumar.varada@gmail.com");
		emp.setEmpAddress("Bangalore");
		emp.setName("Arun");
		emp.setPhone("9999234445");
		
		// Saving Object using save() method
		try {
			session.beginTransaction();
			session.save(emp);
			session.flush();
			session.getTransaction().commit();
			session.close();

		} catch (Exception e) {
			session.getTransaction().rollback();
		}
	}

}
