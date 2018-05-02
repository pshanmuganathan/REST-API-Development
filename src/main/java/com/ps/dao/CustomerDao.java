package com.ps.dao;

import java.util.List;

import com.ps.model.Customer;

public interface CustomerDao {

	
	public void RegisterUser(Customer customer);
	 public Customer getUserinfo(String username);
	 
	 public List<Customer> getListUser();
}
