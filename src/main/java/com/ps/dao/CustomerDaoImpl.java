package com.ps.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ps.model.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	protected Session getSession() {
		
		return sessionFactory.getCurrentSession();
	}
	public void RegisterUser(Customer customer) {
		// TODO Auto-generated method stub
		getSession().saveOrUpdate(customer);
	}
	@Override
	public Customer getUserinfo(String username) {
		// TODO Auto-generated method stub
		return (Customer) getSession().get(Customer.class, username);
	}
	 @SuppressWarnings("unchecked")
	 public List<Customer> getListUser() {
	  Criteria criteria = getSession().createCriteria(Customer.class);
	  
	  return (List<Customer>) criteria.list();
	 }
}
