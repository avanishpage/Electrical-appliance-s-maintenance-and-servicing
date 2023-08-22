package com.app.entity;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Address {
	private String flatNo;
	
	private String area;
	
	private String city;
	
	private String district;
	
	private String state;
	
	private String country;
	
	private String countryCode;
	
	
}
