package com.naren.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.naren.hibernate.demo.entity.Course;
import com.naren.hibernate.demo.entity.Instructor;
import com.naren.hibernate.demo.entity.InstructorDetails;

public class EagarLazyDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetails.class).addAnnotatedClass(Course.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			System.out.println("Start fetching==============>");

			session.beginTransaction();
			
			Instructor theInstructor= session.get(Instructor.class, 1);
			System.out.println("Debugg : Fetching Instructor ====>"+theInstructor);
			System.out.println("====get the course now====");
			System.out.println("Get courses=="+theInstructor.getCourses());

			System.out.println("===session close====");
			session.close();
			System.out.println("Get courses again=="+theInstructor.getCourses());
			
			System.out.println("Debugg : Done!!!!");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}

	}

}
