package com.ps.WebService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ps.dao.CarDao;

import com.ps.model.CarModel;


@Service
@Transactional
public class CarServiceImpl implements CarService{

	
	CarDao cardao;
	
	@Override
	public void RegisterCar(CarModel carModel) {
		// TODO Auto-generated method stub
		cardao.RegisterCar(carModel);
	}
	
	@Autowired
	public void setCustomerdao(CarDao cardao) {
		this.cardao = cardao;
	}

	@Override
	public List<CarModel> getListCar() {
		// TODO Auto-generated method stub
		return cardao.getListCar();
	}

	@Override
	public void deleteCar(int id) {
		// TODO Auto-generated method stub
		cardao.deleteCar(id);
	}

	@Override
	public CarModel getCarinfo(int id) {
		// TODO Auto-generated method stub
		return cardao.getCarinfo(id);
	}

}
