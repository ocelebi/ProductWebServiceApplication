package com.ocelebi.service.products.controller;

import java.util.List;

import com.ocelebi.service.products.dao.DAO;
import com.ocelebi.service.products.model.Product;

public class DAOController {

	private DAO dao;

	public DAOController(DAO dao) {
		this.dao = dao;
	}

	public DAO getDao() {
		return dao;
	}

	public void setDao(DAO dao) {
		this.dao = dao;
	}

	/**
	 * Get Product object via DAO
	 * 
	 * @param id
	 * @return Product
	 */
	public Product getProduct(String productCode) {
		System.out.println(" DAOController:getProduct");
		return dao.getProduct(productCode);
	}

	/**
	 * Get all Product objects via DAO
	 * 
	 * @return List of Product objects
	 */
	public List<Product> getProductList() {
		System.out.println(" DAOController:getProductList");
		return dao.getProductList();
	}

	/**
	 * Add a Product object via DAO
	 * 
	 * @param product
	 * @return primary key of added Product
	 */
	public Product addProduct(Product product) {
		return dao.addProduct(product);
	}

	/**
	 * Remove the Product object via DAO
	 * 
	 * @param productCode
	 * @return primary key of removed Product
	 */
	public Product removeProduct(String productCode) {
		return dao.removeProduct(productCode);
	}

	public Product updateProduct(Product product) {
		return dao.updateProduct(product);
	}
}
