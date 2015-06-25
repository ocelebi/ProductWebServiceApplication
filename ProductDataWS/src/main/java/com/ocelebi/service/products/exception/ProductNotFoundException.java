package com.ocelebi.service.products.exception;

public class ProductNotFoundException extends RuntimeException {

    /**
     * 
     */
    private static final long serialVersionUID = -7925839629977737559L;

    public ProductNotFoundException(String message) {
        super(message);
    }

}
