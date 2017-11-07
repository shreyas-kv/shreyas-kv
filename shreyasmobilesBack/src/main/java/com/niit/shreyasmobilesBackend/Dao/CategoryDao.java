package com.niit.shreyasmobilesBackend.Dao;

import java.util.List;

import com.niit.shreyasmobilesBackend.model.Category;

public interface CategoryDao 
{	
	public boolean saveupdate(Category category);
	public boolean delete(Category category);
	public Category get(String cid);
	public List<Category> list();  // returns list of all categories
}
