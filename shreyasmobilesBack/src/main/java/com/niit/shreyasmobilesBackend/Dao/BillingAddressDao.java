package com.niit.shreyasmobilesBackend.Dao;

import java.util.List;

import com.niit.shreyasmobilesBackend.model.BillingAddress;


public interface BillingAddressDao {
	public boolean saveupdate(BillingAddress billingaddress);
	public boolean delete(BillingAddress billingaddress);
	public BillingAddress get(String b_id);
	public List<BillingAddress> list();


}
