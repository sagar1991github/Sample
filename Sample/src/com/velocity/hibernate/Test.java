package com.velocity.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {

	public static void main(String[] args) {
		//Step1
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		
		//Step2
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		
		//Step3
		Session session = sessionFactory.openSession();
		
		//Step4
		Transaction transaction = session.beginTransaction();
		
		//Step5
		Student student = new Student();
		student.setFirstName("Mohan");
		student.setLastName("lal");
		
		//Step6
		session.save(student);
		transaction.commit();
		session.close();
		sessionFactory.close();
		System.out.println("Record added ....");
	}

}
