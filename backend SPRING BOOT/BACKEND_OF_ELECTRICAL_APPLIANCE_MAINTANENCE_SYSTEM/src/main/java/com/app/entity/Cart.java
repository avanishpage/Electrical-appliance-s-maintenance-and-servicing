package com.app.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
public class Cart {
	
	@Id
	private Long id;
	
	private Customer customer;
	
	@OneToMany(mappedBy = "cart")
	private List<Service> services=new ArrayList<>();
	
	@Column(name="time_stamp")
	private LocalDateTime timeStamp;
}
