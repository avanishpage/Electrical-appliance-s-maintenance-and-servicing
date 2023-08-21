package com.app.entity;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.app.enums.JobStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "vendor_id")
	private Vendor vendor;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
	private Customer customer;
	
	@ManyToMany(mappedBy = "orders")
	private Set<Service> services=new HashSet<>();
	
	@Enumerated
	@Column(name="job_status")
	private JobStatus jobStatus; 

<<<<<<< HEAD
=======
	@OneToOne(mappedBy = "order")
	private Rating rating;
>>>>>>> 549cea8c3d2101981626d166f7c0bd9d12c477c5
	
	private LocalDateTime timeStamp;
	
	public void giveRating(Rating rating) {
		this.rating = rating;
		rating.setOrder(this);
	}
}
