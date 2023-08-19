package com.velocity.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test2 {

	public static void main(String[] args) {
		//step-1
				Configuration configuration = new Configuration();
				configuration.configure("hibernate.cfg.xml");
				
				// step-2
				SessionFactory sessionfactory= configuration.buildSessionFactory();
				//step-3
				Session session=sessionfactory.openSession();
				//step-4
				Transaction transaction=session.beginTransaction();
				//step-5
				Student student= new Student();
				student.setFirstName("sagar");
				student.setLastName("patil");
				//step-6
				session.save(student);
				transaction.commit();
				session.close();
				System.out.println("Record save successfully....!!!!!!!!!!!!!!!");
		}		

			



	}


