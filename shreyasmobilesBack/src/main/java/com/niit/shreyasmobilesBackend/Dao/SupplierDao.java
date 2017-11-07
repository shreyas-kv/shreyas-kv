package com.niit.shreyasmobilesBackend.Dao;

import java.util.List;

import com.niit.shreyasmobilesBackend.model.Supplier;

public interface SupplierDao {
	public boolean saveupdate(Supplier supplier);
	public boolean delete(Supplier supplier);
	public Supplier get(String sid);
	public List<Supplier> list();
}
