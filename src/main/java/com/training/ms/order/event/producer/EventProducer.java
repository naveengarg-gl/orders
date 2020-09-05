package com.training.ms.order.event.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import com.training.ms.order.model.Event;

@Component
public class EventProducer {
	
	 @Autowired
	 private KafkaTemplate<String, Event> template;
	
	
	     public void produce(Event event) {
	         template.send("ORDER_CREATED", event);
	     }
}
