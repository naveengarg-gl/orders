package com.training.ms.order.event.listener;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

import org.springframework.stereotype.Component;

import com.training.ms.order.event.producer.EventProducer;
import com.training.ms.order.model.Event;
import com.training.ms.order.model.Order;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Component
public class Consumer {

    private final List<String> messages = new ArrayList<>();
    
    private Logger logger = LoggerFactory.getLogger(this.getClass());
	 @Autowired
	    EventProducer eventProducer;
	 
    @KafkaListener(topics = "PAYMENT_SUCCESSFULL", groupId = "kafka-sandbox-1")
    public void listen(String message) {
    	logger.info("Message is Listened in Order MS as-"+message);
        synchronized (messages) {
        	System.out.println("Message is Listened in Order MS as-"+message);
            messages.add(message);
            
            System.out.println("Payment Message Received ="+message);
	       
	        	Event event = new Event();
	        	event.setMessageId(123);
	        	event.setMessage(message);
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
    public List<String> getMessages() {
        return messages;
    }
}