package com.ps.WebService;

import java.util.List;

import org.springframework.stereotype.Repository;


import com.ps.model.CartModel;

@Repository
public interface CartService {

	public void RegisterCart(CartModel cartModel);
	public List<CartModel> getListCart(String username);
	 public void deleteCart(int id);
	 
}
