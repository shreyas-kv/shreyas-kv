package com.niit.shreyasmobilesBackend.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;


@Entity
@Table
@Component
public class CartItems {
	@Id
	private String cartItem_id;
	private double cartItem_price;
	
	
	@OneToOne
	@JoinColumn(name="prod_id")
	private Product product;
	
	@ManyToOne
	@JoinColumn(name="cart_id")
	private Cart cart;
	
	public CartItems() {
		this.cartItem_id = "CARTITEM"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}
	
	public String getCartItem_id() {
		return cartItem_id;
	}
	public void setCartItem_id(String cartItem_id) {
		this.cartItem_id = cartItem_id;
	}
	public double getCartItem_price() {
		return cartItem_price;
	}
	public void setCartItem_price(double cartItem_price) {
		this.cartItem_price = cartItem_price;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	
	

}
