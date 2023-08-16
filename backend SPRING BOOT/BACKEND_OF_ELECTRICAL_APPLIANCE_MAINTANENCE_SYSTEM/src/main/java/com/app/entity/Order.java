package com.app.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

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
public class Order {
	
	@Id
	private Long id;
	
	private Vendor vendor;
	
	
	private Customer customer;
	
	@OneToMany(mappedBy = "order")
	private List<Service> services=new ArrayList<>();
	
	@Enumerated
	@Column(name="job_status")
	private JobStatus jobStatus; 

	@OneToOne
	@MapsId("id")
	private Rating rating;
	
	private LocalDateTime timeStamp;
}
