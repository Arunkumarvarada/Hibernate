package com.java4u.hibernate5.nativequery;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.java4u.hibernate5.model.Employee;
import com.java4u.hibernate5.util.HibernateUtilMySql;

@SuppressWarnings("deprecation")
public class NamedNativeQueryDemo {

	public static void main(String[] args) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtilMySql.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			@SuppressWarnings("rawtypes")
			Query query = session.getNamedQuery("Employee.byName");
			query.setString(0, "Arun");
			List<Employee> employees = query.list();

			transaction.commit();
			session.close();

			for (Employee emp : employees) {
				System.out.println(emp.getName());
				System.out.println(emp.getEmail());
				
			}

		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}

	}

}
