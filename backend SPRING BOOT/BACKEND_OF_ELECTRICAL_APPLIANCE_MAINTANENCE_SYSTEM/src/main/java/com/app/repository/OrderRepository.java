package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
