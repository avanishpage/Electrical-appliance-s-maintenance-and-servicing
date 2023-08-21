package com.app.entity;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
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
<<<<<<< HEAD
	@GeneratedValue(strategy = GenerationType.IDENTITY)
=======
>>>>>>> 549cea8c3d2101981626d166f7c0bd9d12c477c5
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "vendor_id")
	private Vendor vendor;
	
		
	@OneToOne(fetch = FetchType.LAZY)
	@MapsId
	@JoinColumn(name = "order_id")
	private Order order;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="order_id")
	@MapsId
	private Order order;
	
	
	
	@Enumerated
	private Stars stars;
	
	private String Description;
<<<<<<< HEAD
	
	
	
=======
>>>>>>> 549cea8c3d2101981626d166f7c0bd9d12c477c5
}
