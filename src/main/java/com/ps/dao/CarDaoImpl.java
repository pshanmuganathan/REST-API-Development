package com.ps.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ps.model.CarModel;
import com.ps.model.Customer;


@Repository
public class CarDaoImpl implements CarDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	
	protected Session getSession() {
		
		return sessionFactory.getCurrentSession();
	}
	
	
	@Override
	public void RegisterCar(CarModel carModel) {
		// TODO Auto-generated method stub
		
		getSession().saveOrUpdate(carModel);
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<CarModel> getListCar() {
		// TODO Auto-generated method stub
		Criteria criteria = getSession().createCriteria(CarModel.class);
		  
		  return (List<CarModel>) criteria.list();
	}


	@Override
	public void deleteCar(int id) {
		// TODO Auto-generated method stub
		CarModel car = (CarModel) getSession().get(CarModel.class, id);
		  getSession().delete(car);
	}


	@Override
	public CarModel getCarinfo(int id) {
		// TODO Auto-generated method stub
		return (CarModel) getSession().get(CarModel.class, id);
	}

}
