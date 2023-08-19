package com.velocity;

import java.util.ArrayList;
import java.util.List;

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
		
		List<Answer> options = new ArrayList<>();
		options.add(ans3);
		options.add(ans2);
		options.add(ans1);
		question.setAnswers(options);
		
		session.save(question);
		transaction.commit();	
	

	}

}
