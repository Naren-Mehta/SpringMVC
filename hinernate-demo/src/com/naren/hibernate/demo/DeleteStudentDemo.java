package com.naren.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.naren.hibernate.demo.entity.Student;

public class DeleteStudentDemo {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			// delete a perticular record after getting object
			System.out.println("1st way to Delete Process");
			session.beginTransaction();
			session = factory.getCurrentSession();
			Student myStudent = session.get(Student.class, 1);
			session.delete(myStudent);
			session.getTransaction().commit();
			System.out.println("Deleted Student with id 1");

			// delete directly to DB level or multiple records
			System.out.println("2nd Way to delete records...");
			session = factory.getCurrentSession();
			session.beginTransaction();
			session.createQuery("delete from Student where id=7").executeUpdate();
			session.getTransaction().commit();
			System.out.println("Deleted Student with id 7");

			System.out.println("Delete process completed=========>");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}
	}
}
