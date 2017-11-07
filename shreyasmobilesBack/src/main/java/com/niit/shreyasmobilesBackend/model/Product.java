package com.niit.shreyasmobilesBackend.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Table
@Component
public class Product {
	@Id
	private String prod_id;
	private String prod_name;
	private String prod_qty;
	private double prod_price;
	private String prod_desc;
	
	@Transient //this attribute doesnot appear in database
	private MultipartFile prod_img;
	
	@ManyToOne
	@JoinColumn(name="cat_id")
	private Category category;
	
	@ManyToOne
	@JoinColumn(name="sup_id")
	private Supplier supplier;
	
	
	
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Supplier getSupplier() {
		return supplier;
	}
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	
	
	
	public Product(){
	
		this.prod_id = "PRO"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}
	public String getProd_id() {
		return prod_id;
	}
	public void setProd_id(String prod_id) {
		this.prod_id = prod_id;
	}
	public String getProd_name() {
		return prod_name;
	}
	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}
	public String getProd_qty() {
		return prod_qty;
	}
	public void setProd_qty(String prod_qty) {
		this.prod_qty = prod_qty;
	}
	public double getProd_price() {
		return prod_price;
	}
	public void setProd_price(double prod_price) {
		this.prod_price = prod_price;
	}
	public String getProd_desc() {
		return prod_desc;
	}
	public void setProd_desc(String prod_desc) {
		this.prod_desc = prod_desc;
	}
	public MultipartFile getProd_img() {
		return prod_img;
	}
	public void setProd_img(MultipartFile prod_img) {
		this.prod_img = prod_img;
	}
	
	

}
