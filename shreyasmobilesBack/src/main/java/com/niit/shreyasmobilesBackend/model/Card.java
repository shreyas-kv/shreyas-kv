package com.niit.shreyasmobilesBackend.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;



@Entity
@Table
@Component

public class Card {

	@Id
private	String card_id;
private	String card_no;
private	String card_name;
private	String card_expiry;

@ManyToOne
@JoinColumn(name="user_id")
User user;




public User getUser() {
	return user;
}

public void setUser(User user) {
	this.user = user;
}


public String getCard_expiry() {
	return card_expiry;
}
public void setCard_expiry(String card_expiry) {
	this.card_expiry = card_expiry;
}
public String getCard_id() {
	return card_id;
}
public void setCard_id(String card_id) {
	this.card_id = card_id;
}
public String getCard_no() {
	return card_no;
}
public void setCard_no(String card_no) {
	this.card_no = card_no;
}
public String getCard_name() {
	return card_name;
}
public void setCard_name(String card_name) {
	this.card_name = card_name;
}


}
