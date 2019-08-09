package com.naren.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.naren.hibernate.demo.entity.Instructor;
import com.naren.hibernate.demo.entity.InstructorDetails;

public class CreateDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetails.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			System.out.println("Start saving==============>");
			Instructor tempInstructor = new Instructor("Deepak", "Singh", "deepak@gmail.com");

			InstructorDetails tempInstructorDetails = new InstructorDetails("http://www.singh.com/youtube",
					"Singh Course");
			
			tempInstructor.setInstructorDetails(tempInstructorDetails);
			

			session.beginTransaction();
			System.out.println("Saving Instructor "+tempInstructor);
			session.save(tempInstructor);
			session.getTransaction().commit();
			System.out.println("Done!!!!");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}

	}

}
