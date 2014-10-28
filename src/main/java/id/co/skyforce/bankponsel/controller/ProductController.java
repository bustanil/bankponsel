package id.co.skyforce.bankponsel.controller;

import java.math.BigDecimal;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import id.co.skyforce.bankponsel.model.Product;
import id.co.skyforce.bankponsel.service.ProductService;


@ManagedBean
public class ProductController {

	// Product product = new Product();
	// ProductService productService = new ProductService();
	//
	// List<Product> listProduct;
	//
	// public ProductController() {
	//
	// listProduct = new ArrayList<>();
	// productService = new ProductService();
	// product = new Product();
	// listProduct = productService.getAll();
	// }
	//
	// public String viewProduct() {
	// listProduct = productService.getAll();
	// return "listItem";
	// }
	//
	// public Product getProduct() {
	// return product;
	// }
	//
	// public void setProduct(Product product) {
	// this.product = product;
	// }
	//
	// public ProductService getProductService() {
	// return productService;
	// }
	//
	// public void setProductService(ProductService productService) {
	// this.productService = productService;
	// }
	//
	// public List<Product> getListProduct() {
	// return listProduct;
	// }
	//
	// public void setListProduct(List<Product> listProduct) {
	// this.listProduct = listProduct;
	// }

	private String name;
	private String code;
	private Integer id;
	private Integer supplierId;
	private BigDecimal price;
	private BigDecimal margin;
	private BigDecimal sharePercentage;
	Product product;
	List<Product> listProduct;
	ProductService productService = new ProductService();

	public ProductController() {
		String idp = FacesContext.getCurrentInstance().getExternalContext()
				.getRequestParameterMap().get("id");
		if (idp != null) {
			id = Integer.valueOf(idp);
			product = productService.getProduct(id);
			this.name = product.getName();
			this.price = product.getPrice();
			this.margin = product.getMargin();
			this.sharePercentage = product.getSharePercentage();

		}else{
			listProduct = productService.getAll();
		}
	}


	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Integer supplierId) {
		this.supplierId = supplierId;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getMargin() {
		return margin;
	}

	public void setMargin(BigDecimal margin) {
		this.margin = margin;
	}

	public BigDecimal getSharePercentage() {
		return sharePercentage;
	}

	public void setSharePercentage(BigDecimal sharePercentage) {
		this.sharePercentage = sharePercentage;
	}

	public List<Product> getListProduct() {
		return listProduct;
	}

	public void setListProduct(List<Product> listProduct) {
		this.listProduct = listProduct;
	}

	public ProductService getProductService() {
		return productService;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

}
