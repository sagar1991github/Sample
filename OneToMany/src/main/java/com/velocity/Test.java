package com.velocity;

import java.time.LocalDate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.test.Customer;
import com.test.Transection;

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
		
		// Object
		Question question = new Question();
		question.setQuestion("What is java?");
		
		Answer ans1 = new Answer();
		ans1.setAns("Its a chat bot");
		ans1.setQuestion(question);
		Answer ans2 = new Answer();
		ans2.setAns("Its a programming");
		ans2.setQuestion(question);
		Answer ans3 = new Answer();
		ans3.setAns("Its a cofee bean");
		ans3.setQuestion(question);
		
		session.save(question);
		session.save(ans1);
		session.save(ans2);
		session.save(ans3);
		transaction.commit();	
	}

}
