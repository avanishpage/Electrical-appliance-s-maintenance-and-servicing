package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.Order;

public interface OrderRepositoryIF extends JpaRepository<Order, Long>{

}
