package id.co.skyforce.bankponsel.service;

import java.util.List;

import org.hibernate.Session;

import id.co.skyforce.bankponsel.model.Product;
import id.co.skyforce.bankponsel.util.HibernateUtil;

public class ProductService {

	private Product listProduct;
	public static  List<Product> getAll(){
		Session session = HibernateUtil.openSession();
		
		List<Product> listProduct = session.createQuery("from Product").list();
		
		session.close();
		return listProduct;
	}
	public Product getListProduct() {
		return listProduct;
	}
	public void setListProduct(Product listProduct) {
		this.listProduct = listProduct;
	}
	
	
}
