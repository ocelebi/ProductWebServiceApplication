package com.ocelebi.service.products.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;

@Entity
public class Product {

	@Id
	private String productCode;
	private String productName;
	private String manufacturer;
	private String cost;
	private Date productionDate;
	private Date expireDate;
	private String productDetail;
	
	public Product() {
	}

	public Product(String productCode, String productName, String manufacturer,
			String cost, Date productionDate, Date expireDate,
			String productDetail, int stock) {
		super();
		this.productCode = productCode;
		this.productName = productName;
		this.manufacturer = manufacturer;
		this.cost = cost;
		this.productionDate = productionDate;
		this.expireDate = expireDate;
		this.productDetail = productDetail;
		}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}

	public Date getProductionDate() {
		return productionDate;
	}

	public void setProductionDate(Date productionDate) {
		this.productionDate = productionDate;
	}

	public Date getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}

	public String getProductDetail() {
		return productDetail;
	}

	public void setProductDetail(String productDetail) {
		this.productDetail = productDetail;
	}

	@Override
	public String toString() {
		return "Product [productCode=" + productCode + ", productName="
				+ productName + ", manufacturer=" + manufacturer + ", cost="
				+ cost + ", productionDate=" + productionDate + ", expireDate="
				+ expireDate + ", productDetail=" + productDetail + "]";
	}
}
