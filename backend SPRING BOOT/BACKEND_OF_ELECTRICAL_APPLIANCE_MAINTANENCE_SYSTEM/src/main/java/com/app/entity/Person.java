package com.app.entity;

import javax.persistence.*;

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
