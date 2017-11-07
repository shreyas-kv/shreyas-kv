package com.niit.shreyasmobilesBackend.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component

public class BillingAddress {
	@Id
	private String b_id;
	private String b_hno;
	private String b_street;
	private String b_locality;
	private String b_city;
	private String b_state;
	private String b_pincode;
	
	public BillingAddress() {
	
		this.b_id = "BILL"+UUID.randomUUID().toString().substring(10).toUpperCase();
	}

	public String getB_id() {
		return b_id;
	}

	public void setB_id(String b_id) {
		this.b_id = b_id;
	}

	public String getB_hno() {
		return b_hno;
	}

	public void setB_hno(String b_hno) {
		this.b_hno = b_hno;
	}

	public String getB_street() {
		return b_street;
	}

	public void setB_street(String b_street) {
		this.b_street = b_street;
	}

	public String getB_locality() {
		return b_locality;
	}

	public void setB_locality(String b_locality) {
		this.b_locality = b_locality;
	}

	public String getB_city() {
		return b_city;
	}

	public void setB_city(String b_city) {
		this.b_city = b_city;
	}

	public String getB_state() {
		return b_state;
	}

	public void setB_state(String b_state) {
		this.b_state = b_state;
	}

	public String getB_pincode() {
		return b_pincode;
	}

	public void setB_pincode(String b_pincode) {
		this.b_pincode = b_pincode;
	}
	
	


}
