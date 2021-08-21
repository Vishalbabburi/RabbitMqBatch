package com.miracle.rabbitMQ.consumers;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.miracle.rabbitMQ.Dao.ProductDao;
import com.miracle.rabbitMQ.config.MessageConfig;
import com.miracle.rabbitMQ.dto.Product;


@Component
public class Consumer {
	
	@Autowired
	ProductDao productdao;

    @RabbitListener(queues = MessageConfig.QUEUE)
    public void consumeMessageFromQueue(Product product) {
        System.out.println("Message recieved from queue : " + product);
        productdao.save(product);
    }
}