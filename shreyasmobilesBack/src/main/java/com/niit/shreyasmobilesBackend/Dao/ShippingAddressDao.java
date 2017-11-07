package com.niit.shreyasmobilesBackend.Dao;

import java.util.List;

import com.niit.shreyasmobilesBackend.model.ShippingAddress;


public interface ShippingAddressDao {
	public boolean saveupdate(ShippingAddress shippingaddress);
	public boolean delete(ShippingAddress shippingaddress);
	public ShippingAddress get(String b_id);
	public List<ShippingAddress> list();
	
	public List<ShippingAddress> getaddbyuser(String user_id);
}
