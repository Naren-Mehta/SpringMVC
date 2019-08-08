package com.naren.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.naren.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		
		
		SessionFactory factory= new Configuration()
				.configure().addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session=factory.getCurrentSession();
				
		try {
			System.out.println("Start saving==============>");
			Student s= new Student("Naren", "Singh", "naren@gmail.com");
			session.beginTransaction();
			session.save(s);
			session.getTransaction().commit();
			System.out.println("Done!!!!");
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			factory.close();
		}
		
	}

}
