package com.training.ms.order.event.listener;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

import com.training.ms.order.model.Event;
import com.training.ms.order.model.Order;
import com.training.ms.order.event.producer.EventProducer;

public class EventListener {
	
	 @Autowired
	    EventProducer eventProducer;
	   
	    @KafkaListener(topics = "test", groupId = "kafka-sandbox-1")
	    public void listen(String message) {
	    	
	    	System.out.println("Payment Message Received ="+message);
	        synchronized (message) {
	        	Event event = new Event();
	        	event.setMessageId(123);
	        	event.setMessage("Order Created");
	        	Order order = new Order();
	        	order.setCartId(1);
	        	order.setCustomerId(1);
	        	order.setOrderId(1000);
	        	order.setOrderValue(200.0);
	        	order.setPaymentSuccessFul(true);
	        	Map<String,Order> orderPayloadMap = new LinkedHashMap<String,Order>();
	        	orderPayloadMap.put("messagePayload", order);
	        	event.setMessagePayload(orderPayloadMap);
	        	eventProducer.produce(event);
	        }
	           
	    }

}
