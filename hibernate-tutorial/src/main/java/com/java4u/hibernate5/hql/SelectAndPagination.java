package com.java4u.hibernate5.hql;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.java4u.hibernate5.model.DepartmentWorker;
import com.java4u.hibernate5.util.HibernateUtilMySql;

public class SelectAndPagination {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtilMySql.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			List<DepartmentWorker> workers= (List<DepartmentWorker>) session.createQuery("from DepartmentWorker");
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
