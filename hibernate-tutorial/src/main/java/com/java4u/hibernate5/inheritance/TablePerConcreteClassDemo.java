package com.java4u.hibernate5.inheritance;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.java4u.hibernate5.model.Animal;
import com.java4u.hibernate5.model.PetAnimal;
import com.java4u.hibernate5.model.WildAnimal;
import com.java4u.hibernate5.util.HibernateUtilMySql;

public class TablePerConcreteClassDemo {

	public static void main(String[] args) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtilMySql.getSessionFactory().openSession();
			transaction = session.beginTransaction();

			Animal animal = new Animal();
			animal.setName("Omnivore");

			WildAnimal wildAnimal = new WildAnimal();
			wildAnimal.setName("Tiger Breed");
			wildAnimal.setWildAnimalColor("DARK YELLOW");
			wildAnimal.setWildAnimalName("BENGAL TIGER");

			PetAnimal petAnimal = new PetAnimal();
			petAnimal.setName("Dog Breed");
			petAnimal.setColor("BLACK");
			petAnimal.setPetName("Jessy");

			session.save(animal);
			session.save(petAnimal);
			session.save(wildAnimal);

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
