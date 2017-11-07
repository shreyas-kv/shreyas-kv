package com.niit.shreyasmobilesBackend.Dao;

import java.util.List;

import com.niit.shreyasmobilesBackend.model.Authentication;

public interface AuthenticationDao {

	public boolean saveupdate(Authentication authentication);// true if

	public boolean delete(Authentication authentication);

	public Authentication get(String aid); // returns a authentication given id

	public List<Authentication> list(); 

}
