package com.naren.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.naren.hibernate.demo.entity.Course;
import com.naren.hibernate.demo.entity.Instructor;
import com.naren.hibernate.demo.entity.InstructorDetails;

public class FetchJoinDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetails.class).addAnnotatedClass(Course.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			System.out.println("Start fetching==============>");

			session.beginTransaction();

			int theId = 1;
			Query<Instructor> query = session.createQuery(
					"select i from Instructor i " + " join fetch i.courses " + " where i.id=:theInstructorId",
					Instructor.class);

			query.setParameter("theInstructorId", theId);
			Instructor tempInstructor = query.getSingleResult();

			System.out.println(" Fetching Instructor ====>" + tempInstructor);
			System.out.println("Before Fetching courses " + tempInstructor.getCourses());

			System.out.println("Closing session...");
			session.close();
			System.out.println("Fetching courses " + tempInstructor.getCourses());
			System.out.println("DOne!!!");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}

	}

}
