package com.miracle.rabbitMQ.SpringBatch;

import java.util.List;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.miracle.rabbitMQ.config.MessageConfig;
import com.miracle.rabbitMQ.dto.Product;

@Component
public class MyQueueItemWriter implements ItemWriter<Product> {
	
	 @Autowired
	    private RabbitTemplate template;
    

	@Override
	public void write(List<? extends Product> products) throws Exception {
		 System.out.println("Data is being sent to queue : " + products);
		 template.convertAndSend(MessageConfig.EXCHANGE, MessageConfig.ROUTING_KEY, products.get(0));
		
	}
}
