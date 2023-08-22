package com.app.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.Order;
import com.app.enums.JobStatus;

public interface OrderRepositoryIF extends JpaRepository<Order, Long>{
	
	public ArrayList<Order> findByJobStatus(JobStatus jobstatus);
<<<<<<< HEAD
=======

>>>>>>> 206d3803727cf7a86fa94202d094b6e41dc65825
	
}
