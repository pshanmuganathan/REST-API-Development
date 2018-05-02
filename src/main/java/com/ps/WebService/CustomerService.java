package com.ps.WebService;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ps.model.Customer;

@Repository
public interface CustomerService {

	public void Register(Customer customer);
	public Customer getUserinfo(String username);
	
	 public List<Customer> getListUser();
}
