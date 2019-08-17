package com.naren.jb;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.naren.jb.dto.Address;
import com.naren.jb.dto.UserDetails;
import com.naren.jb.dto.Vehicle;

public class HibernateTest {
	
	public static void main(String[] args) {
		
		UserDetails user= new UserDetails("Narendra");
		
		Vehicle v= new Vehicle("Car");
		user.setVehicle(v);
		

		SessionFactory factory= new Configuration().configure().buildSessionFactory();
		
		Session session=factory.getCurrentSession();

		try {
			System.out.println("Saving User object");
			session.beginTransaction();
			session.save(user);
			session.save(v);

			session.getTransaction().commit();
			System.out.println("Saved User object ");

		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
