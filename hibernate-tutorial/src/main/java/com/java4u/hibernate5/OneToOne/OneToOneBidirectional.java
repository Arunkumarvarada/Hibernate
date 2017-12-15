package com.java4u.hibernate5.OneToOne;

import java.time.LocalDate;
import java.time.Month;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.java4u.hibernate5.model.User;
import com.java4u.hibernate5.model.UserDetails;
import com.java4u.hibernate5.util.HibernateUtilMySql;

public class OneToOneBidirectional {

	public static void main(String[] args) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtilMySql.getSessionFactory().openSession();
			transaction = session.getTransaction();
			transaction.begin();

			User user = new User();
			user.setUsername("USR002");
			user.setPassword("mno@xyz.com");

			UserDetails userDetail = new UserDetails();
			userDetail.setFirstName("Sammer");
			userDetail.setLastName("Dua");
			userDetail.setEmail("sammer.dua@example.com");
			userDetail.setDob(LocalDate.of(1985, Month.APRIL, 1));
			userDetail.setUser(user);

			user.setUserDetails(userDetail);

			session.persist(user);
			transaction.commit();

			System.out.println("User saved successfully");

		} catch (Exception e) {
			if (transaction != null) {
				System.out.println("Transaction is being rolled back.");
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		HibernateUtilMySql.shutdown();

	}

}
