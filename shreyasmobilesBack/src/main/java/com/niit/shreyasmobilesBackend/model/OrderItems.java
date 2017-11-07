package com.niit.shreyasmobilesBackend.model;

import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component

public class OrderItems {
	@Id
	private String orderitem_id;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "order_Id")
	
	private Order order;
	private String pid;
	public OrderItems() {
		
		this.orderitem_id = "ORDERITEM"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}
	public String getOrderitem_id() {
		return orderitem_id;
	}
	public void setOrderitem_id(String orderitem_id) {
		this.orderitem_id = orderitem_id;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	
	
	
}
