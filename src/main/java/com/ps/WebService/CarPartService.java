package com.ps.WebService;

import java.util.List;

import org.springframework.stereotype.Repository;


import com.ps.model.CarPart;

@Repository
public interface CarPartService {

	public void RegisterCarPart(CarPart carPart);
	 public List<CarPart> getListCarPart();
	 public void deleteCarPart(int id);
	 public CarPart getCarinfo(int id);
}
