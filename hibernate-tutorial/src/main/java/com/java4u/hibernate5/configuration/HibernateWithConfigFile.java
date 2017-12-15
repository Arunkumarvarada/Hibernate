package com.java4u.hibernate5.configuration;

import org.hibernate.Session;

import com.java4u.hibernate5.util.HibernateUtil;

/**
 * @author dev
 */
public class HibernateWithConfigFile {
  public static void main(String[] args) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();

    // Check database version
    String sql = "select version()";

    String result = (String) session.createNativeQuery(sql).getSingleResult();
    System.out.println(result);

    session.getTransaction().commit();
    session.close();

    
    HibernateUtil.shutdown();
  }
}
