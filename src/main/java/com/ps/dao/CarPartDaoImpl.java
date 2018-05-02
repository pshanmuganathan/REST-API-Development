package com.ps.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ps.model.CarModel;
import com.ps.model.CarPart;


@Repository
public class CarPartDaoImpl implements CarPartDao {
	
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	protected Session getSession() {
		
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void RegisterCarPart(CarPart carPart) {
		// TODO Auto-generated method stub
		getSession().saveOrUpdate(carPart);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CarPart> getListCarPart() {
		// TODO Auto-generated method stub
		Criteria criteria = getSession().createCriteria(CarPart.class);
		  
		  return (List<CarPart>) criteria.list();
	}

	@Override
	public void deleteCarPart(int id) {
		// TODO Auto-generated method stub
		CarPart carpart = (CarPart) getSession().get(CarPart.class, id);
		  getSession().delete(carpart);
	}

	@Override
	public CarPart getCarPartinfo(int id) {
		// TODO Auto-generated method stub
		return (CarPart) getSession().get(CarPart.class, id);
	}

}
