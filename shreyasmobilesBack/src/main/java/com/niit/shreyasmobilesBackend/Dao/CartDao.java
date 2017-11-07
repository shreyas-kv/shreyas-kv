package com.niit.shreyasmobilesBackend.Dao;

import java.util.List;

import com.niit.shreyasmobilesBackend.model.Cart;

public interface CartDao {
	public boolean saveupdate(Cart cart);
	public boolean delete(Cart cart);
	public Cart get(String cartid);
	public List<Cart> list();

}
