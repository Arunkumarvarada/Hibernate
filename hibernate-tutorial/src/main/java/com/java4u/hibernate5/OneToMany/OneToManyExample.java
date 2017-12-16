package com.java4u.hibernate5.OneToMany;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.java4u.hibernate5.model.ParkingSpace;
import com.java4u.hibernate5.model.ParkingUser;
import com.java4u.hibernate5.util.HibernateUtilMySql;

public class OneToManyExample {

	public static void main(String[] args) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtilMySql.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			ParkingSpace parkingSpace = new ParkingSpace();
			parkingSpace.setParkingSpaceName("PVR");

			ParkingUser parkingUser = new ParkingUser();
			parkingUser.setName("Syam");

			ParkingUser parkingUser2 = new ParkingUser();
			parkingUser2.setName("Suman");

			parkingSpace.getParkingUser().add(parkingUser);
			parkingSpace.getParkingUser().add(parkingUser2);

			parkingUser.setParkingSpace(parkingSpace);
			parkingUser2.setParkingSpace(parkingSpace);

			session.save(parkingSpace);
			session.save(parkingUser);
			session.save(parkingUser2);
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
