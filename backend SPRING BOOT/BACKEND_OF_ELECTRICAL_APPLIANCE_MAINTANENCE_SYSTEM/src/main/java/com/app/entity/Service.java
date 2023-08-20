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
import lombok.NoArgsConstructor;

//@Getter
//@Setter
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Vendor getVendor() {
		return vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}

	public Set<Cart> getCart() {
		return carts;
	}

	


	public Set<Cart> getCarts() {
		return carts;
	}

	public void setCarts(Set<Cart> carts) {
		this.carts = carts;
	}

	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}
	
	
}
