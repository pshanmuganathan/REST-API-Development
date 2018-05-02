package com.ps.WebService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.ps.dao.OrderDao;
import com.ps.model.OrderModel;

@Service
@Transactional
public class OrderServiceImpl implements OrderService{

	
	OrderDao orderdao;
	@Override
	public void RegisterOrder(OrderModel orderModel) {
		// TODO Auto-generated method stub
		orderdao.RegisterOrder(orderModel);
	}
	

	@Autowired
	public void setOrderdao(OrderDao orderdao) {
		this.orderdao = orderdao;
	}


	@Override
	public List<OrderModel> getListOrders() {
		// TODO Auto-generated method stub
		return orderdao.getOrders();
	}


}
