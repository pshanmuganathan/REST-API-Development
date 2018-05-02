package com.ps.WebService;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ps.model.CarModel;
import com.ps.model.Customer;


@Repository
public interface CarService {

	
	public void RegisterCar(CarModel carModel);
	 public List<CarModel> getListCar();
	 public void deleteCar(int id);
		public CarModel getCarinfo(int id);
		
}
