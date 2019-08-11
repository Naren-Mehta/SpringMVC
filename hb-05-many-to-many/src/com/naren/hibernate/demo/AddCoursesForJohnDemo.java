package com.naren.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.naren.hibernate.demo.entity.Course;
import com.naren.hibernate.demo.entity.Instructor;
import com.naren.hibernate.demo.entity.InstructorDetails;
import com.naren.hibernate.demo.entity.Review;
import com.naren.hibernate.demo.entity.Student;

public class AddCoursesForJohnDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetails.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			System.out.println("Start saving Course==============>");
			session.beginTransaction();
			
			//Get John from DB
			
			Student johnStudent= session.get(Student.class, 1);
			System.out.println("Fetch John Student "+johnStudent);
			System.out.println("John Courses "+johnStudent.getCourses());
			
			Course newCourse1= new Course("Rubik's Qube : How to speed cube");
			Course newCourse2= new Course("Atari 2600 - Game Development");

			System.out.println("Add john student to courses");
			newCourse1.addStudent(johnStudent);
			newCourse2.addStudent(johnStudent);

			System.out.println("Save courses ");
			session.save(newCourse1);
			session.save(newCourse2);

			
			session.getTransaction().commit();
			System.out.println("Done!!!!");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}

	}

}
