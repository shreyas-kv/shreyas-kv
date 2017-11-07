package com.niit.shreyasmobilesBackend.Dao;

import java.util.List;

import com.niit.shreyasmobilesBackend.model.Pay;

public interface PayDao {
	public boolean saveupdate(Pay pay);// true if succesful else false
	// s returned

public boolean delete(Pay pay);

public Pay get(String pid); 

public List<Pay> list(); 


}
