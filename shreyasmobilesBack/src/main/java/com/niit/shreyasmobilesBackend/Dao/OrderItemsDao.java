package com.niit.shreyasmobilesBackend.Dao;

import java.util.List;

import com.niit.shreyasmobilesBackend.model.OrderItems;

public interface OrderItemsDao {
	public boolean saveupdate(OrderItems orderItems);
	public boolean delete(OrderItems orderItems);
	public OrderItems get(String orderItemsid);
	public List<OrderItems> list();
}
