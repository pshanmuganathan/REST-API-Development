package com.ps.dao;


import java.util.List;


import com.ps.model.CartModel;

public interface CartDao {

	public void RegisterCart(CartModel cartModel);
	public List<CartModel> getListCart(String username);
	public void deleteCart(int id);
	
}
