package com.test;

import java.time.LocalDate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test2 {

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
		customer.setName("Pooja");
		customer.setMobileNumber("741258632");
		customer.setAddress("Mumbai");
		Transection transection = new Transection();
		transection.setDate(LocalDate.now());
		transection.setAmount(2000l);
		transection.setCustomer(customer);
		customer.setTransection(transection);
		
		session.save(customer);
		transaction.commit();

	}

}
