package com.app.entity;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Id;

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
	private Long id;
	
	private String name;
	
	private String description;
	
	private Long price;
	
	@Enumerated
	private Category category;
	
	//we will do imgsrc afterwards
	//remember to delete this after completing
	
	private Vendor vendor;
	
	private Cart cart;
	
	private Order order;
	
	
}
