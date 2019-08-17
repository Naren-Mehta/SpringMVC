package com.naren.jb;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.naren.jb.dto.Address;
import com.naren.jb.dto.UserDetails;

public class HibernateTest {
	
	public static void main(String[] args) {
		
		UserDetails user= new UserDetails();
//		user.setId(1);
		user.setUserName("test");
		
		Address a= new Address();
		a.setStreet("16th main");
		a.setCity("bengalore");
		a.setState("Karnataka");
		a.setCountry("India");
		
		Address a1= new Address();
		a1.setStreet("4A AMR Tech Park");
		a1.setCity("bengalore");
		a1.setState("Karnataka");
		a1.setCountry("India");
		
		user.getListOfAddress().add(a1);
		user.getListOfAddress().add(a);

		SessionFactory factory= new Configuration().configure().buildSessionFactory();
		
		Session session=factory.getCurrentSession();

		try {
			System.out.println("Saving User object");
			session.beginTransaction();
			session.save(user);
			session.getTransaction().commit();
			System.out.println("Saved User object ");

		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
