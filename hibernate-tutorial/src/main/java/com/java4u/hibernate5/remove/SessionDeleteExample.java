package com.java4u.hibernate5.remove;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.java4u.hibernate5.model.Customer;
import com.java4u.hibernate5.util.HibernateUtilMySql;

public class SessionDeleteExample {

	public static void main(String[] args) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtilMySql.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Customer customer = session.get(Customer.class, 54L);
			if (customer != null) {
				session.delete(customer);
			}
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}
		HibernateUtilMySql.shutdown();
	}

}
