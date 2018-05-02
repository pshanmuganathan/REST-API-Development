package com.ps.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="carParts")
public class CarPart {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int carID;
	@Column(name="partName")
	private String partName;
	@Column(name="partType")
	private String partType;
	@Column(name="yearofmfg")
	private String yearofmfg;
	@Column(name="price")
	private String price;
	@Column(name="partStatus")
	private String partStatus;
	public int getCarID() {
		return carID;
	}
	public void setCarID(int carID) {
		this.carID = carID;
	}
	public String getPartName() {
		return partName;
	}
	public void setPartName(String partName) {
		this.partName = partName;
	}
	public String getPartType() {
		return partType;
	}
	public void setPartType(String partType) {
		this.partType = partType;
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
	public String getPartStatus() {
		return partStatus;
	}
	public void setPartStatus(String partStatus) {
		this.partStatus = partStatus;
	}
}
