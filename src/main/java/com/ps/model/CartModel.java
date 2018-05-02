package com.ps.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cartDetails")
public class CartModel {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int cartID;
	@Column(name="customerName")
	private String customerName;
	@Column(name="modelName")
	private String modelName;
	@Column(name="yearofmfg")
	private String yearofmfg;
	@Column(name="price")
	private String price;

	public int getCartID() {
		return cartID;
	}

	public void setCartID(int cartID) {
		this.cartID = cartID;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
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

	public String getSeller() {
		return seller;
	}

	public void setSeller(String seller) {
		this.seller = seller;
	}

	@Column(name="seller")
	private String seller;
}
