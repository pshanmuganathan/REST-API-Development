package com.ps.WebService;

import java.util.List;

import org.springframework.stereotype.Repository;


import com.ps.model.OrderModel;

@Repository
public interface OrderService {
	
	public void RegisterOrder(OrderModel orderModel);
	 public List<OrderModel> getListOrders();
}
