package com.java4u.hibernate5.sessionFetch;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.java4u.hibernate5.model.Customer;
import com.java4u.hibernate5.util.HibernateUtilMySql;

public class SesionFetchExample {

	public static void main(String[] args) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtilMySql.getSessionFactory().openSession();
			transaction = session.beginTransaction();

			Customer customer1 = session.load(Customer.class, 2L);
			if (customer1 != null) {
				System.out.println(customer1.getName());
			}
			Customer customer2 = session.get(Customer.class, 1L);
			if (customer2 != null) {
				System.out.println(customer2.getName());
			}
			Customer customer3 = session.byId(Customer.class).getReference(3L);
			if (customer3 != null) {
				System.out.println(customer3.getName());
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
