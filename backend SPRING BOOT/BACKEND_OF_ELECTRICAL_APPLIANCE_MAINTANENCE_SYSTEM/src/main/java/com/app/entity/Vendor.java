package com.app.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Vendor extends Person{
	@OneToMany(mappedBy = "id")
	private List<Service> services=new ArrayList<>();
	
	@OneToMany(mappedBy = "id")
	private List<Order> orders=new ArrayList<>();
	
	@OneToMany(mappedBy = "id")
	private List<Rating> ratings=new ArrayList<>();
	
}
