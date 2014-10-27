package id.co.skyforce.bankponsel.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import id.co.skyforce.bankponsel.model.Product;
import id.co.skyforce.bankponsel.service.ProductService;

@ManagedBean
public class ProductController {

	Product product = new Product();
	ProductService productService = new ProductService();

	List<Product> listProduct;

	public ProductController() {
		listProduct = new ArrayList<>();
		productService = new ProductService();
		product = new Product();
		listProduct = ProductService.getAll();
	}
	
	public String viewProduct(){
		listProduct = ProductService.getAll();
		return "listItem";
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public ProductService getProductService() {
		return productService;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	public List<Product> getListProduct() {
		return listProduct;
	}

	public void setListProduct(List<Product> listProduct) {
		this.listProduct = listProduct;
	}
	
	

}
