package com.java4u.hibernate5.inheritance;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.java4u.hibernate5.model.Contract_Worker;
import com.java4u.hibernate5.model.Regular_Worker;
import com.java4u.hibernate5.model.Worker;
import com.java4u.hibernate5.util.HibernateUtilMySql;

public class TablePerHierarchyDemo {

	public static void main(String[] args) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtilMySql.getSessionFactory().openSession();
			transaction = session.beginTransaction();

			Worker worker = new Worker();
			worker.setName("Jessy");

			Contract_Worker contract_Worker = new Contract_Worker();
			contract_Worker.setName("Sonoo");
			contract_Worker.setContract_duration("15");
			contract_Worker.setPay_per_hour(1000);

			Regular_Worker regular_Worker = new Regular_Worker();
			contract_Worker.setName("Sonal");
			regular_Worker.setBonus(5000);
			regular_Worker.setSalary(100000);

			session.save(regular_Worker);
			session.save(contract_Worker);
			session.save(worker);
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
