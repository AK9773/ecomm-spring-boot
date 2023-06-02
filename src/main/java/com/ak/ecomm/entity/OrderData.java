package com.ak.ecomm.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class OrderData {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int orderId;
	private String address;
	private String mobile;
	private String email;
	private int userId;
	private int totalPrice;
	

	public OrderData() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderData(String address, String mobile, String email, int userId, int totalPrice) {
		super();
		this.address = address;
		this.mobile = mobile;
		this.email = email;
		this.userId = userId;
		this.totalPrice = totalPrice;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return "OrderData [orderId=" + orderId + ", address=" + address + ", mobile=" + mobile + ", email=" + email
				+ ", userId=" + userId + ", totalPrice=" + totalPrice + "]";
	}

}
