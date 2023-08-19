package com.velocity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Insert {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		//Insert the data
		Employee emp1 = new Employee();
		emp1.setFullName("Vishnu Priya");
		emp1.setCity("Nashik");
		emp1.setAge(26);
		emp1.setSalary(12000);
		
		Employee emp2 = new Employee();
		emp2.setFullName("Vindo Patil");
		emp2.setCity("Pune");
		emp2.setAge(25);
		emp2.setSalary(13300);
		
		Employee emp3 = new Employee();
		emp3.setFullName("Kailash Shinde");
		emp3.setCity("Mumbai");
		emp3.setAge(28);
		emp3.setSalary(14000);
		
		session.save(emp1);
		session.save(emp2);
		session.save(emp3);
		transaction.commit();
		session.close();
		sessionFactory.close();
		System.out.println("All records added!...");

	}

}
