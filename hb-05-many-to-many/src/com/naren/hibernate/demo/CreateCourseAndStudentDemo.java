package com.naren.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.naren.hibernate.demo.entity.Course;
import com.naren.hibernate.demo.entity.Instructor;
import com.naren.hibernate.demo.entity.InstructorDetails;
import com.naren.hibernate.demo.entity.Review;
import com.naren.hibernate.demo.entity.Student;

public class CreateCourseAndStudentDemo {

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
			
			Course tempCourse= new Course("Pacman - How to Score one millon points");
			session.save(tempCourse);
			System.out.println("Course Saved: "+tempCourse);
			
			Student student1= new Student("John","Cena","john.cina@gmail.com");
			Student student2= new Student("Triple","H","triple.h@gmail.com");
			Student student3= new Student("Under","taker","under.taker@gmail.com");

			tempCourse.addStudent(student1);
			tempCourse.addStudent(student2);
			tempCourse.addStudent(student3);
			
			System.out.println("Saving students...");
			session.save(student1);
			session.save(student2);
			session.save(student3);
			
			System.out.println("Get Course Students===>"+tempCourse.getStudents());
			
			session.getTransaction().commit();
			System.out.println("Done!!!!");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}

	}

}
