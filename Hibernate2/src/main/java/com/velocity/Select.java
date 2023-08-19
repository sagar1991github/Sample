package com.velocity;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class Select {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		//Select 
		Query query = session.createQuery("from Employee");
		query.setCacheable(true);
		List<Employee> empList= query.list();
		System.out.println(empList);
	
		
		Session session2 = sessionFactory.openSession();
		Query query1 = session2.createQuery("from Employee");
		query1.setCacheable(true);
		List<Employee> empList1= query1.list();
		System.out.println(empList1);
		
		transaction.commit();
		session.close();
		sessionFactory.close();
	}

}
