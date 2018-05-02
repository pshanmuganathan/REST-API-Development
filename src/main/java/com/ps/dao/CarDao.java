package com.ps.dao;

import java.util.List;

import com.ps.model.CarModel;
import com.ps.model.Customer;



public interface CarDao {

	public void RegisterCar(CarModel carModel);
	public List<CarModel> getListCar();
	public void deleteCar(int id);
	public CarModel getCarinfo(int id);
}

