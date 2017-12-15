package com.java4u.hibernate5.OneToMany;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.java4u.hibernate5.model.Department;
import com.java4u.hibernate5.model.DepartmentWorker;
import com.java4u.hibernate5.util.HibernateUtilMySql;

public class OneToManyDemo {

	public static void main(String[] args) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtilMySql.getSessionFactory().openSession();
			transaction = session.getTransaction();
			transaction.begin();

			DepartmentWorker departmentWorker1 = new DepartmentWorker();
			departmentWorker1.setName("Syam");
			departmentWorker1.setDesignation("Manager");

			DepartmentWorker departmentWorker2 = new DepartmentWorker();
			departmentWorker2.setName("Syam");
			departmentWorker2.setDesignation("Manager");

			DepartmentWorker departmentWorker3 = new DepartmentWorker();
			departmentWorker3.setName("Syam");
			departmentWorker3.setDesignation("Manager");

			Department department = new Department();
			department.setName("IT Department");
			department.getWorkers().add(departmentWorker1);
			department.getWorkers().add(departmentWorker2);
			department.getWorkers().add(departmentWorker3);

			session.persist(department);

			transaction.commit();

			System.out.println("Departement saved successfully");

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
