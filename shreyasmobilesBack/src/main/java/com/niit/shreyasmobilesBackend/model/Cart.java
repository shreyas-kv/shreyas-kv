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
public class Cart {
	@Id
	private String cart_id;
	private int tot_items=0;
	private double total=0.0;
	
	@OneToMany(mappedBy="cart")
	List<CartItems> cartitems;
	
	
	public Cart() {
		this.cart_id = "CART"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}
	
	public List<CartItems> getCartitems() {
		return cartitems;
	}
	public void setCartitems(List<CartItems> cartitems) {
		this.cartitems = cartitems;
	}
	public String getCart_id() {
		return cart_id;
	}
	public void setCart_id(String cart_id) {
		this.cart_id = cart_id;
	}
	public int getTot_items() {
		return tot_items;
	}
	public void setTot_items(int tot_items) {
		this.tot_items = tot_items;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	
	
		
}
