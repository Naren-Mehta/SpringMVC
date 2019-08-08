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
			Student s1= new Student("Deepak", "Kasgar", "deepak@gmail.com");
			Student s2= new Student("Prema", "H", "prema@gmail.com");
			Student s3= new Student("Hemanth", "Pant", "hemanth@gmail.com");
			Student s4= new Student("Krish", "Tiwari", "krish@gmail.com");


			session.beginTransaction();
			session.save(s1);
			session.save(s2);
			session.save(s3);
			session.save(s4);
			session.getTransaction().commit();
			System.out.println("Done!!!!");
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			factory.close();
		}
		
	}

}
