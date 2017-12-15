package com.java4u.hibernate5.cache;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.java4u.hibernate5.model.Employee;
import com.java4u.hibernate5.util.HibernateUtilMySql;

public class QueryCaching {

	public static void main(String[] args) {
		Session session = null;
		Transaction transaction = null;

		session = HibernateUtilMySql.getSessionFactory().openSession();
		transaction = session.getTransaction();
		transaction.begin();
		@SuppressWarnings("unchecked")
		List<Employee> employees = session.createQuery("from Employee").setCacheable(true)
				.setCacheRegion("employee.cache").list();
		for (Employee employee : employees) {
			System.out.println("\tEmployee Name : " + employee.getName());
		}
		transaction.commit();
		session.close();

		/// Get employee list from Cached result
		session = HibernateUtilMySql.getSessionFactory().openSession();
		transaction = session.getTransaction();
		transaction.begin();
		@SuppressWarnings("unchecked")
		List<Employee> employees2 = session.createQuery("from Employee").setCacheable(true)
				.setCacheRegion("employee.cache").list();
		for (Employee employee : employees2) {
			System.out.println("\tEmployee Name : " + employee.getName());
		}
		transaction.commit();
		session.close();

	}

}
