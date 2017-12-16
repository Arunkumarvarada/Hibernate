package com.java4u.hibernate5.ManyToMany;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.java4u.hibernate5.model.ParkingCompany;
import com.java4u.hibernate5.model.ParkingSite;
import com.java4u.hibernate5.util.HibernateUtilMySql;

public class ManyToManyDemo {

	public static void main(String[] args) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtilMySql.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			ParkingCompany parkingCompany = new ParkingCompany();
			parkingCompany.setParkingCompanyName("Nagra");

			ParkingCompany parkingCompany1 = new ParkingCompany();
			parkingCompany1.setParkingCompanyName("Viscent");

			ParkingSite parkingSite = new ParkingSite();
			parkingSite.setParkingSiteName("Pheonix");

			ParkingSite parkingSite2 = new ParkingSite();
			parkingSite2.setParkingSiteName("Orion");

			parkingCompany.getSites().add(parkingSite);
			parkingCompany.getSites().add(parkingSite2);

			parkingSite.getParkingCompanies().add(parkingCompany);
			parkingSite.getParkingCompanies().add(parkingCompany1);

			parkingSite2.getParkingCompanies().add(parkingCompany);
			parkingSite2.getParkingCompanies().add(parkingCompany1);

			session.save(parkingSite2);
			session.save(parkingSite);
			session.save(parkingCompany1);
			session.save(parkingCompany);

			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
				System.out.println("The Trasaction is rolled back !!");
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
