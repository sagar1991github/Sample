package com.velocity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Update {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		//First level cache
//		Employee employee = session.get(Employee.class,1);
//		System.out.println(employee);
//		Employee employee2 = session.get(Employee.class,1);
//		System.out.println(employee2);
//		Employee employee3 = session.get(Employee.class,3);
//		System.out.println(employee3);
		
		//Second level cache
		Employee employee = session.get(Employee.class,1);
		System.out.println(employee);
		
		Session session2 = sessionFactory.openSession();
		Employee employee1 = session2.get(Employee.class,1);
		System.out.println(employee1);
		
		
		transaction.commit();
		session.close();
		sessionFactory.close();
		System.out.println("Record is updated...");

	}

}
