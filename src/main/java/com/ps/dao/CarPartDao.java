package com.ps.dao;

import java.util.List;


import com.ps.model.CarPart;

public interface CarPartDao {
	
	public void RegisterCarPart(CarPart carPart);
	public List<CarPart> getListCarPart();
	public void deleteCarPart(int id);
	public CarPart getCarPartinfo(int id);

}
