package com.naren.jb;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.naren.jb.dto.FourVehicle;
import com.naren.jb.dto.TwoVehicle;
import com.naren.jb.dto.UserDetails;
import com.naren.jb.dto.Vehicle;

public class HibernateTest {

	public static void main(String[] args) {

		Vehicle v = new Vehicle("Car");

		FourVehicle ford = new FourVehicle("Ford Stearing");
		ford.setVehicleName("Ford GO");
		TwoVehicle apache = new TwoVehicle("Apache Handle");
		apache.setVehicleName("TVS Apache RTR");

		SessionFactory factory = new Configuration().configure().buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			System.out.println("Saving User object");
			session.beginTransaction();
			
			session.save(v);
			session.save(ford);
			session.save(apache);
			session.getTransaction().commit();
			System.out.println("Saved User object ");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
