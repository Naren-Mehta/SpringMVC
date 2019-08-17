package com.naren.jb;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.naren.jb.dto.Address;
import com.naren.jb.dto.UserDetails;
import com.naren.jb.dto.Vehicle;

public class HibernateTest {
	
	public static void main(String[] args) {
		
		UserDetails user1= new UserDetails("Narendra");

		Vehicle v1= new Vehicle("Car");
		Vehicle v2= new Vehicle("Bike");
		Vehicle v3= new Vehicle("Bus");
		
		user1.getVehicles().add(v1);
		user1.getVehicles().add(v2);
		user1.getVehicles().add(v3);
		
		v1.getUserList().add(user1);
		v2.getUserList().add(user1);
		v3.getUserList().add(user1);
		
		SessionFactory factory= new Configuration().configure().buildSessionFactory();
		
		Session session=factory.getCurrentSession();

		try {
			System.out.println("Saving User object");
			session.beginTransaction();
			session.save(user1);

			session.save(v1);
			session.save(v2);
			session.save(v3);


			session.getTransaction().commit();
			System.out.println("Saved User object ");

		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
