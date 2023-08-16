package com.app.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Customer extends Person {

	private Cart cart;
	
	@OneToMany(mappedBy = "customer")
	private List<Order> orders=new ArrayList<>();
	
	@Column(name="total_payment_made")
	private Long totalPaymentMade;
}
