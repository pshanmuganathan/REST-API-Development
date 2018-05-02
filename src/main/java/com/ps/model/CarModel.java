package com.ps.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="carDetails")
public class CarModel {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int carID;
	@Column(name="modelName")
	private String modelName;
	@Column(name="color")
	private String color;
	@Column(name="yearofmfg")
	private String yearofmfg;
	@Column(name="price")
	private String price;
	@Column(name="cartype")
	private String cartype;
	@Column(name="seller")
	private String seller;
	public int getCarID() {
		return carID;
	}
	public void setCarID(int carID) {
		this.carID = carID;
	}
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getYearofmfg() {
		return yearofmfg;
	}
	public void setYearofmfg(String yearofmfg) {
		this.yearofmfg = yearofmfg;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getCartype() {
		return cartype;
	}
	public void setCartype(String cartype) {
		this.cartype = cartype;
	}
	public String getSeller() {
		return seller;
	}
	public void setSeller(String seller) {
		this.seller = seller;
	}

	
}
