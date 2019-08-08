package com.naren.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.naren.hibernate.demo.entity.Student;

public class QueryStudentDemo {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			// Get Single Object
			Student myStudent = session.get(Student.class, 1);
			System.out.println("====mystudent===" + myStudent);

			// Get Multiple object
			session = factory.getCurrentSession();
			session.beginTransaction();

			Query<Student> query = session
					.createQuery("from Student " + "where firstName like 'naren' or lastName like 'kasgar' ");
			List<Student> studentList = query.list();
			System.out.println("Done!!!!" + studentList);

			System.out.println("Update process=========>");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}
	}
}
