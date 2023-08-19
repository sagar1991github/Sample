package com.test;

import java.time.LocalDate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {

	public static void main(String[] args) {
		// Step1
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");

		// Step2
		SessionFactory sessionFactory = configuration.buildSessionFactory();

		// Step3
		Session session = sessionFactory.openSession();

		// Step4
		Transaction transaction = session.beginTransaction();
		
		Customer customer = new Customer();
		customer.setName("vinod");
		customer.setMobileNumber("741258632");
		customer.setAddress("Pune");
		Transection transection = new Transection();
		transection.setDate(LocalDate.now());
		transection.setAmount(4000l);
		customer.setTransection(transection);
		
		Customer customer2 = new Customer();
		customer2.setName("vinod");
		customer2.setMobileNumber("741258632");
		customer2.setAddress("Pune");
		customer2.setTransection(null);
		
		
		session.save(customer);
		session.save(customer2);
		transaction.commit();

	}

}
