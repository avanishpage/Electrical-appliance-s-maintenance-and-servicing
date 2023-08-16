package com.app.entity;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

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
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Vendor vendor;
	
	
	//private Customer customer;
	
	@Enumerated
	private Stars stars;
	
	private String Description;
	
	@OneToOne
	private Order order;
	
}
