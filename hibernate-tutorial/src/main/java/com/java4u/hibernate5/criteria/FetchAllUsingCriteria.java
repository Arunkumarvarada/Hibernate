package com.java4u.hibernate5.criteria;

import org.hibernate.query.Query;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.java4u.hibernate5.model.Employee;
import com.java4u.hibernate5.util.HibernateUtilMySql;

public class FetchAllUsingCriteria {

	public static void main(String[] args) {
		Session session = HibernateUtilMySql.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();

		CriteriaBuilder builder = session.getCriteriaBuilder();

		CriteriaQuery<Employee> query = builder.createQuery(Employee.class);

		Root<Employee> root = query.from(Employee.class);

		query.select(root);

		Query<Employee> q = session.createQuery(query);
		List<Employee> employees=q.getResultList();
		
		for(Employee emp: employees) {
			System.out.println(emp);
		}
		session.flush();
		transaction.commit();
		session.close();
	}

}
