package com.java4u.hibernate5.inheritance;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.java4u.hibernate5.model.CheuqePayment;
import com.java4u.hibernate5.model.CreaditCardPayment;
import com.java4u.hibernate5.model.Payment;
import com.java4u.hibernate5.util.HibernateUtilMySql;

public class TablePerSubClassDemo {

	public static void main(String[] args) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtilMySql.getSessionFactory().openSession();
			transaction = session.beginTransaction();

			Payment payment = new Payment();
			payment.setAmount(2200);

			CreaditCardPayment creaditCardPayment = new CreaditCardPayment();
			creaditCardPayment.setAmount(2500);
			creaditCardPayment.setCreditCardType("VISA");

			CheuqePayment checkPayment = new CheuqePayment();
			checkPayment.setAmount(2600);
			checkPayment.setChequeType("ICICI");

			session.save(checkPayment);
			session.save(creaditCardPayment);
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
