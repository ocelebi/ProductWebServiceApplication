package com.ocelebi.service.products.dao;

import java.util.List;

import com.ocelebi.service.products.model.Product;

public interface DAO {

	/**
	 * Is used to get all Product data from database
	 * 
	 * @return List Product
	 */
	List<Product> getProductList();

	/**
	 * Is used to get specific product form database
	 * 
	 * @param id
	 *            : Product id
	 * @return Product
	 */
	Product getProduct(String productCode);

	/**
	 * Is used to add a Product to database
	 * 
	 * @param product
	 * @return the added Product id
	 */
	Product addProduct(Product product);

	/**
	 * Is used to remove the Product from database
	 * 
	 * @param product
	 * @return the removed Product id
	 */
	Product removeProduct(String productCode);

	Product updateProduct(Product product);
}
