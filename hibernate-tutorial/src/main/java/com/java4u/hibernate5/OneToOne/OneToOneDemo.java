package com.java4u.hibernate5.OneToOne;

import java.time.LocalDate;
import java.time.Month;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.java4u.hibernate5.model.User;
import com.java4u.hibernate5.model.UserDetails;
import com.java4u.hibernate5.util.HibernateUtilMySql;

public class OneToOneDemo {

	public static void main(String[] args) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtilMySql.getSessionFactory().openSession();
			transaction = session.beginTransaction();

			UserDetails userDetails = new UserDetails();
			userDetails.setFirstName("Rahul1");
			userDetails.setLastName("Gandhi1");
			userDetails.setEmail("rahul1@congress.com");
			userDetails.setDob(LocalDate.of(1970, Month.MAY, 1));

			User user = new User();
			user.setPassword("@hjlandd");
			user.setUsername("rahul.gandhi1");
			user.setUserDetails(userDetails);
			session.save(user);
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
