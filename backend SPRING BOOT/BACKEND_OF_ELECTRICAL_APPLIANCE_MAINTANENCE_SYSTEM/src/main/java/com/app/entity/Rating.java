package com.app.entity;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import com.app.enums.Stars;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Rating {

	@Id
	private Long id;
	
	private Vendor vendor;
	private Customer customer;
	
	@Enumerated
	private Stars stars;
	
	private String Description;
	
	private Order order;
	
}
