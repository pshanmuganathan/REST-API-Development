package com.ps.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ps.model.CarModel;
import com.ps.model.CartModel;

@Repository
public class CartDaoImpl implements CartDao{

	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	protected Session getSession() {
		
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void RegisterCart(CartModel cartModel) {
		// TODO Auto-generated method stub
		getSession().saveOrUpdate(cartModel);
	}

	@Override
	public List<CartModel> getListCart(String username) {
		// TODO Auto-generated method stub
		Criteria cr = getSession().createCriteria(CartModel.class);
		cr.add(Restrictions.like("customerName", username));
		@SuppressWarnings("unchecked")
		List<CartModel> results = (List<CartModel>)cr.list();
		return results;
	}

	@Override
	public void deleteCart(int id) {
		// TODO Auto-generated method stub
		CartModel cart = (CartModel) getSession().get(CartModel.class, id);
		  getSession().delete(cart);
	}


}
