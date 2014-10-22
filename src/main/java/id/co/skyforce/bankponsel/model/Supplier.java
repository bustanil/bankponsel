package id.co.skyforce.bankponsel.model;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name = "supplier")
public class Supplier{
	@Id
	@Column(name ="id",nullable = false)
	private int id;
	
	@Column(name ="name",nullable = false, length = 50)
	private String name;
	
	@Column(name ="address",nullable = false, length = 50)
	private String address;

	@OneToMany(mappedBy = "supplier")
	private Set<Product> product = new HashSet<>();
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
}
