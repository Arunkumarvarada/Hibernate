package com.java4u.hibernate5.configuration;

import org.hibernate.Session;

import com.java4u.hibernate5.util.HibernateUtilMySql;

public class HibernateWithoutConfigFile {
	public static void main(String[] args) {
		Session session = HibernateUtilMySql.getSessionFactory().openSession();
		session.beginTransaction();

		// Check database version
		String sql = "select version()";

		String result = (String) session.createNativeQuery(sql).getSingleResult();
		System.out.println(result);

		session.getTransaction().commit();
		session.close();

		HibernateUtilMySql.shutdown();
	}
}
