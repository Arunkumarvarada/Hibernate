package com.java4u.hibernate5.sessionSave;

import org.hibernate.Session;

import com.java4u.hibernate5.model.Customer;
import com.java4u.hibernate5.util.HibernateUtilMySql;

public class SessionSaveUpdateExample {

	public static void main(String[] args) {
		Session session = null;
		try {
			Customer customer = new Customer();
			customer.setId(3l);
			customer.setName("Varun");
			session = HibernateUtilMySql.getSessionFactory().openSession();
			session.beginTransaction();
			session.saveOrUpdate(customer);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		HibernateUtilMySql.shutdown();

	}

}
