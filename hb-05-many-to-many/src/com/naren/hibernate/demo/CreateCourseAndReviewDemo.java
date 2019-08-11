package com.naren.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.naren.hibernate.demo.entity.Course;
import com.naren.hibernate.demo.entity.Instructor;
import com.naren.hibernate.demo.entity.InstructorDetails;
import com.naren.hibernate.demo.entity.Review;

public class CreateCourseAndReviewDemo {

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
			
			Course tempCourse= new Course("Pacman - How to Score one millon points");
			
			tempCourse.add(new Review("Great course! well done"));
			tempCourse.add(new Review("Awesome, keep it up"));
			tempCourse.add(new Review("good course for beginner to advance"));
			
			System.out.println("Course : "+tempCourse);
			System.out.println("reviews : "+tempCourse.getReviews());

			session.save(tempCourse);
			
			session.getTransaction().commit();
			System.out.println("Done!!!!");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}

	}

}
