package com.niit.shreyasmobilesBackend.Dao;

import java.util.List;

import com.niit.shreyasmobilesBackend.model.Order;



public interface OrderDao {
	

	public boolean saveupdate(Order order);
	public boolean delete(Order order);
	public Order get(String orderid);
	public List<Order> list();

}
