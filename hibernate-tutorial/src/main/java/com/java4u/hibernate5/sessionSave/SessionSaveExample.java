package com.java4u.hibernate5.sessionSave;

import org.hibernate.Session;

import com.java4u.hibernate5.model.Customer;
import com.java4u.hibernate5.util.HibernateUtilMySql;

public class SessionSaveExample {

	public static void main(String[] args) {
		Session session = null;
		try {
			Customer customer = new Customer();
			customer.setId(1l);
			customer.setName("Raman");
			session = HibernateUtilMySql.getSessionFactory().openSession();
			session.beginTransaction();
			session.save(customer);
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
