package com.java4u.hibernate5.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.java4u.hibernate5.model.Employee;
import com.java4u.hibernate5.util.HibernateUtilMySql;

public class GetDemo {

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtilMySql.getSessionFactory();
		Session session = sessionFactory.openSession();

		Employee emp = (Employee) session.get(Employee.class, new Integer(1));
		System.out.println(emp);

		session.flush();
		session.close();

	}

}
