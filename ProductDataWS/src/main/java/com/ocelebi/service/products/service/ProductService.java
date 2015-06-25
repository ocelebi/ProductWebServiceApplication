package com.ocelebi.service.products.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.ocelebi.service.products.controller.DAOController;
import com.ocelebi.service.products.daoimpl.HibernateDAOImpl;
import com.ocelebi.service.products.exception.ProductNotFoundException;
import com.ocelebi.service.products.model.Product;

public class ProductService {

    private static ProductService productService;
    // Map<Long, Product> products = new DatabaseClass().getProducts();

    DAOController daoControler = new DAOController(new HibernateDAOImpl());

    private ProductService() {

        System.out.println("adding rows");
        daoControler.addProduct(new Product("A101-01-01", "Peynir", "Tahsildarooglu", "25TL", new Date(), createDate(
                2015, 10, 12), "Tahsildarooglu Peynir", 400));
        daoControler.addProduct(new Product("A101-01-02", "Yumurta", "Kenkinoglu", "12TL", new Date(), createDate(2015,
                10, 15), "Kenkinoglu Yumurta", 1000));
    }

    private Date createDate(int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);
        return calendar.getTime();
    }

    public static ProductService getInstance() {

        if (productService == null) {
            synchronized (ProductService.class) {
                if (productService == null) {
                    productService = new ProductService();
                }
            }
        }
        return productService;
    }

    public List<Product> getAllProducts() {
        return new ArrayList<Product>(daoControler.getProductList());
    }

    public Product getProduct(String productCode) throws ProductNotFoundException{
        Product product = daoControler.getProduct(productCode);
        if (product == null) {
            System.out.println("orhan datanotfound");
            throw new ProductNotFoundException("Product with id " + productCode + " not found");
        }
        return product;
    }

    public Product addProduct(Product product) {
        return daoControler.addProduct(product);
    }

    public Product updateProduct(Product product) {
        return daoControler.updateProduct(product);
    }

    public Product deleteProduct(String productCode) {
        return daoControler.removeProduct(productCode);
    }

}
