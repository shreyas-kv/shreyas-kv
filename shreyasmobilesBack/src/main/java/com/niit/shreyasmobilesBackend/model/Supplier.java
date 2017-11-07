package com.niit.shreyasmobilesBackend.model;

import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class Supplier {
	
	@Id
	private String sup_id;
	private String sup_name;
	private String sup_addr;
	private String sup_phno;
	
	@OneToMany(mappedBy="supplier")
	private List<Product> product;
	
	
	public List<Product> getProduct() {
		return product;
	}
	public void setProduct(List<Product> product) {
		this.product = product;
	}
	public Supplier() {
			this.sup_id = "SUP"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}
	public String getSup_name() {
		return sup_name;
	}
	public void setSup_name(String sup_name) {
		this.sup_name = sup_name;
	}
	public String getSup_id() {
		return sup_id;
	}
	public void setSup_id(String sup_id) {
		this.sup_id = sup_id;
	}
	public String getSup_addr() {
		return sup_addr;
	}
	public void setSup_addr(String sup_addr) {
		this.sup_addr = sup_addr;
	}
	public String getSup_phno() {
		return sup_phno;
	}
	public void setSup_phno(String sup_phno) {
		this.sup_phno = sup_phno;
	}
	
	

}
