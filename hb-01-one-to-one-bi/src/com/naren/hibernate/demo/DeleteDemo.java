package com.naren.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.naren.hibernate.demo.entity.Instructor;
import com.naren.hibernate.demo.entity.InstructorDetails;

public class DeleteDemo {
	
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetails.class).buildSessionFactory();

		Session session = factory.getCurrentSession();
		
		
		try {
			session.beginTransaction();
			int theId=1;
			Instructor theInstructor= session.get(Instructor.class, theId);
			
			System.out.println("Found theInstructor ?? "+theInstructor);
			
			if(theInstructor!=null) {
				System.out.println("theInstructor deleting process is ready");
				session.delete(theInstructor);
				session.getTransaction().commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
