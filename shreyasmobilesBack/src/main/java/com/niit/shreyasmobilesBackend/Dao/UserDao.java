package com.niit.shreyasmobilesBackend.Dao;

import java.util.List;

import com.niit.shreyasmobilesBackend.model.User;



public interface UserDao {

	public boolean saveupdate(User user);
	public boolean delete(User user);
	public User get(String uid);
	public List<User> list();
	public User isvalid(String email,String pwd);
	public User getuseremail(String email);
}
