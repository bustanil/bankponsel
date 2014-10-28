package id.co.skyforce.bankponsel.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import id.co.skyforce.bankponsel.model.Product;
import id.co.skyforce.bankponsel.util.HibernateUtil;

public class ProductService {

	private Product listProduct;

	public static List<Product> getAll() {
		Session session = HibernateUtil.openSession();

		List<Product> listProduct = session.createQuery("from Product").list();

		session.close();
		return listProduct;
	}

	public Product getProduct(Integer productId){
		Session session = HibernateUtil.openSession();
		Product product= (Product) session.get(Product.class, productId);
		
		session.close();
		return product;
	}
	
	public Product getListProduct() {
		return listProduct;
	}

	public void setListProduct(Product listProduct) {
		this.listProduct = listProduct;
	}

}
