package com.miracle.rabbitMQ.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.miracle.rabbitMQ.dto.Product;

public interface ProductDao extends JpaRepository<Product, Integer> {

}
