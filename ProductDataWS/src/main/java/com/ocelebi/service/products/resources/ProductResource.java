package com.ocelebi.service.products.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.ocelebi.service.products.model.Product;
import com.ocelebi.service.products.service.ProductService;

@Path("/products")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProductResource {

	public ProductResource() {
		System.out.println("hit to resource constructor");
	}

	@GET
	@Path("{productCode}")
	public Product getProduct(@PathParam("productCode") String productCode) {
		System.out.println("hit to ProductResource:getProduct" + productCode);
		return ProductService.getInstance().getProduct(productCode);
	}

	@POST
	public Response createProduct(Product product) {

		String result = null;
		if (product != null) {
			System.out.println("At server " + product.toString());
			// Add Product to db

			product = ProductService.getInstance().addProduct(product);
			if (product != null) {
				result = "Product saved : " + product;
				return Response.status(201).entity(result).build();
			}
		}
		result = "Internal Error. Not added to db";
		return Response.status(500).entity(result).build();

	}

	@PUT
	@Path("{productCode}")
	public Response updateProduct(@PathParam("productCode") String productCode,
			Product product) {
		String result = null;
		if (product != null) {
			System.out.println("At server " + product.toString());
			product.setProductCode(productCode);
			// Update Product to db
			product = ProductService.getInstance().updateProduct(product);
			if (product != null) {
				result = "Product updated : " + product;
				return Response.status(200).entity(result).build();
			}
		}
		result = "Internal Error. Not updated";
		return Response.status(500).entity(result).build();
	}

	@DELETE
	@Path("{productCode}")
	public Response deleteProduct(@PathParam("productCode") String productCode) {
	        System.out.println("Hit to delete" + productCode);
		Product product = ProductService.getInstance().deleteProduct(
				productCode);
		String result = null;
		if (product != null) {
			result = "Product is deleted" + product;
			return Response.status(200).entity(result).build();
		} else {
			result = "Product not deleted server error";
			return Response.status(500).entity(result).build();
		}
	}


	@GET
	public List<Product> getAllProducts() {
		System.out.println("Hit here");
		return ProductService.getInstance().getAllProducts();
	}
}
