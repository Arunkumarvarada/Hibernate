package com.java4u.hibernate5.OneToOne;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.java4u.hibernate5.model.Student;
import com.java4u.hibernate5.model.Vehicle;
import com.java4u.hibernate5.util.HibernateUtilMySql;

public class OneToOneExample {

	public static void main(String[] args) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtilMySql.getSessionFactory().openSession();
			transaction = session.beginTransaction();

			Student student = new Student();
			student.setStudentName("Srini");
			Vehicle vehicle = new Vehicle();
			vehicle.setVehicleName("Car");
			student.setVehicle(vehicle);

			session.save(student);
			session.save(vehicle);
			transaction.commit();
			System.out.println("Student object Inserted");
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
