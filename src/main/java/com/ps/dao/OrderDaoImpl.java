package com.ps.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.ps.model.OrderModel;

@Repository
public class OrderDaoImpl implements OrderDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	
	protected Session getSession() {
		
		return sessionFactory.getCurrentSession();
	}
	
	
	
	@Override
	public void RegisterOrder(OrderModel orderModel) {
		// TODO Auto-generated method stub
		getSession().save(orderModel);
	}



	@SuppressWarnings("unchecked")
	@Override
	public List<OrderModel> getOrders() {
		// TODO Auto-generated method stub
		Criteria criteria = getSession().createCriteria(OrderModel.class);
		  
		  return (List<OrderModel>) criteria.list();
	}

}
