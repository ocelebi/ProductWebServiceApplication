package com.ocelebi.service.products.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.ocelebi.service.products.model.ErrorProduct;

@Provider
public class ProductNotFoundExceptionMapper implements ExceptionMapper<ProductNotFoundException> {

    @Override
    public Response toResponse(ProductNotFoundException ex) {
        System.out.println("orhan hit to Mapper");
        ErrorProduct errorProduct = new ErrorProduct(ex.getMessage(), 404, "");
        return Response.status(Status.NOT_FOUND).entity(errorProduct).build();
    }

}
