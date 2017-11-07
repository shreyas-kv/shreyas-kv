package com.niit.shreyasmobilesBackend.Dao;

import java.util.List;

import com.niit.shreyasmobilesBackend.model.Card;

public interface CardDao {
	public boolean saveupdate(Card card);// true if succesful else false
	// s returned

public boolean delete(Card card);

public Card get(String cardid); // returns a category given id

public List<Card> list(); // returns list of categories

public List<Card> getcardbyuser(String user_id);
}
