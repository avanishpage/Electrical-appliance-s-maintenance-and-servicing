package com.app.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
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
	@GeneratedValue
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Vendor vendor;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Customer customer;
	
	@OneToMany(mappedBy = "order",cascade = CascadeType.ALL,orphanRemoval = true)
	private List<Service> services=new ArrayList<>();
	
	@Enumerated
	@Column(name="job_status")
	private JobStatus jobStatus; 

	@OneToOne
	@MapsId("id")
	private Rating rating;
	
	private LocalDateTime timeStamp;
}
