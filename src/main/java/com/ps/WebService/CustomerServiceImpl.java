package com.ps.WebService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ps.dao.CustomerDao;
import com.ps.model.Customer;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	CustomerDao customerdao;
	
	
	public void Register(Customer customer) {
		// TODO Auto-generated method stub
		customerdao.RegisterUser(customer);
	}


	@Autowired
	public void setCustomerdao(CustomerDao customerdao) {
		this.customerdao = customerdao;
	}


	@Override
	public Customer getUserinfo(String username) {
		// TODO Auto-generated method stub
		return customerdao.getUserinfo(username);
	}
	
	 @SuppressWarnings("unchecked")
	public List<Customer> getListUser() {
		  return customerdao.getListUser();
		 }

}
