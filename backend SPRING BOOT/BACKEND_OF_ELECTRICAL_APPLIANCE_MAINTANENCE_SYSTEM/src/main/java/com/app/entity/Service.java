package com.app.entity;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.app.enums.Category;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Service {

	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	
	private String description;
	
	private Long price;
	
	@Enumerated
	private Category category;
	
	//we will do image source afterwards
	//remember to delete this after completing
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Vendor vendor;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Cart cart;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Order order;
	
}
