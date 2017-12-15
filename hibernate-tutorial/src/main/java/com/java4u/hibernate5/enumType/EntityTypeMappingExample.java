package com.java4u.hibernate5.enumType;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.java4u.hibernate5.model.Address;
import com.java4u.hibernate5.model.AddressType;
import com.java4u.hibernate5.model.Phone;
import com.java4u.hibernate5.util.HibernateUtilMySql;

public class EntityTypeMappingExample {

	public static void main(String[] args) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtilMySql.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Address address = new Address();
			address.setId(1L);
			address.setCity("Bangalore");
			address.setState("Karnataka");
			address.setAddressType(AddressType.COMMUNICATION);
			address.setPhone(Phone.LANDLINE);
			session.save(address);
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
