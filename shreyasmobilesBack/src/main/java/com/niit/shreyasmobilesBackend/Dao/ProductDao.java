package com.niit.shreyasmobilesBackend.Dao;

import java.util.List;

import com.niit.shreyasmobilesBackend.model.Product;



public interface ProductDao {
	public boolean saveupdate(Product product);
	public boolean delete(Product product);
	public Product get(String pid);
	public List<Product> list(); 
	
	public List<Product> GetProductByCategory(String id);
	public List<Product> GetProductBySupplier(String id);

}
