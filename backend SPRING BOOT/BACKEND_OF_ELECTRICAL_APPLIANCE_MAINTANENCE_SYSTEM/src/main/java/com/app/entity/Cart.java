package com.app.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
	
	@OneToOne
	@MapsId("id")
	private Customer customer;
	
	@OneToMany(mappedBy = "cart",cascade = CascadeType.ALL,orphanRemoval = true)
	private List<Service> services=new ArrayList<>();
	
	@Column(name="time_stamp")
	private LocalDateTime timeStamp;
}
