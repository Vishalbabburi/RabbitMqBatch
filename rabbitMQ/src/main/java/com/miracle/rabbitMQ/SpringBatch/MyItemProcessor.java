package com.miracle.rabbitMQ.SpringBatch;



import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.miracle.rabbitMQ.dto.Product;

@Component
public class MyItemProcessor implements ItemProcessor<Product, Product> {
    @Override
    public Product process(Product product) throws Exception {
        String name = product.getProduct_name();
        String uppercase_name =name.toUpperCase();
        System.out.println(String.format("Converted from [%s] to [%s]", name, uppercase_name));
        return product;
    }
}
