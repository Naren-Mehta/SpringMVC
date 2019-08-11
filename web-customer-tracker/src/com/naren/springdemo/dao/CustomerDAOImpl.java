package com.naren.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.naren.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements  CustomerDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Transactional
	@Override
	public List<Customer> getCustomers() {
		
		Session session= sessionFactory.getCurrentSession();
		
		Query<Customer> query=session.createQuery("from Customer");
		List<Customer> customerList= query.list();
		
		
		return customerList;
	}

}
