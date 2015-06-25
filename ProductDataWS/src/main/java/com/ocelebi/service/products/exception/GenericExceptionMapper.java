package com.ocelebi.service.products.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.ocelebi.service.products.model.ErrorProduct;

@Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable> {

    @Override
    public Response toResponse(Throwable ex) {
        System.out.println("generic orhan");
        ErrorProduct errorProduct = new ErrorProduct(ex.getMessage(), 500, "http://javabrains.koushik.org");
        return Response.status(Status.INTERNAL_SERVER_ERROR).entity(errorProduct).build();
    }

}
