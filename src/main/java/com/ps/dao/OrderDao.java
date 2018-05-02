package com.ps.dao;


import java.util.List;


import com.ps.model.OrderModel;

public interface OrderDao {

	public void RegisterOrder(OrderModel orderModel);
	public List<OrderModel> getOrders();
}
