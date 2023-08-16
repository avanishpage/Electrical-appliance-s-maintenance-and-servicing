package com.app.entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class Person {
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name="first_name")
	private String firstName;

	@Column(name="last_name")
	private String lastName;
	
	private String email;
	
	private String password;
	
	private String address;
	
	@Column(name = "phone_number")
	private String phoneNumber;
	
	
	
}
