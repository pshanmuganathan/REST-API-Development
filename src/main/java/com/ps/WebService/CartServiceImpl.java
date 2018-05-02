package com.ps.WebService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.ps.dao.CartDao;
import com.ps.model.CartModel;

@Service
@Transactional
public class CartServiceImpl implements CartService{

	
	CartDao cartDao;
	
	@Autowired
	public void setCustomerdao(CartDao cartDao) {
		this.cartDao = cartDao;
	}

	@Override
	public void RegisterCart(CartModel cartModel) {
		// TODO Auto-generated method stub
		cartDao.RegisterCart(cartModel);
	}

	@Override
	public List<CartModel> getListCart(String username) {
		// TODO Auto-generated method stub
		return cartDao.getListCart(username);
	}

	@Override
	public void deleteCart(int id) {
		// TODO Auto-generated method stub
		cartDao.deleteCart(id);
	}

}
