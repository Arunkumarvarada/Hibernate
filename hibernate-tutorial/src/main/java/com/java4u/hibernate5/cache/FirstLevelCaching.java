package com.java4u.hibernate5.cache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.java4u.hibernate5.model.Employee;
import com.java4u.hibernate5.util.HibernateUtilMySql;

public class FirstLevelCaching {

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtilMySql.getSessionFactory();
		Session session = sessionFactory.openSession();
		// session level cache
		session.beginTransaction();
		System.out.println("Start of Demo of First Level Cache");
		Employee employee = session.get(Employee.class, 1);
		Employee employee2 = session.get(Employee.class, 1);
		System.out.println(" End of Demo of First Level Cache");
		session.getTransaction().commit();

		Session session2 = sessionFactory.openSession();
		session2.beginTransaction();
		Employee employee3 = session2.get(Employee.class, 1);
		session2.getTransaction().commit();
		
	}
}
