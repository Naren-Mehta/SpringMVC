package com.naren.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.naren.hibernate.demo.entity.Course;
import com.naren.hibernate.demo.entity.Instructor;
import com.naren.hibernate.demo.entity.InstructorDetails;

public class CreateCourseDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetails.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			System.out.println("Start saving Course==============>");
			session.beginTransaction();
			int theId = 1;
			Instructor theInstructor = session.get(Instructor.class, theId);

			Course course1 = new Course("Java");
			Course course3 = new Course("Python");
			Course course4 = new Course("Machine Learning");

			theInstructor.add(course1);
			theInstructor.add(course3);
			theInstructor.add(course4);

			session.save(course1);
			session.save(course3);
			session.save(course4);
			session.getTransaction().commit();
			System.out.println("Done!!!!");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}

	}

}
