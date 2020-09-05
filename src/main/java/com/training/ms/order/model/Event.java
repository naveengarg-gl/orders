package com.training.ms.order.model;

import java.util.Map;

public class Event {
	
	int messageId;
	String message;
	Map<String,Order> messagePayload;
	public int getMessageId() {
		return messageId;
	}
	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Map<String, Order> getMessagePayload() {
		return messagePayload;
	}
	public void setMessagePayload(Map<String, Order> messagePayload) {
		this.messagePayload = messagePayload;
	}
	public Event(int messageId, String message, Map<String, Order> messagePayload) {
		super();
		this.messageId = messageId;
		this.message = message;
		this.messagePayload = messagePayload;
	}
	public Event() {
		super();
		// TODO Auto-generated constructor stub
	}
}
