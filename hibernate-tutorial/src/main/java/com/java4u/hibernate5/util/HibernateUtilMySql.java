package com.java4u.hibernate5.util;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;

import com.java4u.hibernate5.model.Address;
import com.java4u.hibernate5.model.College;
import com.java4u.hibernate5.model.Contract_Worker;
import com.java4u.hibernate5.model.Customer;
import com.java4u.hibernate5.model.Department;
import com.java4u.hibernate5.model.DepartmentWorker;
import com.java4u.hibernate5.model.Employee;
import com.java4u.hibernate5.model.ParkingCompany;
import com.java4u.hibernate5.model.ParkingSite;
import com.java4u.hibernate5.model.ParkingSpace;
import com.java4u.hibernate5.model.ParkingUser;
import com.java4u.hibernate5.model.Product;
import com.java4u.hibernate5.model.Regular_Worker;
import com.java4u.hibernate5.model.Student;
import com.java4u.hibernate5.model.Teachers;
import com.java4u.hibernate5.model.User;
import com.java4u.hibernate5.model.UserDetails;
import com.java4u.hibernate5.model.Vehicle;
import com.java4u.hibernate5.model.Worker;

public class HibernateUtilMySql {
	private static StandardServiceRegistry registry;
	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		if (null == sessionFactory) {
			try {
				StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();

				Map<String, Object> settings = new HashMap<String, Object>();
				settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
				settings.put(Environment.URL,
						"jdbc:mysql://localhost:3306/hibernate5?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
				settings.put(Environment.USER, "root");
				settings.put(Environment.PASS, "root");
				settings.put(Environment.HBM2DDL_AUTO, "update");
				settings.put(Environment.USE_SECOND_LEVEL_CACHE, true);
				settings.put(Environment.USE_QUERY_CACHE, true);
				settings.put(Environment.SHOW_SQL, true);
				settings.put(Environment.CACHE_REGION_FACTORY, "org.hibernate.cache.jcache.JCacheRegionFactory");
				settings.put("hibernate.javax.cache.provider", "org.ehcache.jsr107.EhcacheCachingProvider");

				registryBuilder.applySettings(settings);
				registry = registryBuilder.build();

				MetadataSources sources = new MetadataSources(registry).addAnnotatedClass(Employee.class)
						.addAnnotatedClass(Address.class).addAnnotatedClass(Customer.class)
						.addAnnotatedClass(Product.class).addAnnotatedClass(User.class)
						.addAnnotatedClass(UserDetails.class).addAnnotatedClass(Department.class)
						.addAnnotatedClass(DepartmentWorker.class).addAnnotatedClass(Student.class)
						.addAnnotatedClass(Vehicle.class).addAnnotatedClass(ParkingSpace.class)
						.addAnnotatedClass(ParkingUser.class).addAnnotatedClass(College.class)
						.addAnnotatedClass(Teachers.class).addAnnotatedClass(ParkingCompany.class)
						.addAnnotatedClass(ParkingSite.class).addAnnotatedClass(Worker.class)
						.addAnnotatedClass(Regular_Worker.class).addAnnotatedClass(Contract_Worker.class);

				Metadata metadata = sources.getMetadataBuilder().build();
				sessionFactory = metadata.getSessionFactoryBuilder().build();

			} catch (Exception e) {
				e.printStackTrace();
				if (registry != null) {
					StandardServiceRegistryBuilder.destroy(registry);
				}
			}
		}
		return sessionFactory;
	}

	public static void shutdown() {
		if (registry != null) {
			StandardServiceRegistryBuilder.destroy(registry);
		}
	}
}
