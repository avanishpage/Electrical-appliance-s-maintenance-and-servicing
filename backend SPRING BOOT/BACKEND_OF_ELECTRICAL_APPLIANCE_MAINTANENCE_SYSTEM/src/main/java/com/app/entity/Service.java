package com.app.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
	
	//we will do imgsrc afterwards
	//remember to delete this after completing
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Vendor vendor;
	
	
	@ManyToMany
	@JoinTable(name = "service_cart",
	joinColumns = @JoinColumn(name="service_id"),
	inverseJoinColumns=@JoinColumn(name="cart_id")
	)
	private Set<Cart> carts=new HashSet<>();
	
	
	@ManyToMany
	@JoinTable(name = "service_order",
	joinColumns = @JoinColumn(name="service_id"),
	inverseJoinColumns=@JoinColumn(name="order_id")
	)
	private Set<Order> orders=new HashSet<>();
	
}
