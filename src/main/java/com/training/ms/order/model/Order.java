package com.training.ms.order.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Component
public class Order {

	@Id
	int orderId;
	int customerId;
	int cartId;
	boolean isPaymentSuccessFul;
	Double orderValue;
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public boolean isPaymentSuccessFul() {
		return isPaymentSuccessFul;
	}
	public void setPaymentSuccessFul(boolean isPaymentSuccessFul) {
		this.isPaymentSuccessFul = isPaymentSuccessFul;
	}
	public Double getOrderValue() {
		return orderValue;
	}
	public void setOrderValue(Double orderValue) {
		this.orderValue = orderValue;
	}
	public Order(int orderId, int customerId, int cartId, boolean isPaymentSuccessFul, Double orderValue) {
		super();
		this.orderId = orderId;
		this.customerId = customerId;
		this.cartId = cartId;
		this.isPaymentSuccessFul = isPaymentSuccessFul;
		this.orderValue = orderValue;
	}
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
}

