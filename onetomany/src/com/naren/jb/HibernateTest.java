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
		
		Vehicle v1= new Vehicle("Car");
		Vehicle v2= new Vehicle("Bike");
		Vehicle v3= new Vehicle("Bus");
		user.getVehicles().add(v1);
		user.getVehicles().add(v2);
		user.getVehicles().add(v3);

		v1.setUser(user);
		v2.setUser(user);
		v3.setUser(user);

		SessionFactory factory= new Configuration().configure().buildSessionFactory();
		
		Session session=factory.getCurrentSession();

		try {
			System.out.println("Saving User object");
			session.beginTransaction();
			session.save(user);

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
