package com.app.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Cart {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@OneToOne(fetch = FetchType.LAZY)
	@MapsId
	private Customer customer;
	
	@ManyToMany(mappedBy = "carts")
	private Set<Service> services=new HashSet<>();
	
	@Column(name="time_stamp")
	private LocalDateTime timeStamp;
	
	
	
	//helper methods of cart
	public void addCartToCustomer(Customer customer) {
		
		this.customer=customer;
		
		
	}
}
