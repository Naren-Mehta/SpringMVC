package com.naren.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.naren.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session= sessionFactory.getCurrentSession();
		
		try {
			System.out.println("Creating new Student....");
			Student s= new Student("Naren","Mehta","naren@gmail.com");
			session.beginTransaction();
			System.out.println("Saving the student........");

			session.save(s);
			session.getTransaction().commit();
			System.out.println("Done!!");
			

			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			sessionFactory.close();
		}
		
	}

}
