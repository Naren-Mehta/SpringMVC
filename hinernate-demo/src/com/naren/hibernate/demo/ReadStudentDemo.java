package com.naren.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.naren.hibernate.demo.entity.Student;

public class ReadStudentDemo {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			System.out.println("Start saving==============>");
			Student tempStudent = new Student("Harish", "Ka", "harish@gmail.com");

			session.beginTransaction();
			session.save(tempStudent);
			session.getTransaction().commit();
			
			System.out.println("User Saved successfully.."+tempStudent.getId());
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			Student myStudent=session.get(Student.class, tempStudent.getId());
			
			System.out.println(myStudent);
			
			System.out.println("Done!!!!");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}
	}
}
