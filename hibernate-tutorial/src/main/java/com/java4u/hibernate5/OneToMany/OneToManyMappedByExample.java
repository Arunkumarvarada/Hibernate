package com.java4u.hibernate5.OneToMany;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.java4u.hibernate5.model.College;
import com.java4u.hibernate5.model.Teachers;
import com.java4u.hibernate5.util.HibernateUtilMySql;

public class OneToManyMappedByExample {

	public static void main(String[] args) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtilMySql.getSessionFactory().openSession();
			transaction = session.beginTransaction();

			College college = new College();
			college.setCollegeName("RVCE");

			Teachers teacher = new Teachers();
			teacher.setTeacherName("Ram");

			Teachers teacher1 = new Teachers();
			teacher1.setTeacherName("Mohan");

			college.getTeachers().add(teacher);
			college.getTeachers().add(teacher1);
			teacher.setCollege(college);
			teacher1.setCollege(college);

			session.save(teacher);
			session.save(teacher1);
			session.save(college);
			
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}
		HibernateUtilMySql.shutdown();

	}

}
