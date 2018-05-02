package com.ps.WebService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.ps.dao.CarPartDao;

import com.ps.model.CarPart;

@Service
@Transactional
public class CarPartServiceImpl implements CarPartService{

	CarPartDao carpartDao;
	
	@Autowired
	public void setCustomerdao(CarPartDao carpartDao) {
		this.carpartDao = carpartDao;
	}

	@Override
	public void RegisterCarPart(CarPart carPart) {
		// TODO Auto-generated method stub
		carpartDao.RegisterCarPart(carPart);
	}

	@Override
	public List<CarPart> getListCarPart() {
		// TODO Auto-generated method stub
		return carpartDao.getListCarPart();
	}

	@Override
	public void deleteCarPart(int id) {
		// TODO Auto-generated method stub
		carpartDao.deleteCarPart(id);
	}

	@Override
	public CarPart getCarinfo(int id) {
		// TODO Auto-generated method stub
		return carpartDao.getCarPartinfo(id);
	}

	
	
}
