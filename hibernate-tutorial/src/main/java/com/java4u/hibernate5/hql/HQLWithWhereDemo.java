package com.java4u.hibernate5.hql;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.java4u.hibernate5.model.Department;
import com.java4u.hibernate5.util.HibernateUtilMySql;

public class HQLWithWhereDemo {

	@SuppressWarnings({ "deprecation", "rawtypes", "unchecked" })
	public static void main(String[] args) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtilMySql.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Query query = session.createQuery("from Department where id=1");
			List<Department> deprtments = query.list();
			System.out.println(deprtments.get(0).getName());
			System.out.println(deprtments.get(0).getId());
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
