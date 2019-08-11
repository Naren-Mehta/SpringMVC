package com.naren.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.naren.hibernate.demo.entity.Course;
import com.naren.hibernate.demo.entity.Instructor;
import com.naren.hibernate.demo.entity.InstructorDetails;
import com.naren.hibernate.demo.entity.Review;

public class GetCourseAndReviewDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetails.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			System.out.println("Start saving Course==============>");
			session.beginTransaction();
			
			System.out.println("==get Course===>");
			Course myCourse= session.get(Course.class, 1);
			System.out.println(myCourse);
			
			System.out.println("Get the course review===>");
			System.out.println(myCourse.getReviews());
			session.getTransaction().commit();
			System.out.println("Done!!!!");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}

	}

}
