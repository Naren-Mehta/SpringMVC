package com.naren.jb;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.naren.jb.dto.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.getCurrentSession();

		try {
			System.out.println("Start Saving User object");
			session.beginTransaction();

//			
//			UserDetails user = new UserDetails();
//			session.save(user);
//			user.setName("Tested Deepak");

			UserDetails userDetails = session.get(UserDetails.class, 1);
//			System.out.println("user====>"+userDetails);

//			userDetails.setName("Test Deepak Updated ??");

			session.delete(userDetails);

			userDetails.setName("new Deepak!!");
			System.out.println("=userDetails==" + userDetails);

			session.getTransaction().commit();
			session.close();

			System.out.println("Saved User object=====> ");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
