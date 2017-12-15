package com.java4u.hibernate5.nativequery;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.java4u.hibernate5.model.Employee;
import com.java4u.hibernate5.util.HibernateUtilMySql;

public class NamedQueryDemo {

	public static void main(String[] args) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtilMySql.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			@SuppressWarnings("rawtypes")
			Query query = session.getNamedQuery("Employee.byid");
			query.setInteger(0, 1);
			List<Employee> employees = query.list();

			transaction.commit();
			session.close();

			for (Employee emp : employees) {
				System.out.println(emp.getName());
			}

		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}

	}

}
