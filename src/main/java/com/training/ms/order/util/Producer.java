package com.training.ms.order.util;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Producer {
	/*
	 * private KafkaTemplate<String, String> template; public
	 * Producer(KafkaTemplate<String, String> template) { this.template = template;
	 * }
	 * 
	 * @GetMapping("/kafka/produce") public void produce(@RequestParam String
	 * message) {
	 * 
	 * template.send("test", message); }
	 */

}
