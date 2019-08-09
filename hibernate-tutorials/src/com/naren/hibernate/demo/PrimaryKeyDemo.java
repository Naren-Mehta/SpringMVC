package com.naren.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.naren.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		
		// create session factory
				SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
						.addAnnotatedClass(Student.class)
						.buildSessionFactory();

				// create session
				Session session= sessionFactory.getCurrentSession();
				
				try {
					System.out.println("Creating 3 new Student....");
					Student s1= new Student("Naren1","Mehta","naren1@gmail.com");
					Student s2= new Student("Naren2","Mehta","naren2@gmail.com");
					Student s3= new Student("Naren3","Mehta","naren3@gmail.com");

					session.beginTransaction();
					System.out.println("Saving the student........");

					session.save(s1);
					session.getTransaction().commit();
					System.out.println("Done!!");
					

					
				}catch (Exception e) {
					e.printStackTrace();
				}finally {
					sessionFactory.close();
				}
	}

}
