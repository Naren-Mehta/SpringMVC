package com.naren.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.naren.hibernate.demo.entity.Instructor;
import com.naren.hibernate.demo.entity.InstructorDetails;

public class DeleteInstructorDetailDemo2 {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetails.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();

			int theId = 3;
			System.out.println("Delete InstructorDetails with id " + theId);
			InstructorDetails theInstructorDetails = session.get(InstructorDetails.class, theId);
			
			theInstructorDetails.getInstructor().setInstructorDetails(null);
			session.delete(theInstructorDetails);
			session.getTransaction().commit();
			System.out.println("Delete Successfully Done!");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			factory.close();
		}

	}

}
