package com.naren.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.naren.hibernate.demo.entity.Student;

public class UpdateStudentDemo {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			System.out.println("Start getting==============>");

			// update a perticular record
			session.beginTransaction();
			session = factory.getCurrentSession();
			Student myStudent = session.get(Student.class, 1);
			myStudent.setFirstName("Test");
			session.getTransaction().commit();

			// Update all the Records
			session = factory.getCurrentSession();
			session.beginTransaction();
			session.createQuery("update Student set email='nonu@gmail.com' where id=7").executeUpdate();
			session.getTransaction().commit();

			System.out.println("Update process=========>");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}
	}
}
